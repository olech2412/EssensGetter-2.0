package com.example.essensgetter_2_0;

import com.example.essensgetter_2_0.Data.DataCaller;
import com.example.essensgetter_2_0.Data.DataFormatter;
import com.example.essensgetter_2_0.JPA.authentification.Users;
import com.example.essensgetter_2_0.JPA.repository.MealRepository;
import com.example.essensgetter_2_0.JPA.service.MealService;
import com.example.essensgetter_2_0.JPA.service.UsersService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.io.IOException;

@SpringBootApplication
public class Application {

    public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext configurableApplicationContext= SpringApplication.run(Application.class, args);

        DataCaller dataCaller = new DataCaller();
        DataFormatter dataFormatter = new DataFormatter(dataCaller.callData());

        MealService mealService = configurableApplicationContext.getBean(MealService.class); // get bean from context
        mealService.saveAllMeals(dataFormatter.mealList);

        UsersService usersService = configurableApplicationContext.getBean(UsersService.class); // get bean from context
        usersService.findAllUsersThatAreEnabled();
    }


}
