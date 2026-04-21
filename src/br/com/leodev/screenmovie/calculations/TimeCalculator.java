package br.com.leodev.screenmovie.calculations;

import br.com.leodev.screenmovie.model.Movie;
import br.com.leodev.screenmovie.model.Title;


public class TimeCalculator {
    private int totalTime;

    public int getTotalTime() {
        return totalTime;
    }

    public void include(Movie m) {
        this.totalTime += m.getDurationInMinutes();
    }

    public void include(Title t) {
        this.totalTime += t.getDurationInMinutes();
    }
}
