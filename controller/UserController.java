package ru.gb.seminar.example3_HomeTaskSpring_Rest_Point.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.gb.seminar.example3_HomeTaskSpring_Rest_Point.models.User;
import ru.gb.seminar.example3_HomeTaskSpring_Rest_Point.services.RegistrationService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private RegistrationService service;

    @GetMapping
    public List<User> userList(){
        return service.getDataProcessingService().getRepository().getUsers();
    }

    @PostMapping("/body")
    public String userAddFromBody(@RequestBody User user){
        service.getDataProcessingService().getRepository().getUsers().add(user);
        return "User added from body!";
    }

    @PostMapping("/reg")
    public String userRegistration(@RequestBody User user){
        service.processRegistration(user.getName(), user.getAge(), user.getEmail());
        return "User added from body and registered!";
    }
}
