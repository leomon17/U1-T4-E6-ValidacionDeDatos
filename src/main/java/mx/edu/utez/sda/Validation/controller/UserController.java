package mx.edu.utez.sda.Validation.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mx.edu.utez.sda.Validation.entity.User;
import mx.edu.utez.sda.Validation.service.UserService;

@RestController
@RequestMapping(path = "/user")
public class UserController {
    
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/verify", method = { RequestMethod.GET, RequestMethod.POST })
    public User verificarUsuario(@RequestBody User user){
        String username = user.getUserName();
        String password = user.getPassword();
        try {
            return userService.verificarUsuario(username, password);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
