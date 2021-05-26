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
                    "code32",
                    "amy",
                    "anderson",
                    LocalDate.now()
            );

            Patient patient1 = new Patient(
                    "code33",
                    "amy",
                    "anderson",
                    LocalDate.now()
            );

            Study case1 = new Study(
                    "case1",
                    "case description",
                    LocalDateTime.now(),
                    patient);

            Study case2 = new Study(
                    "case2",
                    "Case Description for 2nd",
                    LocalDateTime.now(),
                    patient1);


            studyRepository.saveAll(
                    List.of(case1, case2)
            );
        };
    }
}
