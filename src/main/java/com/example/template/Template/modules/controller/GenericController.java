package com.example.template.Template.modules.controller;

import com.example.template.Template.modules.service.IGenericService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.management.InstanceNotFoundException;
import java.io.IOException;

public class GenericController<T, ID> {

    private final IGenericService<T, ID> service;
    private static final Logger log = LoggerFactory.getLogger(GenericController.class);


    public GenericController(IGenericService<T, ID> service) {
        this.service = service;
    }

    @GetMapping("")
    @ApiOperation(value = "Get the list entities part of crud controller",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            httpMethod = "GET")
    @ApiResponses({
            @ApiResponse(code = 200, message = "The request has succeeded and get All entities "
                    + "<li>Iterable</li>"),
            @ApiResponse(code = 401, message = "The request requires user authentication"),
            @ApiResponse(code = 403,
                    message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404,
                    message = "The server has not found anything matching the Request-URI"),
            @ApiResponse(code = 400, message = "Request is bad"),
            @ApiResponse(code = 500, message = "Error with backend")
    })
    public Iterable<T> getAll() throws IOException {
        return service.findAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get the entity part of crud controller",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            httpMethod = "GET")
    @ApiResponses({
            @ApiResponse(code = 200, message = "The request has succeeded get entity by id "
                    + "<li>Object</li>"),
            @ApiResponse(code = 401, message = "The request requires user authentication"),
            @ApiResponse(code = 403,
                    message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404,
                    message = "The server has not found anything matching the Request-URI"),
            @ApiResponse(code = 400, message = "Request is bad"),
            @ApiResponse(code = 500, message = "Error with backend")
    })
    public T search(
            @ApiParam(value = "Entity id search", example = "1", required = true)
            @PathVariable ID id) throws InstanceNotFoundException, IOException {
        return service.findById(id)
                .orElseThrow(() -> new InstanceNotFoundException("Not found Object"));
    }

    @PostMapping(value = "")
    @ApiOperation(value = "Save the entity part of crud controller",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            httpMethod = "POST")
    @ApiResponses({
            @ApiResponse(code = 200, message = "The request has succeeded save the entity <li>void</li>"),
            @ApiResponse(code = 401, message = "The request requires user authentication"),
            @ApiResponse(code = 403,
                    message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404,
                    message = "The server has not found anything matching the Request-URI"),
            @ApiResponse(code = 400, message = "Request is bad"),
            @ApiResponse(code = 500, message = "Error with backend")
    })
    public T add(
            @ApiParam(value = "Entity object to save", example = "{ object }", required = true)
            @RequestBody T object) throws Exception {
        return service.insert(object);
    }

    @PutMapping(value = "")
    @ApiOperation(value = "Update the entity part of crud controller",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            httpMethod = "PUT")
    @ApiResponses({
            @ApiResponse(code = 200, message = "The request has succeeded update the entity <li>void</li>"),
            @ApiResponse(code = 401, message = "The request requires user authentication"),
            @ApiResponse(code = 403,
                    message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404,
                    message = "The server has not found anything matching the Request-URI"),
            @ApiResponse(code = 400, message = "Request is bad"),
            @ApiResponse(code = 500, message = "Error with backend")
    })
    public T update(
            @ApiParam(value = "Entity object to update", example = "{ object }", required = true)
            @RequestBody T object) throws Exception {
        return service.update(object);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "Delete the entity part of crud controller <li>void</li>",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            httpMethod = "DELETE")
    @ApiResponses({
            @ApiResponse(code = 200, message = "The request has succeeded delete the entity"),
            @ApiResponse(code = 401, message = "The request requires user authentication"),
            @ApiResponse(code = 403,
                    message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404,
                    message = "The server has not found anything matching the Request-URI"),
            @ApiResponse(code = 400, message = "Request is bad"),
            @ApiResponse(code = 500, message = "Error with backend")
    })
    public void delete(
            @ApiParam(value = "Entity id delete", example = "1", required = true)
            @PathVariable ID id) throws Exception {
        service.delete(id);
    }

    @ExceptionHandler({InstanceNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void notFoundHandler() {
        log.error("not found entity");
    }

    @ExceptionHandler({IOException.class})
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    public void notErrorConnection() {
        log.error("not found entity");
    }
}
