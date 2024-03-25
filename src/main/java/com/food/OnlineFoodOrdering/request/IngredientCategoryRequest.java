package com.food.OnlineFoodOrdering.request;

import com.food.OnlineFoodOrdering.model.IngredientCategory;
import com.food.OnlineFoodOrdering.service.IngredientsService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@Data
public class IngredientCategoryRequest {
   private String name;
   private Long categoryId;
   private Long restaurantId;

}
