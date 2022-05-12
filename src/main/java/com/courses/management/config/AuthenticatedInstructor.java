package com.courses.management.config;

import com.courses.management.entity.Instructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class AuthenticatedInstructor implements UserDetails {

    private final Instructor instructor;

    public AuthenticatedInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return instructor.getPassword();
    }

    @Override
    public String getUsername() {
        return instructor.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getFullName() {
        return instructor.getFirstName() + " " + instructor.getLastName();
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public long getInstructorId() {
        return instructor.getId();
    }
}
