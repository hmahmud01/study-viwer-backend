package com.example.StudyViewer.patientpackage;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> getPatient(){
        return patientRepository.findAll();
    }

    public void addPatient(Patient patient) {
        patientRepository.save(patient);
    }

    public void deletePatient(Long patientId) {
        boolean exists = patientRepository.existsById(patientId);
        if (!exists){
            throw new IllegalStateException(
                    "Id with " + patientId + " doesn not exist."
            );
        }
        patientRepository.deleteById(patientId);
    }
}
