package toan.furamaresort.service;

import toan.furamaresort.model.CustomerType;

public interface CustomerTypeService {

    Iterable<CustomerType> getAllCustomerTypes();

    CustomerType getCustomerTypeById(Integer id);
}