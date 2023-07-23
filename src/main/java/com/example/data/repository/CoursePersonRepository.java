package com.example.data.repository;

import com.example.data.model.CoursePerson;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursePersonRepository extends ReactiveCrudRepository<CoursePerson,Long> {

}
