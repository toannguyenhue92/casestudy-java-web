package toan.furamaresort.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import toan.furamaresort.model.Customer;

public interface CustomerService {
    Page<Customer> getAllActiveCustomers(Pageable pageable);
}