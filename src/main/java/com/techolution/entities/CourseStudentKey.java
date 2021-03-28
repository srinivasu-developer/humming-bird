package com.techolution.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CourseStudentKey implements Serializable {

    @Column(name = "course_id")
    private Long courseId;

    @Column(name = "student_id")
    private Long studentId;

    public CourseStudentKey() {

    }

    public CourseStudentKey(Long courseId, Long studentId) {
        this.courseId = courseId;
        this.studentId = studentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseStudentKey that = (CourseStudentKey) o;
        return Objects.equals(courseId, that.courseId) && Objects.equals(studentId, that.studentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId, studentId);
    }
}
