package com.springboot.application5.service.instructor;

import com.springboot.application5.model.Course;
import com.springboot.application5.model.Instructor;
import com.springboot.application5.repository.InstructorRepository;
import com.springboot.application5.service.common.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorService extends CommonServiceImpl<Instructor> {

    @Autowired
    private InstructorRepository instructorRepository;

    @Autowired
    public InstructorService(InstructorRepository instructorRepository) {
        super(instructorRepository);
        this.instructorRepository = instructorRepository;
    }

    @Override
    public Instructor save(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @Override
    public List<Instructor> getAll() {
        return instructorRepository.findAll();
    }

    @Override
    public Instructor getById(Long id) {
        return  instructorRepository.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        super.delete(id);
    }

    @Override
    public void update(Instructor entity) {
        super.update(entity);
    }


}
