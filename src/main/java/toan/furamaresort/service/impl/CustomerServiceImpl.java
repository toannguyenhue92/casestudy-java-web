package toan.furamaresort.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import toan.furamaresort.model.Customer;
import toan.furamaresort.repository.CustomerRepository;
import toan.furamaresort.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Page<Customer> getAllActiveCustomers(Pageable pageable) {
        return customerRepository.findByActive(true, pageable);
    }

}