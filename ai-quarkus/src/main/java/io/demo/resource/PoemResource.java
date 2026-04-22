package io.demo.resource;

import io.demo.entity.Poem;
import io.demo.model.PoemRating;
import io.demo.service.PoemGeneratorService;
import io.demo.service.PoemRatingService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/poem")
public class PoemResource {

    @Inject
    PoemGeneratorService poemGeneratorService;
    
    @Inject
    PoemRatingService poemRatingService;
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Transactional
    public String poem(@QueryParam("topic") String topic) {
        String poemTopic = topic != null ? topic : "quarkus";
        String poemContent = poemGeneratorService.writeAPoem(poemTopic);
        
        // Rate the poem using AI with structured output
        PoemRating poemRating = poemRatingService.ratePoem(poemContent);
        
        // Persist the poem with rating and reason to the database
        Poem poem = new Poem(poemTopic, poemContent, poemRating.rating(), poemRating.reason());
        poem.persist();
        
        return poemContent;
    }
    
    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Poem> listPoems() {
        return Poem.listAll();
    }
}
