package com.shomari.service;

import com.shomari.dao.CustomerDAO;
import com.shomari.entity.Customer;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

  // inject customer dao dependency
  // spring will scan for components that implement CustomerDAO interface
  @Autowired
  private CustomerDAO customerDAO;

  @Override
  @Transactional
  public List<Customer> getCustomers() {
    return customerDAO.getCustomers();
  }

  @Override
  @Transactional
  public void saveCustomer(Customer customer) {
    // add customer to db
    customerDAO.saveCustomer(customer);
  }

  @Override
  @Transactional
  public Customer getCustomer(int id) {
    // get one customer to db
    return customerDAO.getCustomer(id);
  }

  @Override
  @Transactional
  public void deleteCustomer(int id) {
    customerDAO.deleteCustomer(id);
  }

}
