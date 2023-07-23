package com.example.service;

import com.example.data.dto.CoursePersonDto;
import reactor.core.publisher.Mono;

public interface CoursePersonService {
    Mono<Void> addPersonToCourse(CoursePersonDto coursePersonDto);
}
