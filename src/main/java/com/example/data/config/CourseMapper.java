package com.example.data.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class CourseMapper {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}