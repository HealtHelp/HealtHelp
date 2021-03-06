package com.api.healthelp.controller;


import com.api.healthelp.model.dto.MAXIdDTO;
import com.api.healthelp.model.dto.PatientDTO;
import com.api.healthelp.model.dto.PatientListDTO;
import com.api.healthelp.model.entity.Patient;
import io.swagger.annotations.*;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = { "Patient" }, description = "Patient management resource")
@RestController
@ExposesResourceFor(Patient.class)
public interface PatientController {

    @ApiOperation(value = "Get patients", notes="Get patients request.")
    @GetMapping(path="/api/patients",produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiImplicitParams({ @ApiImplicitParam(name = "Authorization",
            value = "JWT Token",
            required = true,
            dataType = "string",
            paramType = "header") })
    ResponseEntity<Resources<PatientDTO>> getPatients()throws RuntimeException;

    @ApiOperation(value = "Get patient by id", notes="Get patient request.")
    @GetMapping(path="/api/patient/{id}")
    @ApiImplicitParams({ @ApiImplicitParam(name = "Authorization",
            value = "JWT Token",
            required = true,
            dataType = "string",
            paramType = "header") })
    ResponseEntity<Resource<PatientDTO>> getPatientById(@ApiParam(name="Patient id request", value="Patient id",required = true)@PathVariable("id") Integer id)throws RuntimeException;



    @ApiOperation(value = "Get patient by name", notes="Get patient request.")
    @GetMapping(path="/api/patient/name/{name}/userId/{userId}",produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiImplicitParams({ @ApiImplicitParam(name = "Authorization",
            value = "JWT Token",
            required = true,
            dataType = "string",
            paramType = "header") })
    ResponseEntity<Resources<PatientDTO>> getPatientsByName(@ApiParam(name="Patient name request", value="Patient name",required = true)@PathVariable("name")String name,
                                                            @ApiParam(name="User id request", value="User id",required = true)@PathVariable("userId") Integer id
    )throws RuntimeException;



    @ApiOperation(value="Insert patient ",notes="Insert patient request.")
    @PostMapping(path="/api/patient", produces = { MediaType.APPLICATION_JSON_VALUE },consumes = { MediaType.APPLICATION_JSON_VALUE })
    @ApiImplicitParams({ @ApiImplicitParam(name = "Authorization",
            value = "JWT Token",
            required = true,
            dataType = "string",
            paramType = "header") })
    ResponseEntity<Resource<PatientDTO>> insertPatient(@ApiParam(name="Patient request", value="Patient request",required = true)@RequestBody Patient patient);


    @ApiOperation(value="Update patient",notes="Update patient request.")
    @PutMapping(path="/api/patient", produces = { MediaType.APPLICATION_JSON_VALUE },consumes = { MediaType.APPLICATION_JSON_VALUE })
    @ApiImplicitParams({ @ApiImplicitParam(name = "Authorization",
            value = "JWT Token",
            required = true,
            dataType = "string",
            paramType = "header") })
    ResponseEntity<Resource<PatientDTO>> updatePatient(@ApiParam(name="Patient request", value="Patient request",required = true)@RequestBody Patient patient);

    @ApiOperation(value="Delete patient",notes="Delete patient request.")
    @DeleteMapping(path="/api/patient/{id}",produces = { MediaType.APPLICATION_JSON_VALUE },consumes = { MediaType.ALL_VALUE })
    @ApiImplicitParams({ @ApiImplicitParam(name = "Authorization",
            value = "JWT Token",
            required = true,
            dataType = "string",
            paramType = "header")})
    ResponseEntity<Resource<Boolean>> deletePatient(@ApiParam(name="Patient id request", value="Patient id", required = true,defaultValue = "0")@PathVariable("id") Integer id);


}
