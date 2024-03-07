package com.munsun.course.students_service.events.listeners;

import com.munsun.course.students_service.events.CreateStudentEvent;
import com.munsun.course.students_service.events.RemoveStudentEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StudentEventsListener {

    @EventListener(CreateStudentEvent.class)
    public void listenCreateStudent(CreateStudentEvent event) {
        System.out.println("Create student: "+event.getStudent());
    }

    @EventListener(RemoveStudentEvent.class)
    public void listenCreateStudent(RemoveStudentEvent event) {
        System.out.println("Remove student: id="+event.getIdRemovedStudent());
    }
}
