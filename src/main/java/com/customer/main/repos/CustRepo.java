package com.customer.main.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customer.main.model.Model;

public interface CustRepo extends JpaRepository<Model, Integer> {

}
