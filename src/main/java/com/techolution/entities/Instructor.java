package com.techolution.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String departmentName;

    @Column
    private String headedBy;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String phoneNumber;

    @OneToMany(mappedBy = "instructorId")
    private List<Course> courses;

    public Instructor() {
    }

    public Instructor(String departmentName, String headedBy, String firstName, String lastName, String phoneNumber) {
        this.departmentName = departmentName;
        this.headedBy = headedBy;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }
}
