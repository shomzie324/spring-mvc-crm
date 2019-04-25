package com.shomari.controllers;

import com.shomari.dao.CustomerDAO;
import com.shomari.entity.Customer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {

  // need to inject DAO into controller
  // spring will scan for components that implement CustomerDAO interface
  @Autowired
  private CustomerDAO customerDAO;

  @RequestMapping("/list")
  public String listCustomers(Model model){

    // get customers from dao
    List<Customer> theCustomers = customerDAO.getCustomers();

    // add those customers to spring model
    model.addAttribute("customers", theCustomers);

    //return jsp page
    return "list-customers";
  }

}
