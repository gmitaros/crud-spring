package com.courses.management.controller;

import com.courses.management.config.AuthenticatedInstructor;
import com.courses.management.entity.Course;
import com.courses.management.entity.Instructor;
import com.courses.management.service.InstructorService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Set;

@Controller
public class AppController {
    private final InstructorService instructorService;

    public AppController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping("")
    public String viewHomePage() {
        return "index";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("instructor", new Instructor());
        return "register";
    }

    @PostMapping("/process_register")
    public String processRegister(Instructor instructor) {
        Instructor createdInstructor = instructorService.createInstructor(instructor);
        return "register_success";
    }

    @GetMapping("/home")
    public String listUsers(Model model) {
        AuthenticatedInstructor authenticatedInstructor = (AuthenticatedInstructor) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Set<Course> listCourses = instructorService.getCourses(authenticatedInstructor.getInstructorId());
        model.addAttribute("listCourses", listCourses);
        return "home";
    }

}
