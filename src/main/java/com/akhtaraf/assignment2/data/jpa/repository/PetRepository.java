package com.akhtaraf.assignment2.data.jpa.repository;


import com.akhtaraf.assignment2.data.jpa.entity.PetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
        path = "pets",
        collectionResourceRel = "pets",
        itemResourceRel = "pet"
)
public interface PetRepository extends JpaRepository<PetEntity, Integer> {

}
