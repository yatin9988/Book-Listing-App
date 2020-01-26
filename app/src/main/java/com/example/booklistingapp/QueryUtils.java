package com.example.booklistingapp;

import org.json.JSONArray;
import org.json.JSONObject;

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

}
