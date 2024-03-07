package com.munsun.course.students_service.events.listeners;

import com.munsun.course.students_service.model.Student;
import com.munsun.course.students_service.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@ConditionalOnExpression("#{'${students.init}'.equals('true')}")
public class StudentInitEventListener {
    private final StudentRepository repository;

    @EventListener(ApplicationContextEvent.class)
    public void initStudents() {
        repository.save(new Student(1, "Munir", "Sunchalyaev", 25, 1));
        repository.save(new Student(2, "Andrey","Sunchalyaev", 27, 5));
        repository.save(new Student(3, "Tolya","Sunchalyaev", 19, 4));
    }
}
