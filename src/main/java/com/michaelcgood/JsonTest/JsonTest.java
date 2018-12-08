package com.michaelcgood.JsonTest;

import org.json.simple.JSONObject;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class JsonTest {

    public static void main(String[] args) {

        JsonTest jsonTest = new JsonTest();
        jsonTest.jsonTest();

    }

   void jsonTest(){

        try {
            URL url = new URL("http://localhost:8080/login/findUsers");
            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("Accept","application/json");

            if (httpURLConnection.getResponseCode()!=200){

                throw new RuntimeException("HTTP error code:"+httpURLConnection.getResponseCode());
            }

            Scanner scanner = new Scanner(url.openStream());
            String entireResponse = new String();

            while (scanner.hasNext())
                entireResponse +=scanner.nextLine();

            System.out.println("Response"+ entireResponse);

            scanner.close();

            JSONObject object = new JSONObject();


        }catch (Exception e){

        }

    }
}
