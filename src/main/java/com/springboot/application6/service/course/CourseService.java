package com.springboot.application6.service.course;

import com.springboot.application6.model.Course;
import com.springboot.application6.repository.CourseRepository;
import com.springboot.application6.service.common.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService extends CommonServiceImpl<Course> {
    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        super(courseRepository);
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> getAll(){
        return super.getAll();
    }

    @Override
    public Course getById(Long id) {
        return super.getById(id);
    }

    @Override
    public Course save(Course course) {
        return super.save(course);
    }


    @Override
    public void delete(Long id) {
        super.delete(id);
    }

    @Override
    public void update(Course course){
        super.update(course);
    }

    @Override
    protected Long getEntityId(Course entity) {
        return  entity.getId();
    }


}
