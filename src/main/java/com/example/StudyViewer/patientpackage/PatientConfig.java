package com.example.StudyViewer.patientpackage;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class PatientConfig {

    @Bean
    CommandLineRunner commandLineRunner2(PatientRepository patientRepository){
        return args -> {
            Patient patient1 = new Patient(
                    "code 11112",
                    "Johnny",
                    "Cage",
                    LocalDate.of(2001, Month.JANUARY, 21)
            );

            Patient patient2 = new Patient(
                    "Code sex",
                    "KIara",
                    "Sins",
                    LocalDate.of(2001, Month.APRIL, 4)
            );

            patientRepository.saveAll(List.of(patient1, patient2));
        };
    }
}
