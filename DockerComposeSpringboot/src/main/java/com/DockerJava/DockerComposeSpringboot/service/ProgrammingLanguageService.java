package com.DockerJava.DockerComposeSpringboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DockerJava.DockerComposeSpringboot.exception.ResourceNotFoundException;
import com.DockerJava.DockerComposeSpringboot.model.ProgrammingLanguage;
import com.DockerJava.DockerComposeSpringboot.repository.ProgrammingLanguageRepository;

@Service
public class ProgrammingLanguageService {

    @Autowired
    private ProgrammingLanguageRepository repository;

    public ProgrammingLanguage save(ProgrammingLanguage pl) {
        return repository.save(pl);
    }

    public List<ProgrammingLanguage> getAll() {
        return repository.findAll();
    }

    public ProgrammingLanguage getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Language with ID " + id + " not found."));
    }

    public ProgrammingLanguage update(Long id, ProgrammingLanguage updatedData) {
        ProgrammingLanguage existing = getById(id);  // this will throw if not found
        existing.setAuthor(updatedData.getAuthor());
        existing.setWhenCreated(updatedData.getWhenCreated());
        existing.setUseCase(updatedData.getUseCase());
        return repository.save(existing);
    }

    public void deleteById(Long id) {
        ProgrammingLanguage existing = getById(id);  // will throw if not found
        repository.deleteById(existing.getId());
    }
}
