package org.acme;


import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;
import jakarta.enterprise.context.ApplicationScoped;


@RegisterAiService
@ApplicationScoped
public interface GreetingGeneratorService {
  
   @SystemMessage("Say Hello World in 10 different languages, and mention the language name in the response. Try not to repeat the same language in subsequent calls.")
   @UserMessage("""
               Say hello in {language}.
           """)
   String sayHello(String language);
  
}



