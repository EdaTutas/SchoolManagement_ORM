package com.springboot.application6.repository;

import com.springboot.application6.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository  extends JpaRepository<Course,Long> {
}
