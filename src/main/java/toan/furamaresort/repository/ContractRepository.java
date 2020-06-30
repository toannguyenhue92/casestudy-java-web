package toan.furamaresort.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import toan.furamaresort.model.Contract;

public interface ContractRepository extends JpaRepository<Contract, Integer> {

	Page<Contract> findAllByActive(Boolean active, Pageable pageable);
    
}