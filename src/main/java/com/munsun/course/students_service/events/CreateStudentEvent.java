package com.munsun.course.students_service.events;

import com.munsun.course.students_service.dto.in.StudentDtoIn;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CreateStudentEvent {
    StudentDtoIn student;
}
