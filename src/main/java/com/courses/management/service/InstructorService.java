package com.courses.management.service;

import com.courses.management.entity.Course;
import com.courses.management.entity.Instructor;
import com.courses.management.repository.InstructorRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class InstructorService {

    private final InstructorRepository instructorRepository;
    private final CoursesService coursesService;

    public InstructorService(InstructorRepository instructorRepository, CoursesService coursesService) {
        this.instructorRepository = instructorRepository;
        this.coursesService = coursesService;
    }

    public Instructor createInstructor(Instructor instructor) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(instructor.getPassword());
        instructor.setPassword(encodedPassword);
        return instructorRepository.save(instructor);
    }

    public List<Instructor> getAllInstructors() {
        return instructorRepository.findAll();
    }

    public Instructor getInstructor(long id) {
        return instructorRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
    }

    public Set<Course> getCourses(long id) {
        Instructor instructor = instructorRepository.getById(id);
        return instructor.getCourses();
    }


    public void removeCourse(long instructorId, long courseId) {
        Instructor instructor = getInstructor(instructorId);
        Course course = coursesService.getCourse(courseId);
        instructor.getCourses().remove(course);
        instructorRepository.save(instructor);
    }
}
