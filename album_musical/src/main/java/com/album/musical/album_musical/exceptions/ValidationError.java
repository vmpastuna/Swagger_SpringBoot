package com.album.musical.album_musical.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError {
    
    private List<ErrorDetails> violations = new ArrayList<>();

    public List<ErrorDetails> getViolations() {
        return violations;
    }

    public void addViolations(ErrorDetails violation) {
        this.violations.add(violation);
    }

}
