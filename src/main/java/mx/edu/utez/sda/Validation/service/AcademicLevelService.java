package mx.edu.utez.sda.Validation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.edu.utez.sda.Validation.entity.AcademicLevel;
import mx.edu.utez.sda.Validation.repository.IAcademicLevelRepository;

@Service
public class AcademicLevelService {
    
    @Autowired
    private IAcademicLevelRepository academicLevelRepository;

    public List<AcademicLevel> getAll(){
        return academicLevelRepository.findAll();
    }
}
