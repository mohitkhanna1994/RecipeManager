package com.test.recipemanager.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.couchbase.client.java.query.N1qlQuery;
import com.test.recipemanager.config.CouchbaseConnService;
import com.test.recipemanager.constant.RecipeConstant;
import com.test.recipemanager.dao.RecipeDao;
import com.test.recipemanager.exception.RecipeException;
import com.test.recipemanager.model.DropdownObj;
import com.test.recipemanager.model.RecipeObj;

@Repository
public class RecipeDaoImpl extends CouchbaseConnService implements RecipeDao {

	@Value("${get.dropdown}")
	public String GET_DROPDOWN;
	
	public int addRecipe(RecipeObj recipeObj) throws RecipeException {
		int code = RecipeConstant.FUNC_RETURN_CODE_400;
		try {
			template.save(recipeObj);
			code = RecipeConstant.FUNC_RETURN_CODE_200;
		}catch (Exception e) {
			throw new RecipeException("Failed to add recipe");
		}
		return code;
	}

	public RecipeObj getRecipe(String id) throws RecipeException {
		RecipeObj recipe = new RecipeObj();
		try {
			String docId = RecipeConstant.TBL_NM_RECIPE + "_" + id;
			recipe = template.findById(docId, RecipeObj.class);
		}catch (Exception e) {
			throw new RecipeException("Failed to get recipe");
		}
		return recipe;
	}

	public List<DropdownObj> getDropdown() throws RecipeException {
		List<DropdownObj> dropdownObj = new ArrayList<DropdownObj>();
		try {
			N1qlQuery query = N1qlQuery.simple(GET_DROPDOWN);
			dropdownObj = template.findByN1QL(query, DropdownObj.class);
		}catch (Exception e) {
			throw new RecipeException("Failed to get dropdown");
		}
		return dropdownObj;
	}

}
