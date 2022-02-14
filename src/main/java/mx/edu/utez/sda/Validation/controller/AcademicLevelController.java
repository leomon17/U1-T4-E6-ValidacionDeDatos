package mx.edu.utez.sda.Validation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.edu.utez.sda.Validation.entity.AcademicLevel;
import mx.edu.utez.sda.Validation.service.AcademicLevelService;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping(path = "/academic-level")
public class AcademicLevelController {
    
    @Autowired
    private AcademicLevelService academicLevelService;

    @GetMapping(value="")
    @Transactional(readOnly = true)
    public List<AcademicLevel> getAllAcademicLevels(){
        return academicLevelService.getAll();
    }
    
}
