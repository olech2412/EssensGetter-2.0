package com.example.essensgetter_2_0;

import com.example.essensgetter_2_0.Data.DataCaller;
import com.example.essensgetter_2_0.Data.DataFormatter;
import com.example.essensgetter_2_0.JPA.Meal;
import com.example.essensgetter_2_0.JPA.service.MailUserService;
import com.example.essensgetter_2_0.JPA.service.MealService;
import com.example.essensgetter_2_0.email.Mailer;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.mail.MessagingException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
@Log4j2
public class Application {

    public static void main(String[] args) throws IOException, MessagingException {
        ConfigurableApplicationContext configurableApplicationContext= SpringApplication.run(Application.class, args);

        DataCaller dataCaller = new DataCaller();
        DataFormatter dataFormatter = new DataFormatter(dataCaller.callData());

        MealService mealService = configurableApplicationContext.getBean(MealService.class); // get bean from spring context
        MailUserService mailUserService = configurableApplicationContext.getBean(MailUserService.class); // get bean from context

        for(Meal meal : dataFormatter.mealList){
            if(!mealService.findAllMealsByServingDateGreaterThanEqual(LocalDate.now()).contains(meal)){ // if the meal is not in the database
                if(mealService.findAllMealsByServingDate(meal.getServingDate()).isEmpty()) { // if there are no meals in the database with the same serving date
                    for (Meal meal1:dataFormatter.mealList) { // add all meals with the same serving date to the database
                        if(meal1.getServingDate().equals(meal.getServingDate())){
                            mealService.saveMeal(meal1);
                        }
                    }
                }else {
                    for (Meal meals : mealService.findAllMealsByServingDateGreaterThanEqual(LocalDate.now())) {
                        if(meals.getServingDate().equals(meal.getServingDate())){ // if a change in the menu is detected
                            mealService.deleteMeal(meals); // delete all meals from this day (because the menu has changed)
                            //At this point, we dont know if the meal replaces another meal or if it is a new meal.
                            //So we delete all meals with the same serving date and save the new ones
                            log.info("Meal deleted because a change was detected: " + meals);
                        }
                    }
                    for (Meal meal1:dataFormatter.mealList) { // save all meals from this day (the new ones)
                        if (meal1.getServingDate().equals(meal.getServingDate())) {
                            mealService.saveMeal(meal1); // save meal to database
                            // Now we have all new meals in the database
                        }
                    }
                }

            }
        }

        List<Meal> meals = dataFormatter.mealList; //TODO: proof if this is working
        for (Meal meal : meals) {
            if (!mealService.findAllByServingDateBeforeAndName(LocalDate.now(), meal.getName()).isEmpty()) { // if the meal is served today
                List<Meal> meals1 = mealService.findAllByServingDateBeforeAndName(LocalDate.now(), meal.getName()); //TODO: this is not working
                System.out.println(meals1);
            }

        }


        Mailer mailer = new Mailer();
        mailer.sendSpeiseplan(mailUserService.findAllUsersThatAreEnabled(), mealService.findAllMealsByServingDate(LocalDate.now()));
    }


}