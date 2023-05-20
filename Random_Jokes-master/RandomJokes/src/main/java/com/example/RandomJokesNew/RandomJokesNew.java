package com.example.RandomJokesNew;

import lombok.SneakyThrows;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RandomJokesNew {
    @SneakyThrows
    public static void main(String[] args) {
        URL getURl = new URL("https://api.chucknorris.io/jokes/random");
        HttpURLConnection connection = (HttpURLConnection) getURl.openConnection();
        connection.setRequestMethod("GET");
        int responseCode = connection.getResponseCode();

        if(responseCode == 200){
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuffer jsonResponseData = new StringBuffer();
            String readLine = null;

            //Append response line by line
            while((readLine = br.readLine())!= null){
                jsonResponseData.append(readLine);
            }
            br.close();
            JSONObject masterData = new JSONObject(jsonResponseData.toString());
            System.out.println("Joke is --> "+masterData.get("value"));
        }else{
            System.out.println(responseCode);
        }
    }
}
