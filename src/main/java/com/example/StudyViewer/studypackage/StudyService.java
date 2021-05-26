package com.example.StudyViewer.studypackage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
public class StudyService {

    private final StudyRepository studyRepository;

    @Autowired
    public StudyService(StudyRepository studyRepository) {
        this.studyRepository = studyRepository;
    }

    public List<Study> getStudy() {
        return studyRepository.findAll();
    }

    public void addStudy(Study study) {
        System.out.println(study);
        System.out.println(study.getPatient());
        studyRepository.save(study);
    }

    public void deleteStudy(Long studyId) {
        boolean exists = studyRepository.existsById(studyId);
        if (!exists) {
            throw new IllegalStateException(
                    "Study with id" + studyId + " does not exist."
            );
        }
        studyRepository.deleteById(studyId);
    }

    @Transactional
    public void updateStudy(Long studyId, String name, String description) {
        Study study = studyRepository.findById(studyId)
                .orElseThrow(() -> new IllegalStateException(
                        "Study with id " + studyId + "does not exist"
                ));

        if(name != null && name.length() > 0 && !Objects.equals(study.getName(), name)) {
            study.setName(name);
        }

        if(description != null && description.length() >0 && !Objects.equals(study.getDescription(), description)) {
            study.setDescription(description);
        }
        study.setCreatedAt(LocalDateTime.now());
    }
}
