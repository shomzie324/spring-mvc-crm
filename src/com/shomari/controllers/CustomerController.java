package com.shomari.controllers;

import com.shomari.entity.Customer;
import com.shomari.service.CustomerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

  @PostMapping("/saveCustomer")
  public String saveCustomer(@ModelAttribute("customer") Customer customer){

    // use customer service to add customer to db
    customerService.saveCustomer(customer);


    return "redirect:/customer/list";
  }

  @GetMapping("/showUpdateForm")
  public String showUpdateForm(@RequestParam("customerId") int id, Model model){
    // get customer from db
    Customer customer = customerService.getCustomer(id);

    // set customer as a model attribute to pre populate form
    // already set up with modelAttribute in form form adding customer route
    // gets will be called to populate fields
    model.addAttribute("customer", customer);

    // forward request to form
    return "customer-form";
  }

  @GetMapping("/delete")
  public String deleteCustomer(@RequestParam("customerId") int id){

    // delete customer
    customerService.deleteCustomer(id);


    return "redirect:/customer/list";
  }

}
