package ru.gb.seminar.example3_HomeTaskSpring_Rest_Point.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.seminar.example3_HomeTaskSpring_Rest_Point.models.User;
import ru.gb.seminar.example3_HomeTaskSpring_Rest_Point.services.DataProcessingService;

import java.util.ArrayList;
import java.util.List;

@RestController("/tasks")
public class TaskController {

    @Autowired
    private DataProcessingService service;

    @GetMapping
    public List<String> getAllTasks(){
        List<String> tasks = new ArrayList<>();
        tasks.add("sort");
        tasks.add("filter");
        tasks.add("calc");
        return tasks;
    }

    @GetMapping("/sort")//localhost:8080/users/sort
    public List<User> sortUserByAge(){
        return service.sortUserByAge(service.getRepository().getUsers());
    }


    //    3) В TaskController добавить обработчики filterUsersByAge()
    //    (Подсказка @GetMapping("/filter/{age}")) и calculateAverageAge (Подсказка @GetMapping("/calc"))
    //    4) В методе filterUsersByAge параметр age получать через аннотацию @PathVariable
    /**
     * HomeTask:
     * метод filterUserByAge
     * подсказка @GetMapping("/filter/{age}")
     *
     * метод calculateAverageAge
     * подсказка @GetMapping("/calc")
     *
     */

    @GetMapping("/filter/{age}")
    public List<User> filterUsersByAge(@PathVariable int age){
        return service.filterUserByAge(service.getRepository().getUsers(), age);
    }

    @GetMapping("/calc")
    public double calculateAverageAge(){
        return service.calculateAverageAge(service.getRepository().getUsers());
    }
}
