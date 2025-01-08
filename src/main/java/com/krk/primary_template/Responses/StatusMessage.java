package com.krk.primary_template.Responses;

import org.springframework.stereotype.Component;

@Component
public class StatusMessage {

    // Success Messages
    public static final String SUCCESS = "Operation completed successfully.";
    public static final String ITEM_CREATED = "Item has been created successfully.";
    public static final String ITEM_UPDATED = "Item has been updated successfully.";
    public static final String ITEM_DELETED = "Item has been deleted successfully.";

    // Error Messages
    public static final String NOT_FOUND = "The requested resource was not found.";
    public static final String INVALID_INPUT = "Invalid input provided.";
    public static final String OPERATION_FAILED = "Operation failed. Please try again.";
    public static final String SERVER_ERROR = "An unexpected error occurred. Please contact support.";

    // Customizable or Placeholder Messages
    public static final String ITEM_NOT_FOUND = "Item with ID %s was not found.";
    public static final String USER_NOT_AUTHORIZED = "User is not authorized to perform this action.";

    // Additional messages can be added here as needed
}
