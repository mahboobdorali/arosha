package com.example.controller;

import com.example.data.dto.CourseDto;
import com.example.data.dto.CoursePersonDto;
import com.example.data.dto.PersonDto;
import com.example.service.serviceImpl.CoursePersonServiceImpl;
import com.example.service.serviceImpl.CourseServiceImpl;
import com.example.service.serviceImpl.PersonServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/test")
@AllArgsConstructor
public class CoursePersonController {
    private final CourseServiceImpl courseService;
    private final PersonServiceImpl personService;
    private final CoursePersonServiceImpl coursePersonService;

    @PostMapping("/courses")
    public Mono<CourseDto> addCourse(@RequestBody CourseDto courseDto) {
        return courseService.addCourse(courseDto);
    }

    @PostMapping("/persons")
    public Mono<PersonDto> addPerson(@RequestBody PersonDto personDto) {
        return personService.addPerson(personDto);
    }


    @PutMapping("/courses/{courseId}")
    public Mono<CourseDto> updateCourse(@PathVariable Long courseId, @RequestBody CourseDto courseDto) {
        return courseService.update(courseId, courseDto);
    }

    @PutMapping("/persons/{personId}")
    public Mono<PersonDto> updatePerson(@PathVariable Long personId, @RequestBody PersonDto personDto) {
        return personService.update(personId, personDto);
    }

    @PostMapping("/courses/add-person")
    public Mono<Void> addPersonToCourse(@RequestBody CoursePersonDto coursePersonDto) {
        return coursePersonService.addPersonToCourse(coursePersonDto);
    }
}
