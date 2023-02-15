package com.example.essensgetter_2_0.Data;

import com.example.essensgetter_2_0.JPA.entities.meals.Generic_Meal;
import com.example.essensgetter_2_0.JPA.entities.meals.Meal;
import lombok.extern.log4j.Log4j2;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Log4j2
public class XMLParser {

    private static final String baseUrl = "https://www.studentenwerk-leipzig.de/XMLInterface/request?location=$$";
    public static List<Meal> mealList = new ArrayList<>();


    public void parse(String canteenCode) throws ParserConfigurationException, IOException, SAXException {
        log.debug("Parsing XML file for canteen: " + canteenCode);
        URL xmlURL = new URL(baseUrl.replace("$$", canteenCode));
        InputStream xml = xmlURL.openStream();
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(xml);
        doc.getDocumentElement().normalize();
        NodeList groupNodes = doc.getElementsByTagName("group");
        List<Node> groupList = new ArrayList<>();
        for (int i = 0; i < groupNodes.getLength(); i++) {
            groupList.add(groupNodes.item(i));
        }
        xml.close();
        formatGroupToMeals(groupList);
    }

    /**
     * Format XML data to meals
     * @param groupList
     */
    private static void formatGroupToMeals(List<Node> groupList) {
        for (Node groupNode : groupList) {
            Element element = (Element) groupNode;
            Meal meal = new Generic_Meal();
            meal.setCategory(element.getElementsByTagName("name").item(0).getTextContent());
            meal.setPrice(formatPrices(element));
            meal.setAllergens(formatAllergens(element));
            meal.setComponents(formatComponents(element));
            meal.setServingDate(LocalDate.parse(element.getAttribute("productiondate")));
            meal.setName(((Element) groupNode).getElementsByTagName("name1").item(0).getTextContent());
            log.debug("Meal: " + meal.toString());

            mealList.add(meal);
        }
    }

    /**
     * Format components that they are separated by ", "
     * Should be equal to OpenMensa format
     * @param groupNode
     * @return
     */
    private static String formatComponents(Element groupNode) {
        NodeList components = groupNode.getElementsByTagName("name1");
        List<Node> componentList = new ArrayList<>();
        for(int i =1; i < components.getLength(); i++){
            componentList.add(components.item(i));
        }
        StringBuilder componentsBuilder = new StringBuilder();
        for (int i = 0; i < componentList.size(); i++){
            componentsBuilder.append(componentList.get(i).getTextContent());
            if(i +1 != components.getLength()){
                componentsBuilder.append(", ");
            }
        }

        return componentsBuilder.toString();
    }

    /**
     * Format allergens that they are separated by ", "
     * Should be equal to OpenMensa format
     * @param groupNode
     * @return
     */
    private static String formatAllergens(Element groupNode) {
        NodeList allergens = groupNode.getElementsByTagName("tagging");
        List<Node> allergensList = new ArrayList<>();
        for(int i =0; i < allergens.getLength(); i++){
            allergensList.add(allergens.item(i));
        }
        StringBuilder allergensBuilder = new StringBuilder();
        for (int i = 0; i < allergensList.size(); i++){
            allergensBuilder.append(allergensList.get(i).getTextContent());
            if(i +1 != allergens.getLength()){
                allergensBuilder.append(", ");
            }
        }

        return allergensBuilder.toString();
    }

    /**
     * Format prices that they are separated by "€ / " and have a comma instead of a dot
     * Should be equal to OpenMensa format
     * @param groupNode
     * @return
     */
    private static String formatPrices(Element groupNode) {
        NodeList prices = groupNode.getElementsByTagName("price");
        List<Node> priceList = new ArrayList<>();
        for (int i = 0; i < prices.getLength(); i++) {
            priceList.add(prices.item(i));
        }
        StringBuilder priceBuilder = new StringBuilder();
        for (int i = 0; i < priceList.size(); i++) {
            String priceWithComma = priceList.get(i).getTextContent().replaceAll("\\.", ",");
            priceBuilder.append(priceWithComma);
            if (i + 1 != prices.getLength()){
                priceBuilder.append("€ / ");
            }else {
                priceBuilder.append("€");
            }
        }
        return priceBuilder.toString();
    }

}
