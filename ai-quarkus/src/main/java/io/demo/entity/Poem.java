package io.demo.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "poems")
public class Poem extends PanacheEntity {

    @Column(nullable = false)
    public String topic;

    @Column(nullable = false, length = 4000)
    public String content;

    @Column(name = "created_at", nullable = false)
    public LocalDateTime createdAt;

    @Column(name = "rating")
    public Integer rating;

    @Column(name = "rating_reason", length = 1000)
    public String ratingReason;

    public Poem() {
        this.createdAt = LocalDateTime.now();
    }

    public Poem(String topic, String content) {
        this.topic = topic;
        this.content = content;
        this.createdAt = LocalDateTime.now();
    }

    public Poem(String topic, String content, Integer rating, String ratingReason) {
        this.topic = topic;
        this.content = content;
        this.rating = rating;
        this.ratingReason = ratingReason;
        this.createdAt = LocalDateTime.now();
    }
}
