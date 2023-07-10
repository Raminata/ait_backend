package de.aittr.auto;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutoService {

    private AutoRepository repository;

    public AutoService(AutoRepository repository) {
        this.repository = repository;
    }

    List<Auto> getAllAuto() {
        return repository.findAll();
    }
}
