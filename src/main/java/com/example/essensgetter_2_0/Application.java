package com.example.essensgetter_2_0;

import com.example.essensgetter_2_0.Data.DataCaller;
import com.example.essensgetter_2_0.Data.DataFormatter;
import com.example.essensgetter_2_0.JPA.entities.MailUser;
import com.example.essensgetter_2_0.JPA.entities.meals.Meal;
import com.example.essensgetter_2_0.JPA.services.MailUserService;
import com.example.essensgetter_2_0.JPA.services.meals.*;
import com.example.essensgetter_2_0.JPA.services.mensen.*;
import com.example.essensgetter_2_0.email.Mailer;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.mail.MessagingException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SpringBootApplication
@Log4j2
public class Application {

    public static void main(String[] args) throws IOException, MessagingException {
        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(Application.class, args);

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

        MailUserService mailUserService = configurableApplicationContext.getBean(MailUserService.class);

        /**
         * Create a HashMap with all MensaServices and MealsServices
         */
        HashMap<Mensa_Service, Meals_Mensa_Service> mensa_meals_serviceHashMap = new HashMap<>();
        mensa_meals_serviceHashMap.put(mensa_schoenauer_strService, meals_mensa_schoenauer_strService);
        mensa_meals_serviceHashMap.put(cafeteria_dittrichringService, meals_cafeteria_dittrichringService);
        mensa_meals_serviceHashMap.put(mensa_academicaService, meals_mensa_academicaService);
        mensa_meals_serviceHashMap.put(mensa_am_elsterbeckenService, meals_mensa_am_elsterbeckenService);
        mensa_meals_serviceHashMap.put(mensa_am_medizincampusService, meals_mensa_am_medizincampusService);
        mensa_meals_serviceHashMap.put(mensa_am_parkService, meals_mensa_am_parkService);
        mensa_meals_serviceHashMap.put(mensa_peterssteinwegService, meals_mensa_peterssteinwegService);
        mensa_meals_serviceHashMap.put(mensa_tierklinikService, meals_mensa_tierklinikService);
        mensa_meals_serviceHashMap.put(menseria_am_botanischen_gartenService, meals_menseria_am_botanischen_gartenServices);

        List<Mensa_Service> mensa_serviceList = new ArrayList<>(); // count all MensaServices into a list
        mensa_serviceList.add(mensa_schoenauer_strService);
        mensa_serviceList.add(cafeteria_dittrichringService);
        mensa_serviceList.add(mensa_academicaService);
        mensa_serviceList.add(mensa_am_elsterbeckenService);
        mensa_serviceList.add(mensa_am_medizincampusService);
        mensa_serviceList.add(mensa_am_parkService);
        mensa_serviceList.add(mensa_peterssteinwegService);
        mensa_serviceList.add(mensa_tierklinikService);
        mensa_serviceList.add(menseria_am_botanischen_gartenService);

        for (Mensa_Service mensa_service : mensa_serviceList) {
            DataCaller dataCaller = new DataCaller(mensa_service.getMensa().getApiUrl());
            DataFormatter dataFormatter = new DataFormatter(dataCaller.callData());
            checkTheData(dataFormatter.mealList, mensa_service, mensa_meals_serviceHashMap);
        }


        Mailer mailer = new Mailer();
        mailer.sendSpeiseplan(mailUserService.findAllUsersThatAreEnabled(), meals_mensa_schoenauer_strService.findAllMealsByServingDate(LocalDate.now()));

    }

    private static void checkTheData(List<Meal> data, Mensa_Service mensa_service, HashMap<Mensa_Service, Meals_Mensa_Service> mensa_meals_serviceHashMap) {
        Meals_Mensa_Service meals_mensa_service = mensa_meals_serviceHashMap.get(mensa_service);
        for (Meal meal : data) {
            if (!meals_mensa_service.findAllMealsByServingDateGreaterThanEqual(LocalDate.now()).contains(meal)) { // if the meal is not in the database
                if (meals_mensa_service.findAllMealsByServingDate(meal.getServingDate()).isEmpty()) { // if there are no meals in the database with the same serving date
                    for (Meal meal1 : data) { // add all meals with the same serving date to the database
                        if (meal1.getServingDate().equals(meal.getServingDate())) {
                            meals_mensa_service.save(meal1, mensa_service.getMensa());
                        }
                    }
                } else {
                    for (Meal meals : meals_mensa_service.findAllMealsByServingDateGreaterThanEqual(LocalDate.now())) {
                        if (meals.getServingDate().equals(meal.getServingDate())) { // if a change in the menu is detected
                            meals_mensa_service.delete(meals, mensa_service.getMensa()); // delete all meals from this day (because the menu has changed)
                            //At this point, we dont know if the meal replaces another meal or if it is a new meal.
                            //So we delete all meals with the same serving date and save the new ones
                            log.info("Meal deleted because a change was detected: " + meals);
                        }
                    }
                    for (Meal meal1 : data) { // save all meals from this day (the new ones)
                        if (meal1.getServingDate().equals(meal.getServingDate())) {
                            meals_mensa_service.save(meal1, mensa_service.getMensa()); // save meal to database
                            // Now we have all new meals in the database
                        }
                    }
                }

            }
        }
    }


}