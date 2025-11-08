package com.uaic.smithypoc.controller;

import com.uaic.smithypoc.generated.api.TeachersApiController;
import com.uaic.smithypoc.generated.model.GetTeachersResponseContent;
import com.uaic.smithypoc.generated.model.Teacher;
import com.uaic.smithypoc.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;

@Controller
public class CustomTeachersApiController extends TeachersApiController {

    private final TeacherService teacherService;

    @Autowired
    public CustomTeachersApiController(NativeWebRequest request, TeacherService teacherService) {
        super(request);
        this.teacherService = teacherService;
    }

    @Override
    public ResponseEntity<GetTeachersResponseContent> getTeachers() {
        try {
            List<Teacher> teachers = teacherService.getAllTeachers();
            
            GetTeachersResponseContent response = new GetTeachersResponseContent();
            response.setTeachers(teachers);
            
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
