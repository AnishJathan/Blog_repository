package com.anish.blogRepo.exception;

public class ResourceNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String resourceName;
	String fieldName;
	long fieldValue;
	
	public ResourceNotFoundException(String resourceName , String fieldname , long fieldValue) {
		super(String.format("%s not found with %s : %s", resourceName , fieldname , fieldValue));
		this.resourceName= resourceName;
		this.fieldName = fieldname;
		this.fieldValue = fieldValue;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public long getFieldValue() {
		return fieldValue;
	}

	public void setFieldValue(long fieldValue) {
		this.fieldValue = fieldValue;
	}


}
