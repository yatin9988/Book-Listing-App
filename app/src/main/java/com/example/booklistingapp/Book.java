package com.example.booklistingapp;

public class Book {

    private String title;
    private String pageCount;
    private String publishedDate;
    private String[] authors;

    public Book(String title,String pageCount,String publishedDate,String []authors){
        this.title = title;
        this.pageCount = pageCount;
        this.publishedDate = publishedDate;
        this.authors = authors;
    }

    public String getTitle(){
        return this.title;
    }

    public String getPageCount(){
        return this.pageCount;
    }

    public String getPublishedDate(){
        return this.publishedDate;
    }

    public String[] getAuthors(){
        return this.authors;
    }

}
