package com.springboot.application5.controller;

import com.springboot.application5.model.Course;
import com.springboot.application5.model.Instructor;
import com.springboot.application5.service.common.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instructor")
public class InstructorController {

    private final CommonService<Instructor> instructorService;

    @Autowired
    public InstructorController(CommonService<Instructor> instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping("getAll")
    public List<Instructor> getAllInstructors() {
        return instructorService.getAll();
    }

    @GetMapping("/{id}")
    public Instructor getInstructor(@PathVariable Long id) {
        return instructorService.getById(id);
    }

    @PostMapping("/save")
    public Instructor addInstructor(@RequestBody Instructor instructor) {
        return instructorService.save(instructor);
    }

    @DeleteMapping("/{id}")
    public void deleteInstructor(@PathVariable Long id) {
        instructorService.delete(id);
    }


}
