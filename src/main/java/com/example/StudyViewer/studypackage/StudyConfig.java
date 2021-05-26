package com.example.StudyViewer.studypackage;

import com.example.StudyViewer.patientpackage.Patient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Configuration
public class StudyConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudyRepository studyRepository){
        return args -> {
            Patient patient = new Patient(
                    "PC01",
                    "PersonFirst",
                    "PersonLast",
                    LocalDate.now()
            );

            Patient patient1 = new Patient(
                    "PC02",
                    "AnonymousFirst",
                    "AnonymousLast",
                    LocalDate.now()
            );

            Study case1 = new Study(
                    "DX",
                    "Bilateral Hip J.",
                    LocalDateTime.now(),
                    patient);

            Study case2 = new Study(
                    "MR",
                    "CEREBRAL",
                    LocalDateTime.now(),
                    patient1);


            studyRepository.saveAll(
                    List.of(case1, case2)
            );
        };
    }
}
