package br.com.leodev.screenmovie.main;

import br.com.leodev.screenmovie.calculations.RecommendationsFilter;
import br.com.leodev.screenmovie.calculations.TimeCalculator;
import br.com.leodev.screenmovie.model.Episode;
import br.com.leodev.screenmovie.model.Movie;
import br.com.leodev.screenmovie.model.Serie;

import java.util.ArrayList;

public class Main {
    static void main(String[] args) {
        Movie myMovie = new Movie("Cars", 2006);
        myMovie.setDurationInMinutes(116);

        myMovie.showDetails();
        myMovie.rates(9.0);
        myMovie.rates(7.5);
        myMovie.rates(8.0);
        System.out.println("Total Ratings: " + myMovie.getTotalRatings());
        System.out.println("Average Rating: " + myMovie.rateAverage());

        Movie anotherMovie = new Movie("The Incredibles", 2004);
        anotherMovie.setDurationInMinutes(115);
        anotherMovie.showDetails();
        System.out.println("Total Ratings: " + anotherMovie.getTotalRatings());
        System.out.println("Average Rating: " + anotherMovie.rateAverage());

        Serie GossipGirl = new Serie("Gossip girl", 2007);
        GossipGirl.showDetails();
        GossipGirl.setSeasons(6);
        GossipGirl.setEpisodesPerSeason(20);
        GossipGirl.setMinutesPerEpisode(45);
        System.out.println("Duration of the serie in minutes: " + GossipGirl.getDurationInMinutes());

        TimeCalculator calculator = new TimeCalculator();
        calculator.include(myMovie);
        System.out.println("Total time to watch: " + calculator.getTotalTime() + " minutes");

        calculator.include(GossipGirl);
        System.out.println("Total time to watch: " + calculator.getTotalTime() + " minutes");

        RecommendationsFilter filter = new RecommendationsFilter();
        filter.filter(myMovie);

        Episode ep = new Episode();
        ep.setNumber(1);
        ep.setSerie(GossipGirl);
        ep.setTotalView(300);
        filter.filter(ep);

        ArrayList<Movie> movieList = new ArrayList<>();
        movieList.add(myMovie);
        movieList.add(anotherMovie);
        System.out.println("Size list: " + movieList.size());
        System.out.println("First Movie: " + movieList.get(0).getTitle());
        System.out.println(movieList);
        System.out.println("Movie toString: " + movieList.get(0).toString());
        System.out.println(movieList);

    }
}
