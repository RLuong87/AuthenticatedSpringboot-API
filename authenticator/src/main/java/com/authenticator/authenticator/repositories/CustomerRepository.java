package com.authenticator.authenticator.repositories;

import com.authenticator.authenticator.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    //    Customer findByUser_id(Long id);
}
