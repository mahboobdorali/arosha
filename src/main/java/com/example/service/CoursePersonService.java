package com.example.service;

import com.example.data.dto.CoursePersonDto;
import com.example.data.model.CoursePerson;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CoursePersonService {
    Mono<Boolean> addPersonToCourse(CoursePersonDto coursePersonDto);
    Flux<CoursePerson> findByCourseId(Long courseId);

}
