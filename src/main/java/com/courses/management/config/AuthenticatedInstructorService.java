package com.courses.management.config;

import com.courses.management.entity.Instructor;
import com.courses.management.repository.InstructorRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class AuthenticatedInstructorService implements UserDetailsService {


    private final InstructorRepository instructorRepository;

    public AuthenticatedInstructorService(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Instructor user = instructorRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Instructor not found");
        }
        return new AuthenticatedInstructor(user);
    }
}
