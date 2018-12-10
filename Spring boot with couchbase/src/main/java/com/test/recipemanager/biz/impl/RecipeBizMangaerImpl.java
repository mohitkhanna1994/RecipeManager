package com.test.recipemanager.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.recipemanager.biz.RecipeBizManager;
import com.test.recipemanager.constant.RecipeConstant;
import com.test.recipemanager.dao.RecipeDao;
import com.test.recipemanager.exception.RecipeException;
import com.test.recipemanager.model.DropdownObj;
import com.test.recipemanager.model.RecipeObj;

@Service
public class RecipeBizMangaerImpl implements RecipeBizManager {

	@Autowired
	RecipeDao recipeDao;

	public int addRecipe(RecipeObj recipeObj) throws RecipeException {
		int code = RecipeConstant.FUNC_RETURN_CODE_400;

		List<DropdownObj> allRecipes = getDropdown();
		for (DropdownObj recipe : allRecipes) {
			if (recipe.getName().equalsIgnoreCase(recipeObj.getName())) {
				throw new RecipeException("Recipe with this name already exists. Please give another name");
			}
		}
		try {
			recipeObj.setId();
			recipeObj.setDocId();
			recipeObj.setMeta();
			code = recipeDao.addRecipe(recipeObj);
		} catch (Exception e) {
//			e.printStackTrace();
			throw new RecipeException("Failed to add recipe");
		}
		return code;
	}

	public RecipeObj getRecipe(String id) throws RecipeException {
		return recipeDao.getRecipe(id);
	}

	public List<DropdownObj> getDropdown() throws RecipeException {
		return recipeDao.getDropdown();
	}

}
