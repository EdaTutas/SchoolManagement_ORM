package com.springboot.application6.controller;

import com.springboot.application6.exception.DuplicateEntityException;
import com.springboot.application6.exception.EntityNotFoundException;
import com.springboot.application6.model.Instructor;
import com.springboot.application6.model.InstructorDetail;
import com.springboot.application6.service.common.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
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
        try {
            return instructorService.getById(id);
        } catch (EntityNotFoundException e) {
            return null;
        }
    }

    @PostMapping("/save")
    public Instructor save(@RequestBody Instructor instructor) {
        try {
            return instructorService.save(instructor);
        } catch (DuplicateEntityException e) {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        try {
            instructorService.delete(id);
        } catch (EntityNotFoundException e) {
        }
    }

    @PutMapping("/update/{id}")
    private ResponseEntity<String> updateInstructor(@PathVariable Long id, @RequestBody Instructor updatedInstructor) {
        try {
            // instructor'ı güncelle
            instructorService.update(updatedInstructor);
            return ResponseEntity.ok("Instructor updated successfully");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}