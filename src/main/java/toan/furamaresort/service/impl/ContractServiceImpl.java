package toan.furamaresort.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import toan.furamaresort.model.Contract;
import toan.furamaresort.repository.ContractRepository;
import toan.furamaresort.service.ContractService;

@Service
public class ContractServiceImpl implements ContractService {

    @Autowired
    private ContractRepository contractRepository;

    @Override
    public List<Contract> getAllContracts() {
        return contractRepository.findAll();
    }

    @Override
    public Page<Contract> getAllContracts(Pageable pageable) {
        return contractRepository.findAllByActive(Boolean.TRUE, pageable);
    }

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }

}