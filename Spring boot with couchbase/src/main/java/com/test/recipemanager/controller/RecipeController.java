package com.test.recipemanager.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.recipemanager.exception.RecipeException;
import com.test.recipemanager.model.RecipeObj;
import com.test.recipemanager.model.Response;

public interface RecipeController {

	/**
	 * Add a recipe to the database
	 * 
	 * @param recipeObj
	 * @return response having success or failure
	 */
	@RequestMapping(value = "/addRecipe", method = {
			RequestMethod.POST }, consumes = "application/json", produces = "application/json")
	@ResponseBody
	@CrossOrigin
	public ResponseEntity<Response> addRecipe(@RequestBody RecipeObj recipeObj) throws RecipeException;

	/**
	 * get a recipe to the database for the id
	 * 
	 * @param id
	 * @return response having the recipe obj
	 */
	@RequestMapping(value = "/getRecipe", method = { RequestMethod.GET }, produces = "application/json")
	@ResponseBody
	@CrossOrigin
	public ResponseEntity<Response> getRecipe(@RequestParam String id) throws RecipeException;

	/**
	 * get all the recipes from the database
	 * 
	 * @return response having the list of recipe name and id
	 */
	@RequestMapping(value = "/getDropdown", method = { RequestMethod.GET }, produces = "application/json")
	@ResponseBody
	@CrossOrigin
	public ResponseEntity<Response> getDropdown() throws RecipeException;

}
