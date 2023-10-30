package com.springboot.application5.service.common;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public abstract class CommonServiceImpl <Common> implements CommonService<Common> {
    private final JpaRepository<Common, Long> repository;

    public CommonServiceImpl(JpaRepository<Common, Long> repository) {

        this.repository = repository;
    }

    @Override
    public List<Common> getAll() {
        return repository.findAll();
    }

    @Override
    public Common getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Common save(Common entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void update(Common entity) {
        repository.save(entity);
    }


}
