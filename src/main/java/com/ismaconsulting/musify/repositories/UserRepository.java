package com.ismaconsulting.musify.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ismaconsulting.musify.entities.Customer;

@Repository
public interface UserRepository extends JpaRepository<Customer, String> {


}
