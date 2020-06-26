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
    public Iterable<Customer> getAllActiveCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Page<Customer> getAllActiveCustomers(Pageable pageable) {
        return customerRepository.findByActive(true, pageable);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer findById(Integer id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Customer> findCustomers(String customerCode, String customerPhone,
            Pageable pageable) {
        if (customerCode == null) {
            customerCode = "";
        }
        if (customerPhone == null) {
            customerPhone = "";
        }
        return customerRepository.findCustomerByCodeAndPhone(true, customerCode, customerPhone,
                pageable);
    }

}
