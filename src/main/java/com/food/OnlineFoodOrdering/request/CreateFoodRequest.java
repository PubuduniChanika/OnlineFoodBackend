package com.food.OnlineFoodOrdering.request;

import com.food.OnlineFoodOrdering.model.Category;
import com.food.OnlineFoodOrdering.model.IngredientsItem;
import lombok.Data;

import java.util.List;

@Data
public class CreateFoodRequest {
    private String name;
    private String description;
    private Long price;

    private Category category;
    private List<String> images;

    private Long restaurantId;
    private boolean vegetarian;
    private boolean seasonal;
    private List<IngredientsItem> ingredients;

}
