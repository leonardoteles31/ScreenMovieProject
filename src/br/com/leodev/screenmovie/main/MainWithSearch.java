package br.com.leodev.screenmovie.main;

import br.com.leodev.screenmovie.model.Title;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class MainWithSearch {
    static void main(String[] args) throws IOException, InterruptedException {
        Scanner read =  new Scanner(System.in);

        System.out.println("Enter a name movie: ");
        var find = read.nextLine();

        String adress = "https://www.omdbapi.com/?t=" + find + "&apikey=";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(adress))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();
        System.out.println(json);

        Gson gson = new Gson();
        Title myTitle = gson.fromJson(response.body(), Title.class);
        System.out.println(myTitle.getTitle());
    }
}
