package com.api.healthelp.controller.impl;

import com.api.healthelp.controller.PatientController;
import com.api.healthelp.model.dto.PatientDTO;
import com.api.healthelp.model.dto.UserDTO;
import com.api.healthelp.model.entity.Patient;
import com.api.healthelp.model.entity.User;
import com.api.healthelp.service.PatientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.lang.invoke.MethodHandles;

public class PatientControllerImpl implements PatientController {

    @Autowired
    private EntityLinks entityLinks;
    private PatientService patientService;
    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public PatientControllerImpl(PatientService patientService) {
        this.patientService = patientService;
    }

    @Override
    public ResponseEntity<Resources<PatientDTO>> getPatients() throws RuntimeException {
        logger.info(" -- GET  /patients");
        Resources<PatientDTO> resources = new Resources<>(patientService.getPatients());
        resources.add(this.entityLinks.linkToCollectionResource(Patient.class));
        return new ResponseEntity(resources,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PatientDTO> getPatientById(Long id) throws RuntimeException {
        PatientDTO patientDTO = patientService.getPatientById(id);
        return new ResponseEntity(patientDTO,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Resource<PatientDTO>> getPatientByName(String name) throws RuntimeException {
        Resource<PatientDTO> resource = new Resource<>(patientService.getPatientByName(name));
        resource.add(this.entityLinks.linkToCollectionResource(Patient.class));
        return  new ResponseEntity(resource,HttpStatus.OK);
    }
}
