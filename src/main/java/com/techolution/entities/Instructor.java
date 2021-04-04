package com.techolution.entities;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class Instructor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(hidden = true)
    private Long id;

    @Column
    @NotBlank(message = "Department name must not be empty")
    private String departmentName;

    @Column
    private String headedBy;

    @Column
    @NotBlank(message = "first name must not be empty")
    private String firstName;

    @Column
    @NotBlank(message = "last name must not be empty")
    private String lastName;

    @Column
    @NotBlank(message = "Phone number must not be empty")
    private String phoneNumber;

    @OneToMany(mappedBy = "instructorId")
    @ApiModelProperty(hidden = true)
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
