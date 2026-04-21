package br.com.leodev.screenmovie.model;

import br.com.leodev.screenmovie.calculations.Classifiable;

public class Title  implements Comparable<Title>{
    private String title;
    private int releaseYear;
    private boolean includedInPlan;
    private double rating;
    private int totalRatings;
    private int durationInMinutes;

    public Title(String title, int releaseYear) {
        this.title = title;
        this.releaseYear = releaseYear;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public boolean isIncludedInPlan() {
        return includedInPlan;
    }

    public void setIncludedInPlan(boolean includedInPlan) {
        this.includedInPlan = includedInPlan;
    }

    public double getRating() {
        return rating;
    }

    public int getTotalRatings() {
        return totalRatings;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public void showDetails() {
        System.out.println("===============================================");
        System.out.println("Title: " + this.title);
        System.out.println("Release Year: " + this.releaseYear);
        System.out.println("Included in Plan: " + this.includedInPlan);
        System.out.println("Rating: " + this.rating);
        System.out.println("Total Ratings: " + this.totalRatings);
        System.out.println("Duration (minutes): " + this.durationInMinutes);
        System.out.println("===============================================");
    }

    public void rates(double rate) {
        rating += rate;
        totalRatings++;
    }

    public double rateAverage() {
        return rating / totalRatings;
    }

    @Override
    public int compareTo(Title o) {
        return this.getTitle().compareTo(o.getTitle());
    }
}
