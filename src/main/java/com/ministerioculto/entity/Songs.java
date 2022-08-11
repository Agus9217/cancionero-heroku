package com.ministerioculto.entity;

import javax.persistence.*;
import java.util.Locale;

@Entity
@Table(name = "cancionero")
public class Songs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private String tone;
    @Column(length = 6000)
    private String description;

    public Songs() {
    }

    public Songs(Long id, String title, String author, String tone, String description) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.tone = tone;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTone() {
        return tone;
    }

    public void setTone(String tone) {
        this.tone = tone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
