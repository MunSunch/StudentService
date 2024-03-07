package com.munsun.course.students_service.dto.out;
public record StudentDtoOut(
        Integer id,
        String name,
        String surname,
        Integer age,
        Integer course
){}