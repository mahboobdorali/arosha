package com.example.service;

import com.example.data.dto.CourseDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CourseService {
    Mono<CourseDto> addCourse(CourseDto courseDto);

    Mono<CourseDto> retrieve(Long idCourse);

    Mono<CourseDto> update(Long courseId,CourseDto courseDto);

    Mono<Void> delete(Long courseId);

    Flux<CourseDto> list();

}
