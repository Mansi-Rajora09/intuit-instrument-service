package com.springboot.intuit.utils;

import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.Calendar;
import java.util.Date;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import jakarta.validation.ValidationException;

public class ValidationTest {
    private final Validation utility = new Validation();

    @ParameterizedTest
    @CsvSource({
            "Test, false", // Valid name
            "12345, true", // Name contains only integers
            "'', true" // Empty name
    })
    public void testValidateName(String name, boolean expectException) {
        if (expectException) {
            assertThrows(ValidationException.class, () -> utility.validateName(name));
        } else {
            // No exception expected
            utility.validateName(name);
        }
    }

    @Test
    public void testValidateCategoryId_Valid() {
        // Call validateCategoryId with a valid categoryId (e.g., containing only
        // digits)
        String validCategoryId = "123";
        utility.validateCategoryId(validCategoryId);

        // No exception should be thrown
    }

    @Test
    public void testValidateCategoryId_Invalid() {
        // Call validateCategoryId with an invalid categoryId (e.g., containing
        // characters)
        String invalidCategoryId = "abc";

        // Assert that a ValidationException is thrown
        assertThrows(ValidationException.class, () -> utility.validateCategoryId(invalidCategoryId));
    }

}
