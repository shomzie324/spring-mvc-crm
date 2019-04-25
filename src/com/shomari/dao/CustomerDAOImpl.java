package com.shomari.dao;

import com.shomari.entity.Customer;
import java.util.List;
import javax.transaction.Transactional;
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
  @Transactional
  public List<Customer> getCustomers(){
    // get a hibernate session
    Session currentSession = sessionFactory.getCurrentSession();

    // create query
    Query<Customer> query = currentSession.createQuery("from Customer", Customer.class);

    // execute query and get results
    List<Customer> customers = query.getResultList();

    // return list of customers
    return customers;
  }

}
