package com.munsun.course.students_service.repositories.impl;

import com.munsun.course.students_service.model.Student;
import com.munsun.course.students_service.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class StudentRepositoryImpl implements StudentRepository {
    private final Map<Integer, Student> students = new ConcurrentHashMap<>();
    private final AtomicInteger generatorId = new AtomicInteger(1);

    @Override
    public Student save(Student student) {
        student.setId(generatorId.getAndIncrement());
        students.put(student.getId(), student);
        return student;
    }

    @Override
    public List<Student> removeAll() {
        var temp = new ArrayList<>(students.values());
        students.clear();
        return temp;
    }

    @Override
    public List<Student> getAll() {
        return new ArrayList<>(students.values());
    }

    @Override
    public Optional<Student> removeById(Integer id) {
        return Optional.ofNullable(students.remove(id));
    }
}