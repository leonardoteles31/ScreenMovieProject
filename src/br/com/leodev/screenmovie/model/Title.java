package br.com.leodev.screenmovie.model;

import br.com.leodev.screenmovie.Exception.ExceptionYearConversionError;
import com.google.gson.annotations.SerializedName;

public class Title  implements Comparable<Title>{
    @SerializedName("Title")
    private String title;
    @SerializedName("Year")
    private int releaseYear;
    private boolean includedInPlan;
    private double rating;
    private int totalRatings;
    @SerializedName("Runtime")
    private int duration;

    public Title(String title, int releaseYear) {
        this.title = title;
        this.releaseYear = releaseYear;
    }

    public Title(OmdbTitle myOmdbTitle) {
        this.title = myOmdbTitle.title();

        if (myOmdbTitle.year().length() > 4) {
            throw new ExceptionYearConversionError("I couldnt convert the year cz has more than 04 characters");
        }
        this.releaseYear = Integer.valueOf(myOmdbTitle.year().substring(0, 4));
        this.duration = Integer.valueOf(myOmdbTitle.runtime().split(" ")[0]);
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

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void showDetails() {
        System.out.println("===============================================");
        System.out.println("Title: " + this.title);
        System.out.println("Release Year: " + this.releaseYear);
        System.out.println("Included in Plan: " + this.includedInPlan);
        System.out.println("Rating: " + this.rating);
        System.out.println("Total Ratings: " + this.totalRatings);
        System.out.println("Duration (minutes): " + this.duration);
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

    @Override
    public String toString() {
        return " | name='" + title + '\'' +
                ", releaseYear=" + releaseYear + "," +
                " duration=" + duration + " | ";
    }
}
