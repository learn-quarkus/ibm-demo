package io.demo;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
public class HaikuBulkTest {

    @Inject
    HaikuService haikuService;

    @Test
    @Transactional
    public void testGenerateTenHaikus() {
        String[] topics = {
            "ocean", "mountain", "forest", "sunset", "rain",
            "winter", "spring", "moon", "river", "garden"
        };

        // Clear existing haikus
        Haiku.deleteAll();

        // Generate and persist 10 haikus
        for (String topic : topics) {
            String haikuText = haikuService.generateHaiku(topic);
            Haiku haiku = new Haiku(topic, haikuText);
            haiku.persist();
        }

        // Verify 10 haikus were created
        long count = Haiku.count();
        assertEquals(10, count, "Should have 10 haikus in database");
    }
}
