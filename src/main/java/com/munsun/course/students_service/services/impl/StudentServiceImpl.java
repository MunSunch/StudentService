package com.munsun.course.students_service.services.impl;

import com.munsun.course.students_service.dto.in.StudentDtoIn;
import com.munsun.course.students_service.dto.out.StudentDtoOut;
import com.munsun.course.students_service.mapping.StudentMapper;
import com.munsun.course.students_service.model.Student;
import com.munsun.course.students_service.repositories.StudentRepository;
import com.munsun.course.students_service.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository repository;
    private final StudentMapper mapper;

    @Override
    public StudentDtoOut addStudent(StudentDtoIn student) {
        Student newStudent = mapper.map(student);
        return mapper.map(repository.save(newStudent));
    }

    @Override
    public List<StudentDtoOut> getStudents() {
        return mapper.map(repository.getAll());
    }

    @Override
    public StudentDtoOut removeStudent(Integer id) {
        return mapper.map(repository.removeById(id)
                .orElseThrow(RuntimeException::new));
    }

    @Override
    public List<StudentDtoOut> removeStudents() {
        return mapper.map(repository.removeAll());
    }
}
