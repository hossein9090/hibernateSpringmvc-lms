package ir.hossein.spring.ropository;

import java.util.List;

import ir.hossein.spring.entity.CustomerEntity;

public interface CustomerRepo {

    public List <CustomerEntity> getCustomers();

    public void saveCustomer(CustomerEntity theCustomerEntity);

    public CustomerEntity getCustomer(int theId);

    public void deleteCustomer(int theId);
}
