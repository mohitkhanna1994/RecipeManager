package com.test.recipemanager.biz;

import java.util.List;

import com.test.recipemanager.exception.RecipeException;
import com.test.recipemanager.model.DropdownObj;
import com.test.recipemanager.model.RecipeObj;

public interface RecipeBizManager {

	int addRecipe(RecipeObj recipeObj) throws RecipeException;

	RecipeObj getRecipe(String id) throws RecipeException;

	List<DropdownObj> getDropdown() throws RecipeException;

}
