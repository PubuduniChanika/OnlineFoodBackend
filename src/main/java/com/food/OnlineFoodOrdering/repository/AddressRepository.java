package com.food.OnlineFoodOrdering.repository;

import com.food.OnlineFoodOrdering.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
