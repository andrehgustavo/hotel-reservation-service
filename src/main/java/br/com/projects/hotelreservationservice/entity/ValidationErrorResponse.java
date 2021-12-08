package br.com.projects.hotelreservationservice.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * A Class to handle validations messages.
 */
public class ValidationErrorResponse {
    
    /** A list of violations */
    private List<Violation> violations = new ArrayList<Violation>();

    public ValidationErrorResponse(List<Violation> violations) {
        this.violations = violations;
    }

    public ValidationErrorResponse() {
    }

    public List<Violation> getViolations() {
        return violations;
    }

    public void setViolations(List<Violation> violations) {
        this.violations = violations;
    }

    
}
