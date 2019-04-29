package com.shomari.controllers;

import com.shomari.entity.Customer;
import com.shomari.service.CustomerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {

  // need to inject customer service into controller
  @Autowired
  private CustomerService customerService;

  @GetMapping("/list")
  public String listCustomers(Model model){

    // get customers from service
    List<Customer> theCustomers = customerService.getCustomers();

    // add those customers to spring model
    model.addAttribute("customers", theCustomers);

    //return jsp page
    return "list-customers";
  }

  @GetMapping("/showAddForm")
  public String showAddCustomerForm(Model model){

    // create model attribute to bind form data
    Customer customer = new Customer();

    model.addAttribute("customer", customer);
    return "customer-form";
  }

  @PostMapping("/addCustomer")
  public String addCustomer(@ModelAttribute("customer") Customer customer){

    // use customer service to add customer to db
    customerService.addCustomer(customer);


    return "redirect:/customer/list";
  }

}
