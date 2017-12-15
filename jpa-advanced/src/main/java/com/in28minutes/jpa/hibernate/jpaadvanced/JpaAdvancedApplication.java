package com.in28minutes.jpa.hibernate.jpaadvanced;

import com.in28minutes.jpa.hibernate.jpaadvanced.entity.Course;
import com.in28minutes.jpa.hibernate.jpaadvanced.entity.FullTimeEmployee;
import com.in28minutes.jpa.hibernate.jpaadvanced.entity.PartTimeEmployee;
import com.in28minutes.jpa.hibernate.jpaadvanced.entity.Student;
import com.in28minutes.jpa.hibernate.jpaadvanced.repository.CourseRepository;
import com.in28minutes.jpa.hibernate.jpaadvanced.repository.EmployeeRepository;
import com.in28minutes.jpa.hibernate.jpaadvanced.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class JpaAdvancedApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private EmployeeRepository employeeRepository;


    public static void main(String[] args) {
        SpringApplication.run(JpaAdvancedApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
//        courseRepository.playWithEntityManager3();
//        studentRepository.saveStudentWithPassword();
//        courseRepository.addHardcodedReviewsForCourse();
//        List<Review> reviews = new ArrayList<>();
//        reviews.add(new Review("5", "Great Hands-on Stuff."));
//        reviews.add(new Review("5", "Hatsoff."));
//
//        courseRepository.addReviewsForCourse(10001L, reviews);

//        studentRepository.insertHardcodedStudentAndCourse();

//        Student student = new Student("Jack");
//        Course course = new Course("Microservices in 100 Steps");
//        studentRepository.insertStudentAndCourse(student, course);

        employeeRepository.insert(
                new PartTimeEmployee("Jill", new BigDecimal("50")));

        employeeRepository.insert(
            new FullTimeEmployee("Jack", new BigDecimal("10000")));

//        logger.info("All Employees -> {}",employeeRepository.retrieveAllEmployees());
    }
}
