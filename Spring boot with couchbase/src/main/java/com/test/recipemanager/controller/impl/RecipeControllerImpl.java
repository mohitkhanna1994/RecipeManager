package com.test.recipemanager.controller.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.recipemanager.biz.RecipeBizManager;
import com.test.recipemanager.constant.RecipeConstant;
import com.test.recipemanager.controller.RecipeController;
import com.test.recipemanager.exception.RecipeException;
import com.test.recipemanager.model.DropdownObj;
import com.test.recipemanager.model.RecipeObj;
import com.test.recipemanager.model.Response;

@RestController
@RequestMapping("/recipe")
public class RecipeControllerImpl implements RecipeController {
	private static final Logger LOGGER = LoggerFactory.getLogger(RecipeControllerImpl.class);

	String CLIENT_ERR_MSG = RecipeConstant.DEFAULT_CLIENT_ERR_MSG;
	String CLIENT_SUC_MSG = "";
	String errorMsg = "";
	String clientMsg = "";

	@Autowired
	RecipeBizManager recipeBizManager;

	public ResponseEntity<Response> addRecipe(@RequestBody RecipeObj recipeObj) throws RecipeException {
		ResponseEntity<Response> result = null;
		String errorMsg = "";
		HttpStatus status = HttpStatus.OK;

		LOGGER.info("inside add recipe " + recipeObj);
		try {
			recipeBizManager.addRecipe(recipeObj);
		} catch (Exception e) {
			status = HttpStatus.INTERNAL_SERVER_ERROR;
			errorMsg = e.getMessage();

			LOGGER.error("Failed to add recipe", e);
		}
		CLIENT_SUC_MSG = RecipeConstant.RECIPE_ADDED_MSG;

		clientMsg = (status.value() == RecipeConstant.FUNC_RETURN_CODE_404 ? errorMsg
				: (status.value() == RecipeConstant.FUNC_RETURN_CODE_200 ? CLIENT_SUC_MSG : CLIENT_ERR_MSG));
		result = new ResponseEntity<Response>(new Response(status.value(), errorMsg, clientMsg), status);
		return result;
	}

	public ResponseEntity<Response> getRecipe(@RequestParam String id) throws RecipeException {
		ResponseEntity<Response> result = null;
		String errorMsg = "";
		HttpStatus status = HttpStatus.OK;
		RecipeObj recipe = null;
		LOGGER.info("inside get recipe " + id);
		if (null == id) {
			status = HttpStatus.BAD_REQUEST;
			errorMsg = RecipeConstant.ID_NULL_ERR_MSG;

			LOGGER.error("Id cannot be null", "");
		} else {
			try {
				recipe = recipeBizManager.getRecipe(id);
			} catch (Exception e) {
				status = HttpStatus.INTERNAL_SERVER_ERROR;
				errorMsg = e.getMessage();

				LOGGER.error("Failed to get recipe", e);
			}
		}
		clientMsg = (status.value() == RecipeConstant.FUNC_RETURN_CODE_404 ? errorMsg
				: (status.value() == RecipeConstant.FUNC_RETURN_CODE_200 ? CLIENT_SUC_MSG : CLIENT_ERR_MSG));
		result = new ResponseEntity<Response>(new Response(status.value(), recipe, errorMsg, clientMsg), status);
		return result;
	}

	public ResponseEntity<Response> getDropdown() throws RecipeException {
		ResponseEntity<Response> result = null;
		String errorMsg = "";
		HttpStatus status = HttpStatus.OK;

		List<DropdownObj> dropdownObj = null;
		try {
			dropdownObj = recipeBizManager.getDropdown();
		} catch (Exception e) {
			status = HttpStatus.INTERNAL_SERVER_ERROR;
			errorMsg = e.getMessage();

			LOGGER.error("Failed to get dropdown", e);
		}

		clientMsg = (status.value() == RecipeConstant.FUNC_RETURN_CODE_404 ? errorMsg
				: (status.value() == RecipeConstant.FUNC_RETURN_CODE_200 ? CLIENT_SUC_MSG : CLIENT_ERR_MSG));
		result = new ResponseEntity<Response>(new Response(status.value(), dropdownObj, errorMsg, clientMsg), status);
		return result;
	}
}
