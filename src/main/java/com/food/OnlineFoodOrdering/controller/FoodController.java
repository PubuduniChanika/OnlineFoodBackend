package com.food.OnlineFoodOrdering.controller;

import com.food.OnlineFoodOrdering.model.Food;
import com.food.OnlineFoodOrdering.model.Restaurant;
import com.food.OnlineFoodOrdering.model.User;
import com.food.OnlineFoodOrdering.request.CreateFoodRequest;
import com.food.OnlineFoodOrdering.service.FoodService;
import com.food.OnlineFoodOrdering.service.RestaurantService;
import com.food.OnlineFoodOrdering.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FoodController {
    @Autowired
    private FoodService foodService;
    @Autowired
    private UserService userService;
    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/search")
    public ResponseEntity<List<Food>> searchFood(@RequestParam String name,
                                                 @RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findUserByJwtToken(jwt);
        List<Food> foods = foodService.searchFood(name);

        return new ResponseEntity<>(foods, HttpStatus.CREATED);
    }

    @GetMapping("/restaurant/{id}")
    public ResponseEntity<List<Food>> getRestaurantFood(
            @RequestParam boolean vegetarian,
            @RequestParam boolean seasonal,
            @RequestParam boolean nonveg,
            @RequestParam(required = false) String foodCategory,
            @PathVariable Long restaurantId,
            @RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findUserByJwtToken(jwt);
        List<Food> foods = foodService.getRestaurantFood(restaurantId, vegetarian, nonveg, seasonal, foodCategory);

        return new ResponseEntity<>(foods, HttpStatus.OK);
    }
}
