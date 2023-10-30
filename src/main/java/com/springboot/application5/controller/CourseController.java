package com.springboot.application5.controller;

import com.springboot.application5.model.Course;
import com.springboot.application5.service.common.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    private final CommonService<Course> courseService;

    @Autowired
    public CourseController(CommonService<Course> courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/getAll")
    public List<Course> getAllCourses() {
        return courseService.getAll();
    }

    @GetMapping("/{id}")
    public Course getCourse(@PathVariable Long id) {
        return courseService.getById(id);
    }

    @PostMapping("/save")
    public Course addCourse(@RequestBody Course course) {
        return courseService.save(course);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id) {
        courseService.delete(id);
    }

    @PutMapping("/update/{id}")
    private void updateCourse(@PathVariable Long id, @RequestBody Course course) {
        Course existingCourse = courseService.getById(id);
        if (existingCourse != null) {
            if (course.getInstructor() != null) {
                existingCourse.updateInstructor(course.getInstructor());
            }
            courseService.update(existingCourse);
        }
    }
}