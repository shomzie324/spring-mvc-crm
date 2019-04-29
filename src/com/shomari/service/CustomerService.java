package com.shomari.service;

import com.shomari.entity.Customer;
import java.util.List;

public interface CustomerService {


  public void addCustomer(Customer customer);

  public List<Customer> getCustomers();

}
