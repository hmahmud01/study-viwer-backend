package com.example.StudyViewer.patientpackage;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Patient {

    @Id
    @SequenceGenerator(
            name = "patient_sequence",
            sequenceName = "patient_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "patient_sequence"
    )
    private Long id;
    @Column(unique=true)
    private String personCode;
    private String firstName;
    private String lastName;
    private LocalDate dob;

    public Patient() {
    }

    public Patient(Long id, String personCode, String firstName, String lastName, LocalDate dob) {
        this.id = id;
        this.personCode = personCode;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
    }

    public Patient(String personCode, String firstName, String lastName, LocalDate dob) {
        this.personCode = personCode;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPersonCode() {
        return personCode;
    }

    public void setPersonCode(String personCode) {
        this.personCode = personCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", personCode='" + personCode + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dob=" + dob +
                '}';
    }
}
