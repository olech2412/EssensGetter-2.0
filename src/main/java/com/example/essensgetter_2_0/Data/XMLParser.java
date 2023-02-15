package com.example.essensgetter_2_0.Data;

import com.example.essensgetter_2_0.JPA.entities.meals.Generic_Meal;
import com.example.essensgetter_2_0.JPA.entities.meals.Meal;
import lombok.extern.log4j.Log4j2;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Log4j2
public class XMLParser {

    private static final String baseUrl = "https://www.studentenwerk-leipzig.de/XMLInterface/request?location=$$";
    public List<Meal> mealList = new ArrayList<>();

    /**
     * Format components that they are separated by ", "
     * Should be equal to OpenMensa format
     *
     * @param groupNode
     * @return
     */
    private static String formatComponents(Element groupNode) {
        NodeList components = groupNode.getElementsByTagName("name1");
        List<Node> componentList = new ArrayList<>();
        for (int i = 1; i < components.getLength(); i++) {
            componentList.add(components.item(i));
        }
        StringBuilder componentsBuilder = new StringBuilder();
        for (int i = 0; i < componentList.size(); i++) {
            componentsBuilder.append(componentList.get(i).getTextContent());
            if (i + 1 != components.getLength()) {
                componentsBuilder.append(", ");
            }
        }

        return componentsBuilder.toString();
    }

    /**
     * Format allergens that they are separated by ", "
     * Should be equal to OpenMensa format
     *
     * @param groupNode
     * @return
     */
    private static HashMap<String, String> formatAdditionalInformation(Element groupNode) {
        NodeList addInfo = groupNode.getElementsByTagName("tagging");
        List<Node> addInfoList = new ArrayList<>();
        for (int i = 0; i < addInfo.getLength(); i++) {
            addInfoList.add(addInfo.item(i));
        }

        HashMap<String, String> addInfoMap = new HashMap<>();
        addInfoMap.put("allergens", "");
        addInfoMap.put("ingredients", "");
        addInfoMap.put("additives", "");

        List<String> allergens = new ArrayList<>();
        for (Node node : addInfoList) {
            if (node.getAttributes().getNamedItem("type") != null && (node.getAttributes().getNamedItem("type")).getTextContent().equals("allergens")) {
                allergens.add(node.getTextContent());
            }
        }
        if (!allergens.isEmpty()){
            StringBuilder allergenBuilder = new StringBuilder();
            for (String allergen: allergens) {
                if(allergens.indexOf(allergen) + 1 != allergens.size()){
                    allergenBuilder.append(allergen + ", ");
                }else{
                    allergenBuilder.append(allergen);
                }
            }
            addInfoMap.put("allergens", allergenBuilder.toString());
        }


        List<String> ingredients = new ArrayList<>();
        for (Node node : addInfoList) {
            if (node.getAttributes().getNamedItem("type") != null && (node.getAttributes().getNamedItem("type")).getTextContent().equals("ingredients")) {
                ingredients.add(node.getTextContent());
            }
        }
        if (!ingredients.isEmpty()){
            StringBuilder ingredientBuilder = new StringBuilder();
            for (String ingredient: ingredients) {
                if(ingredients.indexOf(ingredient) + 1 != ingredients.size()){
                    ingredientBuilder.append(ingredient + ", ");
                }else{
                    ingredientBuilder.append(ingredient);
                }
            }
            addInfoMap.put("ingredients", ingredientBuilder.toString());
        }


        List<String> additives = new ArrayList<>();
        for (Node node : addInfoList) {
            if (node.getAttributes().getNamedItem("type") != null && (node.getAttributes().getNamedItem("type")).getTextContent().equals("additives")) {
                additives.add(node.getTextContent());
            }
        }
        if (!additives.isEmpty()){
            StringBuilder additiveBuilder = new StringBuilder();
            for (String additive: additives) {
                if(additives.indexOf(additive) + 1 != additives.size()){
                    additiveBuilder.append(additive + ", ");
                }else{
                    additiveBuilder.append(additive);
                }
            }
            addInfoMap.put("additives", additiveBuilder.toString());
        }

        return addInfoMap;
    }

    /**
     * Format prices that they are separated by "€ / " and have a comma instead of a dot
     * Should be equal to OpenMensa format
     *
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
            if (i + 1 != prices.getLength()) {
                priceBuilder.append("€ / ");
            } else {
                priceBuilder.append("€");
            }
        }
        return priceBuilder.toString();
    }

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
     *
     * @param groupList
     */
    private void formatGroupToMeals(List<Node> groupList) {
        for (Node groupNode : groupList) {
            Element element = (Element) groupNode;
            Meal meal = new Generic_Meal();
            meal.setCategory(element.getElementsByTagName("name").item(0).getTextContent());
            meal.setPrice(formatPrices(element));
            meal.setAllergens(formatAdditionalInformation(element).get("allergens"));
            meal.setAdditives(formatAdditionalInformation(element).get("additives"));
            meal.setIngredients(formatAdditionalInformation(element).get("ingredients"));
            meal.setComponents(formatComponents(element));
            meal.setServingDate(LocalDate.parse(element.getAttribute("productiondate")));
            meal.setName(((Element) groupNode).getElementsByTagName("name1").item(0).getTextContent());
            log.debug("Meal: " + meal);

            this.mealList.add(meal);
        }
    }

}
