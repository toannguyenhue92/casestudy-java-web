package toan.furamaresort.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import toan.furamaresort.model.Gender;
import toan.furamaresort.repository.GenderRepository;
import toan.furamaresort.service.GenderService;

public class GenderServiceImpl implements GenderService {

    @Autowired
    private GenderRepository genderRepository;

    @Override
    public Iterable<Gender> getAllGenders() {
        return genderRepository.findAll();
    }

}