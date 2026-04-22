package io.demo.service;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;
import jakarta.enterprise.context.ApplicationScoped;

@RegisterAiService
@ApplicationScoped
public interface PoemGeneratorService {

    
    // @SystemMessage("You are a professional poet.")
    @SystemMessage("You are a professional poet who only writes Haikoos for technical sales audience.")
    @UserMessage("""
                Write a poem about {topic}.
            """)
    String writeAPoem(String topic);
    
}
