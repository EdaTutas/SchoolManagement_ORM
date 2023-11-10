package com.springboot.application6.service.common;

import com.springboot.application6.exception.DuplicateEntityException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public abstract class CommonServiceImpl <Common> implements CommonService<Common> {
    private final JpaRepository<Common, Long> repository; //Dependency Injection Design


    public CommonServiceImpl(JpaRepository<Common, Long> repository) {

        this.repository = repository;
    }

    @Override
    public List<Common> getAll() {
        return repository.findAll();
    }

    @Override
    public Common getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity with id " + id + " not found"));
    }

    @Override
    public Common save(Common entity) {
        try {
            return repository.save(entity);
        } catch (DataIntegrityViolationException e) {
            throw new DuplicateEntityException("Entity already exists",e);
        }
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Entity with id " + id + " not found");
        }
        repository.deleteById(id);
       // repository.deleteById(id);
    }

    @Override
    public void update(Common entity) {
        if (!repository.existsById(getEntityId(entity))) {
            throw new EntityNotFoundException("Entity not found for update");
        }
        repository.save(entity);
    }
    protected abstract Long getEntityId(Common entity);

}
