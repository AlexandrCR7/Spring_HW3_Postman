package ru.gb.seminar.example3_HomeTaskSpring_Rest_Point.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.seminar.example3_HomeTaskSpring_Rest_Point.models.User;

@Service
public class UserService {

    @Autowired
    private NotificationService notificationService;

    public User createUser(String name, int age, String email){
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setEmail(email);
        //Отправляем уведомление о регистрации нового пользователя
        notificationService.notifyUser(user);
        return user;
    }
}
