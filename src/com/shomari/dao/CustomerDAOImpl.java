package com.shomari.dao;

import com.shomari.entity.Customer;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDAOImpl implements CustomerDAO{

  // inject session factory
  @Autowired
  private SessionFactory sessionFactory;


  @Override
  public List<Customer> getCustomers(){
    // get a hibernate session
    Session currentSession = sessionFactory.getCurrentSession();

    // create query
    // go by entity field regardless of what column its mapped to in the db
    Query<Customer> query = currentSession.createQuery("from Customer order by lastName", Customer
        .class);

    // execute query and get results
    List<Customer> customers = query.getResultList();

    // return list of customers
    return customers;
  }

  @Override
  public void saveCustomer(Customer customer) {
    // get a hibernate session
    Session currentSession = sessionFactory.getCurrentSession();

    // use saveOrUpdate instead of save customer to db
    // if pk is empty (null or 0) it adds new
    // if pk is not empty, hibernate does an update
    currentSession.saveOrUpdate(customer);
  }

  @Override
  public Customer getCustomer(int id){
    // get a hibernate session
    Session currentSession = sessionFactory.getCurrentSession();

    // get the customer using primary key id
    Customer customer = currentSession.get(Customer.class, id);

    return customer;
  }

  @Override
  public void deleteCustomer(int id) {
    // get a hibernate session
    Session currentSession = sessionFactory.getCurrentSession();

    // delete customer
    Query query = currentSession.createQuery(
        "delete from Customer where id=:customerId");

    query.setParameter("customerId",id);

    query.executeUpdate();

  }

}
