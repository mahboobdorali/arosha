package com.example.service.serviceImpl;

import com.example.data.dto.CourseDto;
import com.example.data.dto.CoursePersonDto;
import com.example.data.model.CoursePerson;
import com.example.data.repository.CoursePersonRepository;
import com.example.service.CoursePersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@Service
@RequiredArgsConstructor
public class CoursePersonServiceImpl implements CoursePersonService {
    private final CoursePersonRepository coursePersonRepository;
    private final CourseServiceImpl courseService;

    @Override
    public Mono<Boolean> addPersonToCourse(CoursePersonDto coursePersonDto) {
        Mono<Long> count = findByCourseId(coursePersonDto.getCourseId()).count();
        Mono<CourseDto> retrieve = courseService.retrieve(coursePersonDto.getCourseId());
        Mono<Boolean> zip = Mono.zip(count, retrieve).flatMap(
                test2 -> {
                    Long countResult = test2.getT1();
                    CourseDto courseDto = test2.getT2();
                    if (countResult > courseDto.getCapacity())
                        throw new RuntimeException("nemishe");
                    CoursePerson coursePerson = new CoursePerson();
                    coursePerson.setCourseId(coursePersonDto.getCourseId());
                    coursePerson.setPersonId(coursePersonDto.getPersonId());
                    Mono<CoursePerson> save = coursePersonRepository.save(coursePerson);
                    return save.map(test3-> true);
                });
        return zip;
    }

    @Override
    public Flux<CoursePerson> findByCourseId(Long courseId) {
        return coursePersonRepository.findByCourseId(courseId);
    }

}
