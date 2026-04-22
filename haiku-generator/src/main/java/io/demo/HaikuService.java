package io.demo;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;

@RegisterAiService
public interface HaikuService {

    @SystemMessage("You are a haiku poet. Generate beautiful haiku poems following the traditional 5-7-5 syllable structure. Only respond with the haiku poem, nothing else.")
    @UserMessage("Write a haiku about: {topic}")
    String generateHaiku(String topic);
}
