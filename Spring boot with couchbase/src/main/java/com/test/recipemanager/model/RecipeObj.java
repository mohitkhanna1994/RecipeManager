package com.test.recipemanager.model;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;
import com.test.recipemanager.constant.RecipeConstant;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class RecipeObj implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String docId;

	@Field
	private String name, id;

	@Field
	List<Ingredient> ingredients;
	
	@Field
	private Meta meta;

	public void setId() {
		this.id = UUID.randomUUID().toString();
	}
	
	public void setDocId() {
		this.docId = RecipeConstant.TBL_NM_RECIPE + "_" + this.id;
	}

	public void setMeta() {
		Meta meta = new Meta();
		meta.setTableName(RecipeConstant.TBL_NM_RECIPE);
		this.meta=meta;
	}

	@Override
	public String toString() {
		return "RecipeObj [docId=" + docId + ", name=" + name + ", id=" + id + ", ingredients=" + ingredients
				+ ", meta=" + meta + "]";
	}

}
