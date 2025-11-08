package com.uaic.smithypoc.controller;

import com.uaic.smithypoc.generated.api.StudentsApiController;
import com.uaic.smithypoc.generated.model.GetStudentsResponseContent;
import com.uaic.smithypoc.generated.model.Student;
import com.uaic.smithypoc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;

@Controller
public class CustomStudentsApiController extends StudentsApiController {

    private final StudentService studentService;

    @Autowired
    public CustomStudentsApiController(NativeWebRequest request, StudentService studentService) {
        super(request);
        this.studentService = studentService;
    }

    @Override
    public ResponseEntity<GetStudentsResponseContent> getStudents() {
        try {
            List<Student> students = studentService.getAllStudents();
            
            GetStudentsResponseContent response = new GetStudentsResponseContent();
            response.setStudents(students);
            
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
