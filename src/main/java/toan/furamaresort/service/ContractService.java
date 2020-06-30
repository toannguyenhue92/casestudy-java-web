package toan.furamaresort.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import toan.furamaresort.model.Contract;

public interface ContractService {
    List<Contract> getAllContracts();
    Page<Contract> getAllContracts(Pageable pageable);
	void save(Contract contract);
}