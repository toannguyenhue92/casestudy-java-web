package toan.furamaresort.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import toan.furamaresort.model.Customer;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, Integer> {

    Page<Customer> findByActive(Boolean active, Pageable pageable);

}