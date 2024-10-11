package com.example.assignment3.model;

public class Movie {
    private int id;
    private String title;
    private String genre;
    private String director;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    private int releaseYear;

    public Movie(){

    }
    public Movie(String title, String genre, String director, int releaseYear) {
        this.title = title;
        this.genre = genre;
        this.director = director;
        this.releaseYear = releaseYear;
    }

}
