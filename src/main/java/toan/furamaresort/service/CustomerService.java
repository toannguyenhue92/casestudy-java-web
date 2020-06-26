package toan.furamaresort.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import toan.furamaresort.model.Customer;

public interface CustomerService {
    
    Iterable<Customer> getAllActiveCustomers();

    Page<Customer> getAllActiveCustomers(Pageable pageable);

    void save(Customer customer);

    Customer findById(Integer id);

    Iterable<Customer> findCustomers(Pageable pageable, String customerCode, String customerPhone);
}
