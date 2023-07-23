package com.example.service.serviceImpl;

import com.example.data.dto.CoursePersonDto;
import com.example.data.model.CoursePerson;
import com.example.data.repository.CoursePersonRepository;
import com.example.service.CoursePersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
@Service
@RequiredArgsConstructor
public class CoursePersonServiceImpl implements CoursePersonService {
    private final CoursePersonRepository coursePersonRepository;

    @Override
    public Mono<Void> addPersonToCourse(CoursePersonDto coursePersonDto) {
        CoursePerson coursePerson = new CoursePerson();
        coursePerson.setCourseId(coursePerson.getCourseId());
        coursePerson.setPersonId(coursePerson.getPersonId());
        return coursePersonRepository.save(coursePerson).then();
    }
}
