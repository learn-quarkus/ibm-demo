package io.demo;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/haiku")
public class HaikuResource {

    @Inject
    HaikuService haikuService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Transactional
    public String generateHaiku(@QueryParam("topic") String topic, @QueryParam("count") Integer count) {
        if (topic == null || topic.isBlank()) {
            topic = "nature";
        }
        
        if (count == null || count < 1) {
            count = 1;
        }
        
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < count; i++) {
            String haikuText = haikuService.generateHaiku(topic);
            
            // Persist the haiku to database
            Haiku haiku = new Haiku(topic, haikuText);
            haiku.persist();
            
            result.append(haikuText);
            if (i < count - 1) {
                result.append("\n\n---\n\n");
            }
        }
        
        return result.toString();
    }

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Haiku> listAllHaikus() {
        return Haiku.listAll();
    }
}
