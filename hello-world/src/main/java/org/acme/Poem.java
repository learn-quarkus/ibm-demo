package org.acme;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Poem extends PanacheEntity {

    @Column(nullable = false)
    public String topic;

    @Column(nullable = false, length = 1000)
    public String poem;

    public Poem() {
    }

    public Poem(String topic, String poem) {
        this.topic = topic;
        this.poem = poem;
    }
}
