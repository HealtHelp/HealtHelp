package com.api.healthelp.controller;


import com.api.healthelp.model.dto.PatientDTO;
import com.api.healthelp.model.entity.Patient;
import io.swagger.annotations.*;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    @GetMapping(path="/api/patient/{id}",produces = {MediaType.APPLICATION_JSON_VALUE} ,consumes = { MediaType.APPLICATION_JSON_VALUE })
    @ApiImplicitParams({ @ApiImplicitParam(name = "Authorization",
            value = "JWT Token",
            required = true,
            dataType = "string",
            paramType = "header") })
    ResponseEntity<PatientDTO> getPatientById(@ApiParam(name="Patient id request", value="Patient id",required = true, type ="Long")@PathVariable("id") Long id)throws RuntimeException;


}
