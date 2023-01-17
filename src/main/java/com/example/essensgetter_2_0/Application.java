package com.example.essensgetter_2_0;

import com.example.essensgetter_2_0.Data.DataCaller;
import com.example.essensgetter_2_0.Data.DataFormatter;
import com.example.essensgetter_2_0.JPA.service.MailUserService;
import com.example.essensgetter_2_0.JPA.service.MealService;
import com.example.essensgetter_2_0.email.Mailer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.mail.MessagingException;
import java.io.IOException;

@SpringBootApplication
public class Application {

    public static void main(String[] args) throws IOException, MessagingException {
        ConfigurableApplicationContext configurableApplicationContext= SpringApplication.run(Application.class, args);

        DataCaller dataCaller = new DataCaller();
        DataFormatter dataFormatter = new DataFormatter(dataCaller.callData());

        MealService mealService = configurableApplicationContext.getBean(MealService.class); // get bean from context
        mealService.saveAllMeals(dataFormatter.mealList);

        MailUserService mailUserService = configurableApplicationContext.getBean(MailUserService.class); // get bean from context
        Mailer mailer = new Mailer();
        mailer.sendSpeiseplan(mailUserService.findAllUsersThatAreEnabled(), dataFormatter.mealList);
    }


}
