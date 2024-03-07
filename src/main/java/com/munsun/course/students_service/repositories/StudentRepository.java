package com.munsun.course.students_service.repositories;

import com.munsun.course.students_service.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository {
    Student save(Student student);

    List<Student> removeAll();

    List<Student> getAll();

    Optional<Student> removeById(Integer id);
}
