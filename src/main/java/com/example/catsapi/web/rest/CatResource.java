package com.example.catsapi.web.rest;

import com.example.catsapi.domain.Cat;
import com.example.catsapi.service.CatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cats")
public class CatResource {

    private final Logger log = LoggerFactory.getLogger(CatResource.class);

    private final CatService catService;

    public CatResource(CatService catService) {
        this.catService = catService;
    }

    @PostMapping
    public ResponseEntity<Cat> createCat(@RequestBody Cat cat) {
        log.debug("REST request to create a new Cat : {}", cat);
        return ResponseEntity.ok(catService.create(cat));
    }

    @GetMapping
    public ResponseEntity<Page<Cat>> getCats(Pageable pageable) {
        log.debug("REST request to get all Cats");
        return ResponseEntity.ok(catService.get(pageable));
    }

    @PutMapping
    public ResponseEntity<Cat> updateCat(@RequestBody Cat cat) {
        log.debug("REST request to update Cat : {}", cat);
        return ResponseEntity.ok(catService.update(cat));
    }

    public ResponseEntity<Void> deleteCat(@RequestBody Long id) {
        log.debug("REST request to delete Cat : {}", id);
        catService.delete(id);
        return ResponseEntity.ok().build();
    }
}
