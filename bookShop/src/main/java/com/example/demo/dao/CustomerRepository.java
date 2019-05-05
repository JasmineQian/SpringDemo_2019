package com.example.demo.dao;

import com.example.demo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    //Customer findByName(String name);
    //query did not return a unique result: 3;
    //nested exception is javax.persistence.NonUniqueResultException: query did not return a unique result: 3

    List<Customer> findByName(String name);
}
