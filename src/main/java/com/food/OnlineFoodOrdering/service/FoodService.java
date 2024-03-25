package com.food.OnlineFoodOrdering.service;

import com.food.OnlineFoodOrdering.model.Category;
import com.food.OnlineFoodOrdering.model.Food;
import com.food.OnlineFoodOrdering.model.Restaurant;
import com.food.OnlineFoodOrdering.request.CreateFoodRequest;

import java.util.List;

public interface FoodService {
    public Food createFood(CreateFoodRequest req, Category category, Restaurant restaurant);
    public void deleteFood(Long foodId) throws Exception;
    public List<Food> getRestaurantFood(Long restaurantId,
                                        boolean isVegetarian,
                                        boolean isNonveg,
                                        boolean isSeasonal,
                                        String foodCategory);
    public List<Food> searchFood(String keyword);
    public Food findFoodById(Long foodId) throws Exception;
    public Food availabilityStatus(Long foodId) throws Exception;
}
