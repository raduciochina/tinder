package com.example.tinder;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class JSONReader {
    public void read(String urlPath, IResponse response){
        try
        {
            URL url = new URL(urlPath);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = connection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            StringBuilder result = new StringBuilder();
            String line = "";

            while((line = bufferedReader.readLine()) != null){
                result.append(line);
            }

            Log.v("rezultat", result.toString());

            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();

            List<Abonament> lst = parsare(result.toString());

            response.onSuccess(lst);

        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
            response.onError(e.getMessage());
        }
        catch (IOException e) {
            e.printStackTrace();
            response.onError(e.getMessage());
        }

    }

    private List<Abonament> parsare(String jsonString){

        List<Abonament> lst = new ArrayList<>();

        try
        {
            JSONObject jsonObject = new JSONObject(jsonString);
            JSONArray jsonArray = jsonObject.getJSONArray("abonamente"); //cheia

            for(int i = 0; i <= jsonArray.length(); i++){
                JSONObject currentObject = jsonArray.getJSONObject(i);

                String nume = currentObject.getString("nume");
                int pret = currentObject.getInt("pret");
                String descriere = currentObject.getString("descriere");

                Abonament abonament = new Abonament(nume,pret,descriere);

                lst.add(abonament);
            }
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }

        return lst;
    }

}
