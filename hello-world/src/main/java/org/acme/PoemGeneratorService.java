package org.acme;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;
import jakarta.enterprise.context.ApplicationScoped;

@RegisterAiService
@ApplicationScoped
public interface PoemGeneratorService {

    @SystemMessage("You are a haiku poet. Generate only haiku poems (3 lines: 5-7-5 syllables). Return only the poem text, no explanations or additional text.")
    @UserMessage("Write a haiku about {topic}")
    String generateHaiku(String topic);
}
