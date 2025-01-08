package com.krk.primary_template.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.krk.primary_template.Models.Employee;
import com.krk.primary_template.Models.ProjectInformation;
import com.krk.primary_template.Responses.ApiResponse;
import com.krk.primary_template.Responses.StatusMessage;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
public class MainController {

    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    private final ProjectInformation projectInformation;

    @Autowired
    public MainController(ProjectInformation projectInformation) {
        this.projectInformation = projectInformation;
    }

    @GetMapping(value = "/data")
    public ResponseEntity<?> getProjectDetails(HttpServletRequest request) {
        logger.info("Received request to fetch project details");
        try {
            // Fetch project details
            logger.debug("Fetching JSON data from ProjectInformation");

            // Log the fetched JSON object
            logger.info("Successfully fetched project details: {}", projectInformation);

            // Return the response
            return ResponseEntity.status(HttpStatus.OK.value())
                    .body(ApiResponse.success(StatusMessage.SUCCESS, HttpStatus.OK.value(),
                            projectInformation, null,
                            request.getRequestURI()));

        }

        catch (Exception e) {
            // Catch any other unexpected exceptions
            logger.error("Unexpected error occurred: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .body(ApiResponse.error(StatusMessage.SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR.value(),
                            e.getMessage(), request.getRequestURI()));
        } finally {
            logger.info("Completed processing request for project details");
        }
    }

    @GetMapping("/employees")
    public ResponseEntity<?> getDetails(HttpServletRequest request) {
        logger.info("Received request to fetch Employee details");

        try {
            // Fetch project details
            logger.debug("Fetching JSON data from Employee");

            List<Employee> list = List.of(
                    new Employee(UUID.randomUUID(), "employee1@gmail.com", "employee1", 24, 10000),
                    new Employee(UUID.randomUUID(), "employee2@gmail.com", "employee2", 36, 20000),
                    new Employee(UUID.randomUUID(), "employee3@gmail.com", "employee3", 48, 30000),
                    new Employee(UUID.randomUUID(), "employee4@gmail.com", "employee4", 50, 50000),
                    new Employee(UUID.randomUUID(), "employee5@gmail.com", "employee5", 60, 60000));

            // Log the fetched JSON object
            logger.info("Successfully fetched details Employee: {}", list);

            return ResponseEntity.status(HttpStatus.OK.value())
                    .body(ApiResponse.success(StatusMessage.SUCCESS, HttpStatus.OK.value(),
                            list, null,
                            request.getRequestURI()));
        } catch (Exception e) {
            // Catch any other unexpected exceptions
            logger.error("Unexpected error occurred: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .body(ApiResponse.error(StatusMessage.SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR.value(),
                            e.getMessage(), request.getRequestURI()));
        } finally {
            logger.info("Completed processing request for Employee details");
        }

    }
}
