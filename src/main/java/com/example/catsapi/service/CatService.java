package com.example.catsapi.service;

import com.example.catsapi.domain.Cat;
import com.example.catsapi.repository.CatRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CatService {

    private final CatRepository catRepository;

    public CatService(CatRepository catRepository) {
        this.catRepository = catRepository;
    }

    public Cat create(Cat cat) {
        return catRepository.save(cat);
    }

    public Page<Cat> get(Pageable pageable) {
        Page<Cat> result = catRepository.findAll(pageable);
        result.getContent().stream().map(cat -> cat.getHobbies().size());
        return result;
    }

    public Cat update(Cat cat) {
        return catRepository.save(cat);
    }

    public void delete(Long id) {
        catRepository.deleteById(id);
    }
}
