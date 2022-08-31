package ir.hossein.spring.service.impl;

import java.util.List;

import ir.hossein.spring.mapper.CustomerMapper;
import ir.hossein.spring.model.CustomerModel;
import ir.hossein.spring.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ir.hossein.spring.ropository.CustomerRepo;
import ir.hossein.spring.entity.CustomerEntity;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    @Transactional
    public List <CustomerModel> getCustomers() {
        List<CustomerEntity> customerEntityList = customerRepo.getCustomers();
        List<CustomerModel> customerModels = customerMapper.convertListToListModel(customerEntityList);
        return customerModels;
    }

    @Override
    @Transactional
    public void saveCustomer(CustomerModel theCustomerModel) {
        CustomerEntity customerEntity = customerMapper.convertToEntity(theCustomerModel);
        customerRepo.saveCustomer(customerEntity);
    }

    @Override
    @Transactional
    public CustomerModel getCustomer(int theId) {
        CustomerEntity customerEntity = customerRepo.getCustomer(theId);
        CustomerModel customerModel = customerMapper.convertToModel(customerEntity);
        return customerModel;
    }

    @Override
    @Transactional
    public void deleteCustomer(int theId) {

        //TODO   change for adding bookMapper:

        customerRepo.deleteCustomer(theId);
    }
}
