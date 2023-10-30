package com.springboot.application5.service.course;

import com.springboot.application5.model.Course;
import com.springboot.application5.repository.CourseRepository;
import com.springboot.application5.service.common.CommonServiceImpl;
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

    public List<Course> getAll(){
        return courseRepository.findAll();
    }

    public void update(Course course){
        courseRepository.save(course);
    }


}
