package com.matheussilvestre.storage_manager.services.exception;

public class ObjectNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public ObjectNotFoundException(String errorMsg) {
		super(errorMsg);
	}

}
