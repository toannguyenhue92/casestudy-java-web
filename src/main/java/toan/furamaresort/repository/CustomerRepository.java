package toan.furamaresort.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import toan.furamaresort.model.Customer;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, Integer> {

    Page<Customer> findByActive(Boolean active, Pageable pageable);

    @Query(value = "SELECT * FROM customers WHERE active = ? AND customer_code LIKE %?% "
            + " AND phone_number LIKE %?%", nativeQuery = true)
    Page<Customer> findCustomerByCodeAndPhone(Boolean active, String customerCode,
            String customerPhone, Pageable pageable);

}
