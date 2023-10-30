package com.springboot.application5.service.common;

import com.springboot.application5.model.Course;

import java.util.List;

public interface CommonService<Common> {
    List<Common> getAll();
    Common getById(Long id);
    Common save(Common entity);
    void delete(Long id);
    void update(Common entity);
}
