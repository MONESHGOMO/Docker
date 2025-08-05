package com.DockerJava.DockerComposeSpringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.DockerJava.DockerComposeSpringboot.model.ProgrammingLanguage;
import com.DockerJava.DockerComposeSpringboot.service.ProgrammingLanguageService;

@RestController
@RequestMapping("/api/v1/languages")
public class ProgrammingLanguageController {

    @Autowired
    private ProgrammingLanguageService service;

    @PostMapping
    public ResponseEntity<ProgrammingLanguage> createLanguage(@RequestBody ProgrammingLanguage pl) {
        return ResponseEntity.ok(service.save(pl));
    }

    @GetMapping
    public ResponseEntity<List<ProgrammingLanguage>> getAllLanguages() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProgrammingLanguage> getLanguageById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProgrammingLanguage> updateLanguage(@PathVariable Long id, @RequestBody ProgrammingLanguage pl) {
        return ResponseEntity.ok(service.update(id, pl));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLanguage(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.ok("Programming language deleted successfully.");
    }
}
