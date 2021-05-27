package com.example.StudyViewer.studypackage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin()
@RestController
@RequestMapping(path = "api/study")
public class StudyController {

    private final StudyService studyService;

    @Autowired
    public StudyController(StudyService studyService) {
        this.studyService = studyService;
    }

    @GetMapping
    public List<Study> getStudy() {
        return studyService.getStudy();
    }

    @PostMapping
    public void addNewStudy(@RequestBody Study study){
        studyService.addStudy(study);
    }

    @DeleteMapping(path = "{studyId}")
    public void deleteStudy(@PathVariable("studyId") Long studyId){
        studyService.deleteStudy(studyId);
    }

    @PutMapping(path = "{studyId}")
    public void updateStudy(
            @PathVariable("studyId") Long studyId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String description
    ){
        studyService.updateStudy(studyId, name, description);
    }
}
