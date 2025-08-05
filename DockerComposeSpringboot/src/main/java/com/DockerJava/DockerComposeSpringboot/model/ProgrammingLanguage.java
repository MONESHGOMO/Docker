package com.DockerJava.DockerComposeSpringboot.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ProgrammingLanguage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String author;

    private LocalDateTime whenCreated;

    private String useCase;

    public ProgrammingLanguage() {}

    public ProgrammingLanguage(String author, LocalDateTime whenCreated, String useCase) {
        this.author = author;
        this.whenCreated = whenCreated;
        this.useCase = useCase;
    }


    public Long getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDateTime getWhenCreated() {
        return whenCreated;
    }

    public void setWhenCreated(LocalDateTime whenCreated) {
        this.whenCreated = whenCreated;
    }

    public String getUseCase() {
        return useCase;
    }

    public void setUseCase(String useCase) {
        this.useCase = useCase;
    }
}