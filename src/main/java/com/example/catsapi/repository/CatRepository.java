package com.example.catsapi.repository;

import com.example.catsapi.domain.Cat;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CatRepository extends PagingAndSortingRepository<Cat, Long> {
}
