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
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaAdvancedApplication.class)
public class NativeQueriesTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    @Test
    public void native_queries_basic() {
        Query query = em.createNativeQuery("SELECT * FROM COURSE", Course.class);
        List listResult = query.getResultList();
        logger.info("SELECT * FROM COURSE -> {}", listResult);
    }

    @Test
    public void native_queries_with_parameter() {
        Query query = em.createNativeQuery("SELECT * FROM COURSE WHERE id = ?", Course.class)
                .setParameter(1, 10001L);
        List listResult = query.getResultList();
        logger.info("SELECT * FROM COURSE WHERE id = ? {}", listResult);
    }

    @Test
    public void native_queries_with_named_parameter() {
        Query query = em.createNativeQuery("SELECT * FROM COURSE WHERE id = :id", Course.class)
                .setParameter("id", 10001L);
        List listResult = query.getResultList();
        logger.info("SELECT * FROM COURSE WHERE id = :id -> {}", listResult);
    }

    @Test
    @Transactional
    public void native_queries_to_update() {
        Query query = em.createNativeQuery("Update COURSE set last_updated_date = sysdate()");
        int noOfRowsUpdated = query.executeUpdate();
        logger.info("noOfRowsUpdated -> {}", noOfRowsUpdated);
    }

}
