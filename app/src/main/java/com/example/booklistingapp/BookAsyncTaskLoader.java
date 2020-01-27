package com.example.booklistingapp;

import android.app.Activity;

import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

import java.util.ArrayList;

public class BookAsyncTaskLoader extends AsyncTaskLoader<ArrayList<Book>> {

    // constructor
    public BookAsyncTaskLoader(Activity activity){
        super(activity);
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Nullable
    @Override
    public ArrayList<Book> loadInBackground() {
        ArrayList<Book> books = new ArrayList<>();
        QueryUtils.makeHttpRequest(MainActivity.url);
        return QueryUtils.extractBooks();
    }
}
