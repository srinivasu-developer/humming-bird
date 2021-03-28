package com.techolution.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NonNull
    private String departmentName;

    @Column
    private int instructorId;

    @Column
    private Long duration;

    @Column
    private String name;

    @OneToMany(mappedBy = "course")
    @JsonIgnore
    private Set<CourseStudent> courseStudents;

    public Course() {

    }

    public Course(String departmentName, int instructorId, Long duration, String name) {
        this.departmentName = departmentName;
        this.instructorId = instructorId;
        this.duration = duration;
        this.name = name;
    }
}
