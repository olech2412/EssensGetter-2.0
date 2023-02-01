package com.example.essensgetter_2_0.Data;

import lombok.extern.log4j.Log4j2;
import org.json.JSONArray;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;

@Log4j2
public class DataCaller {

    private static String url = ""; // URL to the API 69 is the ID of the canteen

    public DataCaller() {
    }

    /**
     * Calls the API and returns the data as a JSONObject
     * @return jsonObject
     * @throws IOException
     */
    public Object callData() throws IOException {
        URL url = new URL(this.url);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setDoOutput(true);

        con.setConnectTimeout(10000); // Timeout for connecting and reading 10 seconds
        con.setReadTimeout(10000);

        JSONArray jsonArray = null;

        if(con.getResponseCode() == 200){
            log.info("Connection to API successful");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            jsonArray = new JSONArray(content.toString());
        }else{
            log.error("Connection to API failed with response code: " + con.getResponseCode());
        }

        return jsonArray;
    }

    public static String getUrl() {
        return url;
    }

    public static void setUrl(String url) {
        DataCaller.url = url;
    }
}