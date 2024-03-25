package com.food.OnlineFoodOrdering.controller;

import com.food.OnlineFoodOrdering.model.Food;
import com.food.OnlineFoodOrdering.model.Restaurant;
import com.food.OnlineFoodOrdering.model.User;
import com.food.OnlineFoodOrdering.request.CreateFoodRequest;
import com.food.OnlineFoodOrdering.response.MessageResponse;
import com.food.OnlineFoodOrdering.service.FoodService;
import com.food.OnlineFoodOrdering.service.RestaurantService;
import com.food.OnlineFoodOrdering.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/admin/food")
public class AdminFoodController {
    @Autowired
    private FoodService foodService;
    @Autowired
    private UserService userService;
    @Autowired
    private RestaurantService restaurantService;

    @PostMapping()
    public ResponseEntity<Food> createFood(@RequestBody CreateFoodRequest req,
                                           @RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findUserByJwtToken(jwt);
        Restaurant restaurant = restaurantService.findRestaurantById(req.getRestaurantId());
        Food food = foodService.createFood(req, req.getCategory(), restaurant);

        return new ResponseEntity<>(food, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponse> deleteFood(@PathVariable long id,
                                                     @RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findUserByJwtToken(jwt);
        foodService.deleteFood(id);

        MessageResponse res = new MessageResponse();
        res.setMessage("Food deleted successfully");

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Food> updateFoodAvailability(@PathVariable long id,
                                                      @RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findUserByJwtToken(jwt);
        Food food = foodService.availabilityStatus(id);



        return new ResponseEntity<>(food,HttpStatus.OK);
    }

}
