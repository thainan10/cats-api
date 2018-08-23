package com.example.catsapi.repository;

import com.example.catsapi.domain.Hobby;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface HobbyRepository extends PagingAndSortingRepository<Hobby, Long> {
}
