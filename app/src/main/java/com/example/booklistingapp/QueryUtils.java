package com.example.booklistingapp;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class QueryUtils {

    private static String JSON_RESPONSE = "";

    private QueryUtils(){

    }

    public static ArrayList<Book> extractBooks(){

        ArrayList<Book> books = new ArrayList<>();

        try{
            JSONObject root = new JSONObject(JSON_RESPONSE);
            JSONArray items = root.getJSONArray("items");
            for(int i=0;i<items.length();i++){
                JSONObject volumeInfo = items.getJSONObject(i);
                String title = volumeInfo.getString("title");
                String publishedDate = volumeInfo.getString("publishedDate");
                String pageCount = volumeInfo.getString("pageCount");
                String canonicalVolumeLink = volumeInfo.getString("canonicalVolumeLink");
                JSONArray imageLinks = volumeInfo.getJSONArray("imageLinks");
                String thumbnail = imageLinks.getString(1);
                JSONArray authors = volumeInfo.getJSONArray("authors");
                String author = authors.getString(0);
                Book book = new Book(title,pageCount,publishedDate,author,thumbnail,canonicalVolumeLink);
                books.add(book);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return books;

    }

    public static void makeHttpRequest(URL url){

        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        try{

            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setReadTimeout(10000);
            urlConnection.setConnectTimeout(10000);
            urlConnection.connect();

            if(urlConnection.getResponseCode()==200){
                inputStream = urlConnection.getInputStream();
                JSON_RESPONSE = readFromInputStream(inputStream);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static String readFromInputStream(InputStream inputStream){

        StringBuilder sb = new StringBuilder();
        try{

            InputStreamReader inputStreamReader = new InputStreamReader(inputStream,"UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line = bufferedReader.readLine();
            while(line!=null){
                sb.append(line);
                line = bufferedReader.readLine();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return sb.toString();
        
    }


}
