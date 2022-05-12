package com.courses.management.controller;

import com.courses.management.config.AuthenticatedInstructor;
import com.courses.management.entity.Course;
import com.courses.management.entity.Student;
import com.courses.management.service.CoursesService;
import com.courses.management.service.InstructorService;
import com.courses.management.service.StudentService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/course")
public class CoursesController {
    private final CoursesService coursesService;
    private final InstructorService instructorService;
    private final StudentService studentService;

    public CoursesController(CoursesService coursesService, InstructorService instructorService, StudentService studentService) {
        this.coursesService = coursesService;
        this.instructorService = instructorService;
        this.studentService = studentService;
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Course course = coursesService.getCourse(id);
        model.addAttribute("course", course);
        return "update-course";
    }

    @PostMapping("/update/{id}")
    public String updateCourse(@PathVariable("id") long id, Course course,
                               BindingResult result, Model model) {
        if (result.hasErrors()) {
            course.setId(id);
            return "update-course";
        }
        coursesService.updateCourse(course);
        return "redirect:/home";
    }

    @GetMapping("/delete/{id}")
    public String removeCourse(@PathVariable("id") long id, Model model) {
        AuthenticatedInstructor authenticatedInstructor = (AuthenticatedInstructor) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        instructorService.removeCourse(authenticatedInstructor.getInstructorId(), id);
        return "redirect:/home";
    }

    @GetMapping("/students/{id}")
    public String listStudents(@PathVariable("id") long id, Model model) {
        List<Student> listStudents = coursesService.getStudents(id);
        model.addAttribute("listStudents", listStudents);
        model.addAttribute("course", coursesService.getCourse(id));
        return "course-students";
    }

    @GetMapping("/delete-student/{id}")
    public String deleteStudent(@PathVariable("id") long id,
                                @RequestParam(value = "studentId") long studentId,
                                Model model) {
        studentService.removeCourse(studentId, id);
        return String.format("redirect:/course/students/%d", id);
    }


}
