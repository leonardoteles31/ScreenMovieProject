package br.com.leodev.screenmovie.main;

import br.com.leodev.screenmovie.model.Movie;
import br.com.leodev.screenmovie.model.Serie;
import br.com.leodev.screenmovie.model.Title;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainList {
    static void main(String[] args) {
        Movie myMovie = new Movie("Cars", 2006);
        Movie anotherMovie = new Movie("The Incredibles", 2004);
        var anaMovies = new Movie("Whiplash", 2014);
        Serie GossipGirl = new Serie("Gossip Girl", 2007);

        List<Title> watchedList = new ArrayList<>();
        watchedList.add(anaMovies);
        watchedList.add(myMovie);
        watchedList.add(anotherMovie);
        watchedList.add(GossipGirl);

        Movie m1 = anaMovies;

        for (Title item: watchedList) {
            System.out.println(item.getTitle());
            if (item instanceof Movie movie && movie.getClassification() > 2) {
                System.out.println("Classification: " + movie.getClassification());
            }

        }

        ArrayList<String> searchByArtist = new ArrayList<>();
        searchByArtist.add("Adam Sandler");
        searchByArtist.add("Bob");
        searchByArtist.add("Anna");
        System.out.println(searchByArtist);

        Collections.sort(searchByArtist);
        System.out.println("after the sort");
        System.out.println(searchByArtist);

        Collections.sort(watchedList);
        System.out.println(watchedList);
        watchedList.sort(Comparator.comparing(Title::getReleaseYear));


    }
}
