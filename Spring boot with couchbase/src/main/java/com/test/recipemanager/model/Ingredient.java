package com.test.recipemanager.model;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Ingredient implements Serializable {
	private static final long serialVersionUID = 1L;

	private String ing;
}
