package com.example.secondms;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "jobs")
public interface JobRepo extends CrudRepository<Job, Integer> {

    // Afficher un job par son nom : GET /API/jobs/search/findByService?service=Informatique
    List<Job> findByService(@Param("service") String service);
}
