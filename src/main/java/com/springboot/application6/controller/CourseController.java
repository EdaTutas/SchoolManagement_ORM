package com.springboot.application6.controller;

import com.springboot.application6.exception.DuplicateEntityException;
import com.springboot.application6.exception.EntityNotFoundException;
import com.springboot.application6.model.Course;
import com.springboot.application6.service.common.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        try {
            return courseService.getById(id);
        } catch (EntityNotFoundException e) {
            return null; // ya da başka e yolla
        }
    }

    @PostMapping("/save")
    public Course addCourse(@RequestBody Course course) {
        try {
            return courseService.save(course);
        } catch (DuplicateEntityException e) {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id) {
        try {
            courseService.delete(id);
        } catch (EntityNotFoundException e) {
        }
    }

    @PutMapping("/update/{id}")
    private ResponseEntity<String> updateCourse(@PathVariable Long id, @RequestBody Course updatedCourse) {
        try {
            Course existingCourse = courseService.getById(id);
            if (existingCourse != null) {
                if (updatedCourse.getInstructor() != null) {
                    // Güncelleme işlemini gerçekleştir
                    existingCourse.updateInstructor(updatedCourse.getInstructor());
                }
                // Diğer alanları güncelleme işlemini gerçekleştir
                existingCourse.setTitle(updatedCourse.getTitle());
                // Güncellenmiş Course'u kaydet
                courseService.update(existingCourse);
                return ResponseEntity.ok("Course updated successfully");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Course not found");
            }
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}