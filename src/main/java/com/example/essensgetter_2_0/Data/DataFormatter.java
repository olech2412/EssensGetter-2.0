package com.example.essensgetter_2_0.Data;

import com.example.essensgetter_2_0.JPA.entities.meals.Generic_Meal;
import com.example.essensgetter_2_0.JPA.entities.meals.Meal;
import lombok.extern.log4j.Log4j2;
import org.json.JSONArray;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Log4j2
public class DataFormatter {

    public List<Meal> mealList = new ArrayList<>();

    //@Autowired
    //MealService mealService;

    public DataFormatter(Object jsonArray) {
        try {
            formatData((JSONArray) jsonArray);
        } catch (ClassCastException classCastException) {
            log.error("Error while casting data: " + classCastException);
        }
    }

    /**
     * Formats the data from the API to a Meal object
     */
    private void formatData(JSONArray jsonArray) {
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject menu = jsonArray.getJSONObject(i);
            JSONArray meals = menu.getJSONArray("meals");
            for (int t = 0; t < meals.length(); t++) {
                Meal dataMeal = new Generic_Meal();
                JSONObject meal = meals.getJSONObject(t);
                dataMeal.setName(meal.getString("name"));
                dataMeal.setPrice(formatPrices(meal.getJSONObject("prices")));
                dataMeal.setCategory(meal.getString("category"));
                dataMeal.setDescription(formatNotes(meal.getJSONArray("notes")));
                dataMeal.setServingDate(LocalDate.parse(menu.getString("date")));
                dataMeal.setResponseCode(200);
                mealList.add(dataMeal);
                log.info("Meal added to list: " + dataMeal);
            }
        }
    }

    /**
     * Formats the prices from the API to a String
     *
     * @return String
     */
    private String formatPrices(JSONObject prices) {
        BigDecimal priceStudents = (BigDecimal) prices.get("students"); // Price for students
        BigDecimal priceEmployees = (BigDecimal) prices.get("employees"); // Price for employees
        BigDecimal priceOthers = (BigDecimal) prices.get("others"); // Price for others

        String priceUnformatted = priceStudents + "€/ " + priceEmployees + "€/ " + priceOthers + "€"; // Can be "2.5€/ 3.59€/ 4.5€" should be "2.50€/ 3.59€/ 4.50€"

        String[] priceArr = priceUnformatted.split("/"); // Splits the String at "/"
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < priceArr.length; i++) { // Iterates through the array
            double price = Double.parseDouble(priceArr[i].replaceAll("€", "")); // Removes "€" and parses the String to a double
            sb.append(String.format("%.2f", price)); // Formats the double to 2 decimal places
            if (i < priceArr.length - 1) { // Checks if the current index is the last index
                sb.append("€/ "); // Adds "€/ " to the StringBuilder
            } else {
                sb.append("€"); // Adds "€" to the StringBuilder
            }
        }
        return sb.toString().replace(".", ","); // Removes the spaces


    }

    /**
     * Formats the notes from the API to a String
     *
     * @return String
     */
    private String formatNotes(JSONArray notes) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < notes.length(); i++) {
            stringBuilder.append(notes.getString(i));
            if (i + 1 < notes.length()) {
                stringBuilder.append(", ");
            }
        }
        return stringBuilder.toString();
    }

}
