package com.munsun.course.students_service.exceptions;

public class StudentNotFoundException extends RuntimeException {
    private static final String DEFAULT_MESSAGE = "student not found";
    public StudentNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    public StudentNotFoundException(String message) {
        super(message);
    }
}
