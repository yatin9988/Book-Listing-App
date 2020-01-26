package com.example.booklistingapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class BookAdapter extends ArrayAdapter<Book> {

    public BookAdapter(Context context, ArrayList<Book> books){
        super(context,0,books);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;
        if(view == null){

            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_item,parent,false);

        }

        TextView title = (TextView) view.findViewById(R.id.title);
        TextView author = (TextView) view.findViewById(R.id.author);

        TextView published = (TextView) view.findViewById(R.id.published);
        TextView pages = (TextView) view.findViewById(R.id.pages);

        Book book = getItem(position);
        title.setText(book.getTitle());
        published.setText(book.getPublishedDate());
        pages.setText(book.getPageCount());

        StringBuilder sb = new StringBuilder();
        String []authors = book.getAuthors();
        if(authors.length == 1)
            author.setText(authors[0]);
        else {
            for (int i = 0; i < authors.length - 1; i++) {
                sb.append(authors[i] + " ,");
            }
            sb.append(authors[authors.length-1]);
            author.setText(sb.toString());

        }
        return view;
    }
}
