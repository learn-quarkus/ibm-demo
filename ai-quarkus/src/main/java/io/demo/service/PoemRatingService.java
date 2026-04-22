package io.demo.service;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import io.demo.model.PoemRating;
import io.quarkiverse.langchain4j.RegisterAiService;
import jakarta.enterprise.context.ApplicationScoped;

@RegisterAiService
@ApplicationScoped
public interface PoemRatingService {

    @SystemMessage("You are a poetry critic. Rate poems on a scale of 1 to 5, where 1 is poor and 5 is excellent. Consider creativity, imagery, rhythm, and emotional impact.")
    @UserMessage("Rate this poem:\n\n{poem}")
    PoemRating ratePoem(String poem);
}
