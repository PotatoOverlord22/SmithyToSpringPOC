package com.uaic.smithypoc.service;

import com.uaic.smithypoc.generated.model.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;
import java.math.BigDecimal;

@Service
public class TeacherService {
    
    private final List<Teacher> teachers = createMockTeachers();
    
    public List<Teacher> getAllTeachers() {
        return teachers;
    }
    
    public Teacher findTeacherById(BigDecimal id) {
        return teachers.stream()
                .filter(teacher -> teacher.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
    
    public Teacher addTeacher(Teacher teacher) {
        if (teacher.getName() == null || teacher.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Teacher name cannot be empty");
        }
        
        if (teacher.getId() == null) {
            BigDecimal nextId = teachers.stream()
                    .map(Teacher::getId)
                    .max(BigDecimal::compareTo)
                    .orElse(BigDecimal.ZERO)
                    .add(BigDecimal.ONE);
            teacher.setId(nextId);
        }
        
        teachers.add(teacher);
        return teacher;
    }
    
    private List<Teacher> createMockTeachers() {
        List<Teacher> mockTeachers = new ArrayList<>();
        
        Teacher teacher1 = new Teacher();
        teacher1.setId(BigDecimal.valueOf(1));
        teacher1.setName("Dr. Smith");
        teacher1.setSubject("Mathematics");
        mockTeachers.add(teacher1);
        
        Teacher teacher2 = new Teacher();
        teacher2.setId(BigDecimal.valueOf(2));
        teacher2.setName("Prof. Johnson");
        teacher2.setSubject("Physics");
        mockTeachers.add(teacher2);
        
        Teacher teacher3 = new Teacher();
        teacher3.setId(BigDecimal.valueOf(3));
        teacher3.setName("Ms. Williams");
        teacher3.setSubject("Chemistry");
        mockTeachers.add(teacher3);
        
        return mockTeachers;
    }
}
