package com.munsun.course.students_service.aspects;

import com.munsun.course.students_service.dto.in.StudentDtoIn;
import com.munsun.course.students_service.dto.out.StudentDtoOut;
import com.munsun.course.students_service.events.CreateStudentEvent;
import com.munsun.course.students_service.events.RemoveStudentEvent;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@RequiredArgsConstructor
public class StudentAspects {
    private final ApplicationEventPublisher publisher;

    @Pointcut("execution(* com.munsun.course.students_service.shells.StudentsShell.addStudent(..))")
    public void createStudentPointcut() {}

    @Pointcut("execution(* com.munsun.course.students_service.shells.StudentsShell.removeStudent(..))")
    public void removeStudentPointcut() {}

    @Pointcut("execution(* com.munsun.course.students_service.shells.StudentsShell.removeStudents())")
    public void removeAllStudentsPointcut() {}

    @After("removeStudentPointcut()")
    public void loggingRemoveStudent(JoinPoint point) {
        Integer id = (Integer) point.getArgs()[0];
        publisher.publishEvent(new RemoveStudentEvent(id));
    }

    @AfterReturning(value = "removeAllStudentsPointcut()", returning = "list")
    public void loggingRemoveAllStudents(Object list) {
        var students = (List<StudentDtoOut>)list;
        students.stream().forEach((x) -> {
            publisher.publishEvent(new RemoveStudentEvent(x.id()));
        });
    }

    @After("createStudentPointcut()")
    public void loggingCreateStudent(JoinPoint point) {
        String name = (String)point.getArgs()[0];
        String surname = (String)point.getArgs()[1];
        Integer age = (Integer)point.getArgs()[2];
        Integer course = (Integer)point.getArgs()[3];
        publisher.publishEvent(new CreateStudentEvent(new StudentDtoIn(name,surname, age, course)));
    }
}
