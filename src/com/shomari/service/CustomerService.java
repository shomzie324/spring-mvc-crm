package com.shomari.service;

import com.shomari.entity.Customer;
import java.util.List;

public interface CustomerService {


  void saveCustomer(Customer customer);

  List<Customer> getCustomers();

  Customer getCustomer(int id);

  void deleteCustomer(int id);
}
