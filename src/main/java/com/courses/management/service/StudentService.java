package com.courses.management.service;

import com.courses.management.entity.Course;
import com.courses.management.entity.Student;
import com.courses.management.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final CoursesService coursesService;

    public StudentService(StudentRepository studentRepository, CoursesService coursesService) {
        this.studentRepository = studentRepository;
        this.coursesService = coursesService;
    }

    public Student getStudent(long id) {
        return studentRepository.getById(id);
    }

    public void removeCourse(long studentId, long courseId) {
        Student student = getStudent(studentId);
        Course course = coursesService.getCourse(courseId);
        student.getCourses().remove(course);
        studentRepository.save(student);
    }
}
