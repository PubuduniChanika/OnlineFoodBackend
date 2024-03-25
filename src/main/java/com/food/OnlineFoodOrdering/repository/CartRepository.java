package com.food.OnlineFoodOrdering.repository;

import com.food.OnlineFoodOrdering.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Long> {
}
