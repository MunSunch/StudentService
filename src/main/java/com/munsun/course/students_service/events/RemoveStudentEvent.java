package com.munsun.course.students_service.events;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RemoveStudentEvent {
    Integer idRemovedStudent;
}
