package com.in28minutes.jpa.hibernate.jpaadvanced;

import com.in28minutes.jpa.hibernate.jpaadvanced.repository.CourseRepository;
import com.in28minutes.jpa.hibernate.jpaadvanced.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaAdvancedApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    StudentRepository studentRepository;


    public static void main(String[] args) {
        SpringApplication.run(JpaAdvancedApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        courseRepository.playWithEntityManager3();

        studentRepository.saveStudentWithPassword();
    }
}
