package com.in28minutes.jpa.hibernate.jpaadvanced.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@NamedQueries(value = {
        @NamedQuery(name = "query_get_all_courses", query = "Select c From Course c"),
        @NamedQuery(name = "query_get_100_Step_courses", query = "Select c From Course c Where name like '%100 Steps'")
})
public class Course {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    private Date lastUpdatedDate;

    private Date createdDate;

    @PrePersist
    public void prePresist() {
        this.createdDate = new Date();
    }

    @PreUpdate
    public void preUpdate() {
        this.lastUpdatedDate = new Date();
    }

    public Course(String name) {
        this.name = name;
    }

    protected Course() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
