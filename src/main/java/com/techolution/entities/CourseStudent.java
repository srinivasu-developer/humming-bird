package com.techolution.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class CourseStudent {

    @EmbeddedId
    private CourseStudentKey id;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "course_id")
    private Course course;

    public CourseStudent(Student student, Course course) {
        this.student = student;
        this.course = course;
    }

    public CourseStudent() {
    }

    public CourseStudent(CourseStudentKey id, Student student, Course course) {
        this.id = id;
        this.student = student;
        this.course = course;
    }
}
