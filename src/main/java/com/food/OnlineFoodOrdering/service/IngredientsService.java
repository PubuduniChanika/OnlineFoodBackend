package com.food.OnlineFoodOrdering.service;

import com.food.OnlineFoodOrdering.model.IngredientCategory;
import com.food.OnlineFoodOrdering.model.IngredientsItem;

import java.util.List;

public interface IngredientsService {
    public IngredientCategory createIngredientCategory(String name, Long restaurantId) throws Exception;
    public IngredientCategory findIngredientById(Long id) throws Exception;
    public List<IngredientCategory> findIngredientCategoryByRestaurantId(Long id) throws Exception;
    public IngredientsItem createIngredientItem(Long restaurantId, String ingredientName, Long categoryId) throws Exception;
    public List<IngredientsItem> findRestaurantsIngredients(Long restaurantId);
    public IngredientsItem updateStock(Long id) throws Exception;
}
