package com.courses.management.repository;

import com.courses.management.entity.Instructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class InstructorRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private InstructorRepository instructorRepository;

    @Test
    public void testCreateUser() {
        Instructor instructor = new Instructor();
        instructor.setUsername("instructor1");
        instructor.setPassword("password");
        instructor.setFirstName("Kyriakos");
        instructor.setLastName("Kyriakou");

        Instructor savedInstructor = instructorRepository.save(instructor);

        Instructor existInstructor = entityManager.find(Instructor.class, savedInstructor.getId());

        assertThat(instructor.getUsername()).isEqualTo(existInstructor.getUsername());

    }
}
