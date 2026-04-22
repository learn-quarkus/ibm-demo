package org.acme;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    @Inject
    GreetingGeneratorService greetingGeneratorService;
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(@QueryParam("language") String language) {
        return greetingGeneratorService.sayHello(language);
    }
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/poem")
    public String poem(@QueryParam("language") String language) {
        return greetingGeneratorService.sayHello(language);
    }
}
