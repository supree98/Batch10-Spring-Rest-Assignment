package com.te.amazonwebapp.customexception;

public class AmazonException extends RuntimeException{

	public AmazonException(String message) {
		super(message);
	}
}
