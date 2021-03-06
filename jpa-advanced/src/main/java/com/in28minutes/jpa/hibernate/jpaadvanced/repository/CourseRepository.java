package com.in28minutes.jpa.hibernate.jpaadvanced.repository;


import com.in28minutes.jpa.hibernate.jpaadvanced.entity.Course;
import com.in28minutes.jpa.hibernate.jpaadvanced.entity.Review;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
public class CourseRepository {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    public Course findById(Long id) {
        return em.find(Course.class, id);
    }

    public void deleteById(Long id) {
        Course course = findById(id);
        em.remove(course);
    }

    public Course save(Course course) {
        if (course.getId() == null) {
            //insert
            em.persist(course);
        } else {
            //update
            em.merge(course);
        }
        return course;
    }

    public void playWithEntityManager() {
        Course course = new Course("Web Services in 100 Steps");
        em.persist(course);
        course.setName("Web Services in 100 Steps - Updated");
    }

    public void playWithEntityManager2() {
        Course course1 = new Course("Web Services in 100 Steps");
        Course course2 = new Course("Angular JS in 100 Steps");
        em.persist(course1);
        em.persist(course2);

        em.flush();

        em.detach(course1);
        em.detach(course2);
        //or
        //em.clear();

        course1.setName("Web Services in 100 Steps - Updated");
        course2.setName("Angular JS in 100 Steps - Updated");
        em.flush();
    }

    public void playWithEntityManager3() {
        Course course1 = new Course("Web Services in 100 Steps");
        em.persist(course1);
        Course course2 = new Course("Angular JS in 100 Steps");
        em.persist(course2);

        em.flush();

        course1.setName("Web Services in 100 Steps - Updated");
        course2.setName("Angular JS in 100 Steps - Updated");

        em.refresh(course1);

        em.flush();
    }

    public void addHardcodedReviewsForCourse() {
        //get the course 10003
        Course course = findById(10003L);
        logger.info("course.getReviews() ->{}", course.getReviews());

        //add 2 reviews to it
        Review review1 = new Review("5","Great Hands-on Stuff.");
        Review review2 = new Review("5","Hatsoff.");

        //setting the relationship
        course.addReview(review1);
        review1.setCourse(course);

        course.addReview(review2);
        review2.setCourse(course);

        //save it to the database
        em.persist(review1);
        em.persist(review2);
    }

    public void addReviewsForCourse(Long courseId, List<Review> reviews) {
        Course course = findById(courseId);
        logger.info("course.getReviews() -> {}", course.getReviews());
        for (Review review: reviews) {
            //setting the relationship
            course.addReview(review);
            review.setCourse(course);
            em.persist(review);
        }
    }
}
