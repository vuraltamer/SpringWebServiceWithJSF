package com.springwebservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.springwebservice.model.Slogan;
import com.springwebservice.repository.SloganRepository;

@Service
public class SloganService {

    @Autowired
    public SloganRepository sloganRepository;

    public Slogan create() {
        return new Slogan();
    }

    public void delete(Slogan slogan) {
        sloganRepository.delete(slogan);
    }

    public Slogan add(Slogan slogan) {
        return sloganRepository.saveAndFlush(slogan);
    }

    public List<Slogan> findAll() {
        return (sloganRepository.findAll(new Sort(Sort.Direction.DESC, "sloganId")));
    }

    public Slogan findById(Long Id) {
        return (sloganRepository.findOne(Id));
    }

}
