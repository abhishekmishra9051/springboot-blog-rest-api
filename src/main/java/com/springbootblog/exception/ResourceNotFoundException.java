package com.springbootblog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * ResourceNotFoundException is a custom exception that is thrown when a resource is not found.
 * It extends RuntimeException, meaning it's an unchecked exception.
 * It's annotated with @ResponseStatus, which marks it for Spring to associate it with a response status code.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    
    // Name of the resource that could not be found
    private String resourceName;
    // Name of the field that was queried
    private String fieldName;
    // Value of the field that was queried
    private long fieldValue;
    
    /**
     * Constructs a new ResourceNotFoundException with the specified detail message.
     * @param resourceName the name of the resource that could not be found
     * @param fieldName the name of the field that was queried
     * @param fieldValue the value of the field that was queried
     */
	public ResourceNotFoundException(String resourceName, String fieldName, long fieldValue) {
		super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue)); // Post not found with id : 1;
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
    
    /**
     * Returns the name of the resource that could not be found.
     * @return the name of the resource
     */
	public String getResourceName() {
		return resourceName;
	}
	
    /**
     * Returns the name of the field that was queried.
     * @return the name of the field
     */
	public String getFieldName() {
		return fieldName;
	}
	
    /**
     * Returns the value of the field that was queried.
     * @return the value of the field
     */
	public long getFieldValue() {
		return fieldValue;
	}
}
