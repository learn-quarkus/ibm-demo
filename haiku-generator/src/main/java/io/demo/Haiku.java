package io.demo;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.time.LocalDateTime;

@Entity
public class Haiku extends PanacheEntity {

    @Column(nullable = false)
    public String topic;

    @Column(nullable = false, length = 1000)
    public String text;

    @Column(nullable = false)
    public LocalDateTime createdAt;

    public Haiku() {
        this.createdAt = LocalDateTime.now();
    }

    public Haiku(String topic, String text) {
        this.topic = topic;
        this.text = text;
        this.createdAt = LocalDateTime.now();
    }
}
