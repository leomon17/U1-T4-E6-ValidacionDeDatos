package mx.edu.utez.sda.Validation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.edu.utez.sda.Validation.entity.State;
import mx.edu.utez.sda.Validation.repository.IStateRepository;

@Service
public class StateService {
    
    @Autowired
    private IStateRepository stateRepository;

    public List<State>getAll(){
        return stateRepository.findAll();
    }
}
