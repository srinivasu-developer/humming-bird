package com.techolution.repositories;

import com.techolution.entities.CourseStudent;
import com.techolution.entities.CourseStudentKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentCourseRepository extends JpaRepository<CourseStudent, CourseStudentKey> {
}
