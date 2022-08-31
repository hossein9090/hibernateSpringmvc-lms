package ir.hossein.spring.service;

import java.util.List;

import ir.hossein.spring.entity.CustomerEntity;
import ir.hossein.spring.model.CustomerModel;

public interface CustomerService {

    public List <CustomerModel> getCustomers();

    public void saveCustomer(CustomerModel theCustomerModel);

    public CustomerModel getCustomer(int theId);

    public void deleteCustomer(int theId);

}