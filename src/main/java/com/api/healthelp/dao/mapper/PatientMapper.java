package com.api.healthelp.dao.mapper;

import com.api.healthelp.model.dto.PatientDTO;
import com.api.healthelp.model.dto.PatientListDTO;
import com.api.healthelp.model.entity.Patient;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PatientMapper {
    List<PatientDTO> getPatients();
    PatientDTO getPatientById(@Param("patientId")Integer id);
    List<PatientDTO> getPatientsByName(@Param("patientName")String patientName,@Param("userId")Integer userId);
    void insertPatient(@Param("id") Integer id, @Param("userId") Integer userId,@Param("tenantId") Integer tenantId,
                          @Param("patientName") String patientName,@Param("patientLastName") String patientLastName,
                          @Param("patientDNI") String patientDNI, @Param("patientTelephone") String patientTelephone,
                          @Param("patientAddress") String patientAddress, @Param("patientLocation") String patientLocation,
                          @Param("patientProfession") String patientProfession, @Param("patientEmail") String patientEmail);
    void updatePatient(@Param("id") Integer id, @Param("userId") Integer userId,@Param("tenantId") Integer tenantId,
                       @Param("patientName") String patientName,@Param("patientLastName") String patientLastName,
                       @Param("patientDni") String patientDni, @Param("patientTelephone") String patientTelephone,
                       @Param("patientAddress") String patientAddress, @Param("patientLocation") String patientLocation,
                       @Param("patientProfession") String patientProfession, @Param("patientEmail") String patientEmail);
}
