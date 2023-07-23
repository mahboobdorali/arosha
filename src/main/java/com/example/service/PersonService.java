package com.example.service;

import com.example.data.dto.PersonDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonService {
    Mono<PersonDto> addPerson(PersonDto personDto);

    Mono<PersonDto> retrieve(Long idPerson);

    Mono<PersonDto> update(Long personId,PersonDto personDto);

    Mono<Void> delete(Long personId);

    Flux<PersonDto> list();
}

