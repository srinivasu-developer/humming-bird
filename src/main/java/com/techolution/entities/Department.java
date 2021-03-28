package com.techolution.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private String name;

    @Column
    private String location;

    @OneToMany(mappedBy = "departmentName")
    private List<Course> courses;

    @OneToMany(mappedBy = "departmentName")
    private List<Instructor> instructors;

    public Department(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public Department() {
    }
}
