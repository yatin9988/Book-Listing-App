package com.example.booklistingapp;

public class Book {

    private String title;
    private String pageCount;
    private String publishedDate;
    private String authors;
    private String imageLink;
    private String canonicalVolumeLink;

    public Book(String title,String pageCount,String publishedDate,String authors,String imageLink,String canonicalVolumeLink){
        this.title = title;
        this.pageCount = pageCount;
        this.publishedDate = publishedDate;
        this.authors = authors;
        this.imageLink = imageLink;
        this.canonicalVolumeLink = canonicalVolumeLink;
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

    public String getAuthors(){
        return this.authors;
    }

    public String getImageLink(){
        return this.imageLink;
    }

    public String getCanonicalVolumeLink(){
        return this.canonicalVolumeLink;
    }

}
