package com.test.recipemanager.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Response {
	private int status;
	private String message, clientMsg;
	private long timestamp;
	private Object result;

	public Response(int status, Object result, String message, String clientMsg) {
		super();
		this.status = status;
		this.message = message;
		this.clientMsg = clientMsg;
		this.result = result;
		this.timestamp = System.currentTimeMillis();
	}

	public Response(int status, String message, String clientMsg) {
		super();
		this.status = status;
		this.message = message;
		this.clientMsg = clientMsg;
	}
}