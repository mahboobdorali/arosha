package com.example.service.serviceImpl;

import com.example.data.config.CourseMapper;
import com.example.data.dto.PersonDto;
import com.example.data.model.Person;
import com.example.data.repository.PersonRepository;
import com.example.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;
    private final ModelMapper modelMapper;

    @Override
    public Mono<PersonDto> addPerson(PersonDto personDto) {
        Person person = modelMapper.map(personDto, Person.class);
        return personRepository.save(person)
                .map(person1 -> modelMapper.map(person1, PersonDto.class));
    }


    @Override
    public Mono<PersonDto> retrieve(Long id) {
        return personRepository.findById(id)
                .map(p -> modelMapper.map(p, PersonDto.class));
    }

    @Override
    public Mono<PersonDto> update(Long personId, PersonDto personDto) {
        return null;
    }

    @Override
    public Mono<Void> delete(Long personId) {
        return null;
    }

    @Override
    public Flux<PersonDto> list() {
        return null;
    }
}
