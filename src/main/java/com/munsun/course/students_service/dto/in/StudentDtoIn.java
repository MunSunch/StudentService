package com.munsun.course.students_service.dto.in;

public record StudentDtoIn(
        String name,
        String surname,
        Integer age,
        Integer course
) {}