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
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(hidden = true)
    private Long id;

    @Column
    @NotBlank(message = "First name must not be empty")
    private String firstName;

    @Column
    @NotBlank(message = "Last name must not be empty")
    private String lastName;

    @Column
    private String phone;

    @OneToMany(mappedBy = "student")
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private Set<CourseStudent> courseStudents;

    public Student(String firstName, String lastName, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }

    public Student() {

    }
}
