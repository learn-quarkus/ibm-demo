package org.acme;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/poems")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PoemResource {

    @Inject
    PoemGeneratorService poemGeneratorService;

    @GET
    @Path("/generate")
    @Transactional
    public Response generatePoem(@QueryParam("topic") String topic) {
        if (topic == null || topic.trim().isEmpty()) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Topic parameter is required")
                    .build();
        }

        String haiku = poemGeneratorService.generateHaiku(topic);
        
        Poem poem = new Poem(topic, haiku);
        poem.persist();

        return Response.status(Response.Status.CREATED).entity(poem).build();
    }

    @GET
    public List<Poem> getAllPoems() {
        return Poem.listAll();
    }

    @GET
    @Path("/topic/{topic}")
    public List<Poem> getPoemsByTopic(@PathParam("topic") String topic) {
        return Poem.list("topic", topic);
    }

    @GET
    @Path("/{id}")
    public Response getPoemById(@PathParam("id") Long id) {
        Poem poem = Poem.findById(id);
        if (poem == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(poem).build();
    }
}
