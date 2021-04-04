package com.techolution.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
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
    @ApiModelProperty(hidden = true)
    private Long id;

    @Column
    @NotBlank(message = "Department name must not be empty")
    private String departmentName;

    @Column
    private int instructorId;

    @Column
    private Long duration;

    @Column
    @NotBlank(message = "Course name must not be empty")
    private String name;

    @OneToMany(mappedBy = "course")
    @JsonIgnore
    @ApiModelProperty(hidden = true)
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
