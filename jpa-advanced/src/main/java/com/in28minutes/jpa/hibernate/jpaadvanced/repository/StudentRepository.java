package com.in28minutes.jpa.hibernate.jpaadvanced.repository;


import com.in28minutes.jpa.hibernate.jpaadvanced.entity.Course;
import com.in28minutes.jpa.hibernate.jpaadvanced.entity.Passport;
import com.in28minutes.jpa.hibernate.jpaadvanced.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@Transactional
public class StudentRepository {

    @Autowired
    EntityManager em;

    public Student findById(Long id) {
        return em.find(Student.class, id);
    }

    public void deleteById(Long id) {
        Student student = findById(id);
        em.remove(student);
    }

    public Student save(Student student) {
        if (student.getId() == null) {
            //insert
            em.persist(student);
        } else {
            //update
            em.merge(student);
        }
        return student;
    }

    public void saveStudentWithPassword() {
        Passport passport = new Passport("Z123456");
        em.persist(passport);

        Student student = new Student("Mike");
        student.setPassport(passport);
        em.persist(student);
    }


    public void someOperationToUndestandPersistenceContext() {
        //retrieve student
        Student student = em.find(Student.class, 20001L);

        //retrieve passport
        Passport passport = student.getPassport();

        //update passport
        passport.setNumber("E123457");


        //update student
        student.setName("Ranga - updated");
    }

}
