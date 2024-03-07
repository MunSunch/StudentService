package com.munsun.course.students_service.shells;

import com.munsun.course.students_service.dto.in.StudentDtoIn;
import com.munsun.course.students_service.dto.out.StudentDtoOut;
import com.munsun.course.students_service.services.StudentService;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.Availability;
import org.springframework.shell.standard.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@ShellComponent
@ShellCommandGroup("Commands for working with students")
@RequiredArgsConstructor
public class StudentsShell {
    private final StudentService service;

    @ShellMethod(value = "add student in database", key = "add")
    public void addStudent(@NotBlank String name, @NotBlank String surname, @Positive Integer age, @Positive Integer course) {
        service.addStudent(new StudentDtoIn(name, surname, age, course));
    }

    @ShellMethod(value="show all students", key = "show")
    public String showAllStudents() {
        return service.getStudents().stream()
                .map(Objects::toString)
                .collect(Collectors.joining("\n"));
    }

    @ShellMethod(value = "remove student by identifier", key = "remove")
    public void removeStudent(@Positive Integer id) {
        StudentDtoOut student = service.removeStudent(id);
    }

    @ShellMethod(value = "remove all students", key = "remove all")
    public List<StudentDtoOut> removeStudents() {
        return service.removeStudents();
    }

    @ShellMethodAvailability(value = {"remove", "remove all", "show"})
    public Availability isEmpty() {
        return service.getStudents().isEmpty()
                ? Availability.unavailable("list is empty")
                : Availability.available();
    }
}