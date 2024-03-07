package com.munsun.course.students_service.mapping.impl;

import com.munsun.course.students_service.dto.in.StudentDtoIn;
import com.munsun.course.students_service.dto.out.StudentDtoOut;
import com.munsun.course.students_service.mapping.StudentMapper;
import com.munsun.course.students_service.model.Student;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StudentMapperImpl implements StudentMapper {
    @Override
    public Student map(StudentDtoIn studentDtoIn) {
        Student student = new Student();
            student.setAge(studentDtoIn.age());
            student.setSurname(studentDtoIn.surname());
            student.setName(studentDtoIn.name());
            student.setCourse(studentDtoIn.course());
        return student;
    }

    @Override
    public StudentDtoOut map(Student student) {
        return new StudentDtoOut(student.getId(),
                student.getName(),
                student.getSurname(),
                student.getAge(),
                student.getCourse());
    }

    @Override
    public List<StudentDtoOut> map(List<Student> students) {
        return students.stream()
                .map(this::map)
                .collect(Collectors.toList());
    }
}
