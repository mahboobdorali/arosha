package com.example.service.serviceImpl;


import com.example.data.dto.CourseDto;
import com.example.data.model.Course;
import com.example.data.repository.CourseRepository;
import com.example.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final ModelMapper modelMapper;

    @Override
    @Transactional
    public Mono<CourseDto> addCourse(CourseDto courseDto) {
        Course course = modelMapper.map(courseDto, Course.class);
        return courseRepository.save(course)
                .map(course1 -> modelMapper.map(course1, CourseDto.class));
    }

    @Override
    public Mono<CourseDto> retrieve(Long idCourse) {
        return courseRepository.findById(idCourse)
                .map(p -> modelMapper.map(p, CourseDto.class));
     }

    @Override
    public Mono<CourseDto> update(Long courseId, CourseDto courseDto) {
        return null;
    }

    @Override
    @Transactional
    public Mono<Void> delete(Long courseId) {
        return null;
    }

    @Override
    public Flux<CourseDto> list() {
        return null;
    }
}
