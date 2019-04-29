package com.shomari.dao;

import com.shomari.entity.Customer;
import java.util.List;

public interface CustomerDAO {

  List<Customer> getCustomers();

  void saveCustomer(Customer customer);

  Customer getCustomer(int id);

  void deleteCustomer(int id);
}
