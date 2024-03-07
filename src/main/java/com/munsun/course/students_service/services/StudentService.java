package com.munsun.course.students_service.services;

import com.munsun.course.students_service.dto.in.StudentDtoIn;
import com.munsun.course.students_service.dto.out.StudentDtoOut;

import java.util.List;

public interface StudentService {
    StudentDtoOut addStudent(StudentDtoIn student);

    List<StudentDtoOut> getStudents();

    StudentDtoOut removeStudent(Integer id);

    List<StudentDtoOut> removeStudents();
}
