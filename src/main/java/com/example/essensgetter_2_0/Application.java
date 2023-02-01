package com.example.essensgetter_2_0;

import com.example.essensgetter_2_0.Data.DataCaller;
import com.example.essensgetter_2_0.Data.DataFormatter;
import com.example.essensgetter_2_0.JPA.entities.meals.Meals_Cafeteria_Dittrichring;
import com.example.essensgetter_2_0.JPA.services.meals.*;
import com.example.essensgetter_2_0.JPA.services.mensen.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.mail.MessagingException;
import java.io.IOException;

@SpringBootApplication
@Log4j2
public class Application {

    public static void main(String[] args) throws IOException, MessagingException {
        ConfigurableApplicationContext configurableApplicationContext= SpringApplication.run(Application.class, args);

        /**
         * Get all Spring components
         */
        Meals_Mensa_Schoenauer_StrService meals_mensa_schoenauer_strService = configurableApplicationContext.getBean(Meals_Mensa_Schoenauer_StrService.class);
        Meals_Cafeteria_DittrichringService meals_cafeteria_dittrichringService = configurableApplicationContext.getBean(Meals_Cafeteria_DittrichringService.class);
        Meals_Mensa_AcademicaService meals_mensa_academicaService = configurableApplicationContext.getBean(Meals_Mensa_AcademicaService.class);
        Meals_Mensa_am_ElsterbeckenService meals_mensa_am_elsterbeckenService = configurableApplicationContext.getBean(Meals_Mensa_am_ElsterbeckenService.class);
        Meals_Mensa_am_MedizincampusService meals_mensa_am_medizincampusService = configurableApplicationContext.getBean(Meals_Mensa_am_MedizincampusService.class);
        Meals_Mensa_am_ParkService meals_mensa_am_parkService = configurableApplicationContext.getBean(Meals_Mensa_am_ParkService.class);
        Meals_Mensa_PeterssteinwegService meals_mensa_peterssteinwegService = configurableApplicationContext.getBean(Meals_Mensa_PeterssteinwegService.class);
        Meals_Mensa_TierklinikService meals_mensa_tierklinikService = configurableApplicationContext.getBean(Meals_Mensa_TierklinikService.class);
        Meals_Menseria_am_Botanischen_GartenServices meals_menseria_am_botanischen_gartenServices = configurableApplicationContext.getBean(Meals_Menseria_am_Botanischen_GartenServices.class);

        Mensa_Schoenauer_StrService mensa_schoenauer_strService = configurableApplicationContext.getBean(Mensa_Schoenauer_StrService.class);
        Cafeteria_DittrichringService cafeteria_dittrichringService = configurableApplicationContext.getBean(Cafeteria_DittrichringService.class);
        Mensa_AcademicaService mensa_academicaService = configurableApplicationContext.getBean(Mensa_AcademicaService.class);
        Mensa_am_ElsterbeckenService mensa_am_elsterbeckenService = configurableApplicationContext.getBean(Mensa_am_ElsterbeckenService.class);
        Mensa_am_MedizincampusService mensa_am_medizincampusService = configurableApplicationContext.getBean(Mensa_am_MedizincampusService.class);
        Mensa_am_ParkService mensa_am_parkService = configurableApplicationContext.getBean(Mensa_am_ParkService.class);
        Mensa_PeterssteinwegService mensa_peterssteinwegService = configurableApplicationContext.getBean(Mensa_PeterssteinwegService.class);
        Mensa_TierklinikService mensa_tierklinikService = configurableApplicationContext.getBean(Mensa_TierklinikService.class);
        Menseria_am_Botanischen_GartenService menseria_am_botanischen_gartenService = configurableApplicationContext.getBean(Menseria_am_Botanischen_GartenService.class);









        DataCaller dataCaller = new DataCaller();
        DataFormatter dataFormatter = new DataFormatter(dataCaller.callData());



        /**
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


        Mailer mailer = new Mailer();
        mailer.sendSpeiseplan(mailUserService.findAllUsersThatAreEnabled(), mealService.findAllMealsByServingDate(LocalDate.now()));
         */
    }


}