package com.example.StudyViewer.patientpackage;

import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin()
@RestController
@RequestMapping(path = "api/patient")
public class PatientController {

    private PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public List<Patient> getPatient(){
        return patientService.getPatient();
    }

    @PostMapping
    public void addNewPatient(@RequestBody Patient patient){
        patientService.addPatient(patient);
    }

    @DeleteMapping(path = "{patientId}")
    public void deletePatient(@PathVariable Long patientId){
        patientService.deletePatient(patientId);
    }

}
