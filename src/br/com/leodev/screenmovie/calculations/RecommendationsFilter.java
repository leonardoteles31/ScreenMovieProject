package br.com.leodev.screenmovie.calculations;

public class RecommendationsFilter {
    private String recommendation;

    public void filter(Classifiable classifiable) {
        if (classifiable.getClassification() >= 4) {
            System.out.println("Is between in the favorites of the moment");
        } else if (classifiable.getClassification() >= 2) {
            System.out.println("Very well avaliated in the moment!");
        } else {
            System.out.println("Put in your list to watch later");
        }
    }
}
