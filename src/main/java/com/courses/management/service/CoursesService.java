package com.courses.management.service;

import com.courses.management.entity.Course;
import com.courses.management.entity.Student;
import com.courses.management.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoursesService {

    private final CourseRepository courseRepository;

    public CoursesService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course getCourse(Long id) {
        return courseRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid course Id:" + id));
    }


    public void updateCourse(Course course) {
        courseRepository.save(course);
    }

    public List<Student> getStudents(long id) {
        return getCourse(id).getStudents();
    }
}
