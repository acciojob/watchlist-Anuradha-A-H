package com.driver;
// encaptulation
public class Movie {
    private String name;
    private int durationInMinutes;
    private Double imbdRating;

    public Movie(){

    }
    public Movie(String name, int durationInMinutes, double imbdRating)
    {
        this.name = name;
        this.durationInMinutes = durationInMinutes;
        this.imbdRating = imbdRating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(Integer durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public Double getImbdRating() {
        return imbdRating;
    }

    public void setImbdRating(Double imbdRating) {
        this.imbdRating = imbdRating;
    }
}
