package mx.edu.utez.sda.Validation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.edu.utez.sda.Validation.entity.Municipality;
import mx.edu.utez.sda.Validation.repository.IMunicipalityRepository;

@Service
public class MunicipalityService {
    
    @Autowired
    private IMunicipalityRepository municipalityRepository;

    public List<Municipality> getAll(){
        return municipalityRepository.findAll();
    }
}
