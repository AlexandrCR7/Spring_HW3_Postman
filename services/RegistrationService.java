package ru.gb.seminar.example3_HomeTaskSpring_Rest_Point.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.seminar.example3_HomeTaskSpring_Rest_Point.repository.UserRepository;

@Service
public class RegistrationService {
    @Autowired
    private DataProcessingService dataProcessingService;
    @Autowired
    private UserService userService;
    @Autowired
    private NotificationService notificationService;

    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }

    /**
     * HomeTask - добавить поля:
     * UserService & NotificationService
     * добавит метод - processRegistration
     */

    //    2) Разработать метод processRegistration в котором:
    //- создается пользователь из параметров метода
    //- созданный пользователь добавляется в репозиторий
    //- через notificationService выводится сообщение в консоль
    public void processRegistration(String name, int age, String email){
        dataProcessingService.addUserToList(userService.createUser(name, age, email));
        notificationService.sendNotification("New user has been registered!");
    }
}
