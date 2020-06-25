package toan.furamaresort.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import toan.furamaresort.model.CustomerType;
import toan.furamaresort.repository.CustomerTypeRepository;
import toan.furamaresort.service.CustomerTypeService;

@Service
public class CustomerTypeServiceImpl implements CustomerTypeService {

    @Autowired
    private CustomerTypeRepository customerTypeRepository;

    @Override
    public Iterable<CustomerType> getAllCustomerTypes() {
        return customerTypeRepository.findAll();
    }

    @Override
    public CustomerType getCustomerTypeById(Integer id) {
        return customerTypeRepository.findById(id).orElse(null);
    }

}