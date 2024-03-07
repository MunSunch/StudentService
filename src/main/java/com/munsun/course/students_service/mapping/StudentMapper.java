package com.munsun.course.students_service.mapping;

import com.munsun.course.students_service.dto.in.StudentDtoIn;
import com.munsun.course.students_service.dto.out.StudentDtoOut;
import com.munsun.course.students_service.model.Student;

import java.util.List;

public interface StudentMapper {
    Student map(StudentDtoIn student);

    StudentDtoOut map(Student save);

    List<StudentDtoOut> map(List<Student> students);
}
