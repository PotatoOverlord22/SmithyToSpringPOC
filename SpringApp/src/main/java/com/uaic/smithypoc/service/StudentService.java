package com.uaic.smithypoc.service;

import com.uaic.smithypoc.generated.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;
import java.math.BigDecimal;

@Service
public class StudentService {
    
    private final List<Student> students = createMockStudents();
    
    public List<Student> getAllStudents() {
        return students;
    }
    
    public Student findStudentById(BigDecimal id) {
        return students.stream()
                .filter(student -> student.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
    
    public Student addStudent(Student student) {
        if (student.getName() == null || student.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Student name cannot be empty");
        }
        
        if (student.getId() == null) {
            BigDecimal nextId = students.stream()
                    .map(Student::getId)
                    .max(BigDecimal::compareTo)
                    .orElse(BigDecimal.ZERO)
                    .add(BigDecimal.ONE);
            student.setId(nextId);
        }
        
        students.add(student);
        return student;
    }
    
    private List<Student> createMockStudents() {
        List<Student> mockStudents = new ArrayList<>();
        
        Student student1 = new Student();
        student1.setId(BigDecimal.valueOf(1));
        student1.setName("John Doe");
        mockStudents.add(student1);
        
        Student student2 = new Student();
        student2.setId(BigDecimal.valueOf(2));
        student2.setName("Jane Smith");
        mockStudents.add(student2);
        
        Student student3 = new Student();
        student3.setId(BigDecimal.valueOf(3));
        student3.setName("Alice Johnson");
        mockStudents.add(student3);
        
        return mockStudents;
    }
}
