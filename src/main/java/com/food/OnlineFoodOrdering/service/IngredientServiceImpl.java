package com.food.OnlineFoodOrdering.service;

import com.food.OnlineFoodOrdering.model.IngredientCategory;
import com.food.OnlineFoodOrdering.model.IngredientsItem;
import com.food.OnlineFoodOrdering.model.Restaurant;
import com.food.OnlineFoodOrdering.repository.IngredientCategoryRepository;
import com.food.OnlineFoodOrdering.repository.IngredientItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientServiceImpl implements IngredientsService{
    @Autowired
    private IngredientItemRepository ingredientItemRepository;
    @Autowired
    private IngredientCategoryRepository ingredientCategoryRepository;
    @Autowired
    private RestaurantService restaurantService;

    @Override
    public IngredientCategory createIngredientCategory(String name, Long restaurantId) throws Exception {
        Restaurant restaurant = restaurantService.findRestaurantById(restaurantId);

        IngredientCategory category = new IngredientCategory();
        category.setRestaurant(restaurant);
        category.setName(name);
        return ingredientCategoryRepository.save(category);
    }

    @Override
    public IngredientCategory findIngredientById(Long id) throws Exception {
        Optional<IngredientCategory> opt = ingredientCategoryRepository.findById(id);
        if(opt.isEmpty()){
            throw new Exception("Ingredient category not found");
        }
        return opt.get();
    }

    @Override
    public List<IngredientCategory> findIngredientCategoryByRestaurantId(Long id) throws Exception {
        restaurantService.findRestaurantById(id);
        ingredientCategoryRepository.findByRestaurantId(id);
        return null;
    }

    @Override
    public IngredientsItem createIngredientItem(Long restaurantId, String ingredientName, Long categoryId) throws Exception {
        Restaurant restaurant = restaurantService.findRestaurantById(restaurantId);
        IngredientsItem item = new IngredientsItem();
        IngredientCategory category = findIngredientById(categoryId);
        item.setName(ingredientName);
        item.setRestaurant(restaurant);

        IngredientsItem ingredient = ingredientItemRepository.save(item);
        category.getIngredients().add(ingredient);
        return ingredient;
    }

    @Override
    public List<IngredientsItem> findRestaurantsIngredients(Long restaurantId) {
        return ingredientItemRepository.findByRestaurantId(restaurantId);
    }

    @Override
    public IngredientsItem updateStock(Long id) throws Exception {
        Optional<IngredientsItem> optionalIngredientsItem = ingredientItemRepository.findById(id);
        if(optionalIngredientsItem.isEmpty()){
            throw new Exception("Ingredient not found");
        }
        IngredientsItem ingredientItem = optionalIngredientsItem.get();
        ingredientItem.setInStock(!ingredientItem.isInStock());
        return ingredientItemRepository.save(ingredientItem);
    }
}
