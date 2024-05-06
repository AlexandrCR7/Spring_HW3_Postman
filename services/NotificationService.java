package ru.gb.seminar.example3_HomeTaskSpring_Rest_Point.services;

import org.springframework.stereotype.Service;
import ru.gb.seminar.example3_HomeTaskSpring_Rest_Point.models.User;

@Service
public class NotificationService {

    public void notifyUser(User user) {
        System.out.println("User has been created " + user.getName());
    }

    public void sendNotification(String s){
        System.out.println(s);
    }
}
