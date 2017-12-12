package com.in28minutes.jpa.hibernate.jpaadvanced.repository;

import com.in28minutes.jpa.hibernate.jpaadvanced.JpaAdvancedApplication;
import com.in28minutes.jpa.hibernate.jpaadvanced.entity.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaAdvancedApplication.class)
public class JPQLTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    @Test
    public void jpql_basic() {
        Query query = em.createQuery("Select c From Course c");
        List resultList = query.getResultList();
        logger.info("Select c From Course c -> {}", resultList);
    }

    @Test
    public void jpql_typed() {
        TypedQuery<Course> query = em.createQuery("Select c From Course c", Course.class);
        List<Course> resultList = query.getResultList();
        logger.info("Select c From Course c -> {}", resultList);
    }

    @Test
    public void jpql_where() {
        TypedQuery<Course> query = em.createQuery("Select c From Course c Where name like '%100 Steps'", Course.class);
        List<Course> resultList = query.getResultList();
        logger.info("Select c From Course c Where name like '%100 Steps' -> {}", resultList);
    }

    @Test
    public void named_query() {
        Query query = em.createNamedQuery("query_get_all_courses");
        List listResult = query.getResultList();
        logger.info("query_get_all_courses -> {}", listResult);
    }

    @Test
    public void named_query_100_steps() {
        Query query = em.createNamedQuery("query_get_100_Step_courses");
        List listResult = query.getResultList();
        logger.info("query_get_100_Step_courses -> {}", listResult);
    }


}
