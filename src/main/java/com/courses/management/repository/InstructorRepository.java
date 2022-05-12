package com.courses.management.repository;

import com.courses.management.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {

    Instructor findByUsername(String username);
}
