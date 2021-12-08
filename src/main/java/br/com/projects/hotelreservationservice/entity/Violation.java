package br.com.projects.hotelreservationservice.entity;

/** Class to handle a violation */
public class Violation {

    /** Field's name that triggers the error */
    private final String fieldName;

    /** Error message */
    private final String message;
    
    public Violation(String fieldName, String message) {
        this.fieldName = fieldName;
        this.message = message;
    }
    public String getFieldName() {
        return fieldName;
    }
    public String getMessage() {
        return message;
    }

    
}
