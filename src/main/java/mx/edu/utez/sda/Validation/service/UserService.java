package mx.edu.utez.sda.Validation.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.edu.utez.sda.Validation.entity.User;
import mx.edu.utez.sda.Validation.repository.IUserRepository;

@Service
public class UserService implements Serializable {
    
    @Autowired
    private IUserRepository userRepository;

    public User verificarUsuario(String username, String password){
        return userRepository.verificarUsuario(username, password);
    }
}
