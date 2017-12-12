package com.in28minutes.jpa.hibernate.jpaadvanced.repository;

import com.in28minutes.jpa.hibernate.jpaadvanced.JpaAdvancedApplication;
import com.in28minutes.jpa.hibernate.jpaadvanced.entity.Passport;
import com.in28minutes.jpa.hibernate.jpaadvanced.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaAdvancedApplication.class)
public class StudentRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    StudentRepository repository;

    @Autowired
    EntityManager em;

    @Test
    @Transactional
    public void retrieveStudentWithPassword() {
        Student student = repository.findById(20001L);

        logger.info("student -> {}", student);
        logger.info("passport -> {}", student.getPassport());
    }

    @Test
    public void someTest() {
        repository.someOperationToUndestandPersistenceContext();
    }


}
