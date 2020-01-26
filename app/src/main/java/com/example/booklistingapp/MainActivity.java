package com.example.booklistingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getName();
    private static EditText edit;
    private static ProgressBar spinner;
    private static ListView listView;
    private static TextView textView;
    private static Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit = (EditText) findViewById(R.id.edit_text);
        spinner = (ProgressBar) findViewById(R.id.spinner);
        listView = (ListView) findViewById(R.id.list);
        textView = (TextView) findViewById(R.id.no_internet);
        button = (Button) findViewById(R.id.search);

        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        boolean isConnected = networkInfo!=null && networkInfo.isConnected();

        if(!isConnected){
            textView.setVisibility(View.VISIBLE);
            edit.setVisibility(View.INVISIBLE);
            button.setVisibility(View.INVISIBLE);
        }else{


            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String query = edit.getText().toString();
                    query.trim().replaceAll("\\s+","");
                    StringBuilder sb = new StringBuilder("https://www.googleapis.com/books/v1/volumes?q=");
                    sb.append(query);
                    sb.append("&maxResults=40");
                    try{
                        URL url = new URL(sb.toString());
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                    listView = (ListView) findViewById(R.id.list);
                    BookAdapter bookAdapter = new BookAdapter(MainActivity.this,new ArrayList<Book>());
                    listView.setAdapter(bookAdapter);

                }
            });


        }

    }
}
