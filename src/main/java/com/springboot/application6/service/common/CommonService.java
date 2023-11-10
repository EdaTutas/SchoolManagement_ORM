package com.springboot.application6.service.common;


import com.springboot.application6.exception.DuplicateEntityException;
import com.springboot.application6.exception.EntityNotFoundException;

import java.util.List;

public interface CommonService<Common> {

    List<Common> getAll();
    Common getById(Long id) throws EntityNotFoundException;
    Common save(Common entity) throws DuplicateEntityException;
    void delete(Long id);
    void update(Common entity) throws EntityNotFoundException;
}
