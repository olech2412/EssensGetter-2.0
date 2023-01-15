package com.example.essensgetter_2_0.Data;

import com.example.essensgetter_2_0.JPA.Meal;
import com.example.essensgetter_2_0.JPA.service.MealService;
import lombok.extern.log4j.Log4j2;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Log4j2
public class DataFormatter {

    public List<Meal> mealList = new ArrayList<>();

    @Autowired
    MealService mealService;

    public DataFormatter(Object jsonArray) {
        try {
            formatData((JSONArray) jsonArray);
        }catch (ClassCastException classCastException){
            log.error("Error while casting data: " + classCastException);
        }
    }

    /**
     * Formats the data from the API to a Meal object
     */
    private void formatData(JSONArray jsonArray) {
        for (int i = 0; i < jsonArray.length(); i++) {
            Meal dataMeal = new Meal();
            JSONObject meal = jsonArray.getJSONObject(i);
            String name = meal.getString("name");
            String description = formatNotes(meal.getJSONArray("notes"));
            String price = formatPrices(meal.getJSONObject("prices"));
            String category = meal.getString("category");

            dataMeal.setName(name);
            dataMeal.setDescription(description);
            dataMeal.setPrice(price);
            dataMeal.setCategory(category);
            dataMeal.setCreationDate(LocalDate.now());
            dataMeal.setResponseCode(200);

            log.info(dataMeal.toString());
            mealList.add(dataMeal);
        }
    }

    /**
     * Formats the prices from the API to a String
     * @return String
     */
    private String formatPrices(JSONObject prices) {
        BigDecimal priceStudents = (BigDecimal) prices.get("students"); // Price for students
        BigDecimal priceEmployees = (BigDecimal) prices.get("employees"); // Price for employees
        BigDecimal priceOthers = (BigDecimal) prices.get("others"); // Price for others

        return priceStudents + "€/ " + priceEmployees + "€/ " + priceOthers + "€";
    }

    /**
     * Formats the notes from the API to a String
     * @return String
     */
    private String formatNotes(JSONArray notes) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < notes.length(); i++) {
            stringBuilder.append(notes.getString(i));
            if(i+1 < notes.length()){
                stringBuilder.append(", ");
            }
        }
        return stringBuilder.toString();
    }

}
