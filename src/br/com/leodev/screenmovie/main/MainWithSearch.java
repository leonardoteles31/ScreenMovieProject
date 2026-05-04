package br.com.leodev.screenmovie.main;

import br.com.leodev.screenmovie.Exception.ExceptionYearConversionError;
import br.com.leodev.screenmovie.env.EnvLoader;
import br.com.leodev.screenmovie.model.OmdbTitle;
import br.com.leodev.screenmovie.model.Title;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainWithSearch {
    static void main(String[] args) throws IOException, InterruptedException {
        EnvLoader.loadEnv("src/br/com/leodev/screenmovie/env/.env");

        Scanner read =  new Scanner(System.in);
        String apiKey = System.getenv("OMDB_API");
        String find = "";
        List<Title> titles = new ArrayList<>();

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        while(!find.equalsIgnoreCase("exit")){
            System.out.println("Enter a name movie: ");
            find = read.nextLine();

            if(find.equalsIgnoreCase("exit")) {
                break;
            }

            String address = "https://www.omdbapi.com/?t=" + find.replace(" ", "+") + "&apikey=" + apiKey;
            System.out.println(address);

            if(apiKey == null) {
                throw new RuntimeException("API KEY IS NULL");
            }

            try {

                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(address))
                        .build();
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();
                System.out.println(json);


                OmdbTitle myOmdbTitle = gson.fromJson(json, OmdbTitle.class);
                System.out.println(myOmdbTitle);

                Title myTitle = new Title(myOmdbTitle);
                System.out.println("Converted Title: ");
                System.out.println(myTitle);

                titles.add(myTitle);
            } catch (NumberFormatException e) {
                System.out.println("Happiness a error");
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid argument: " + e.getMessage());
            } catch (ExceptionYearConversionError e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println(titles);

        FileWriter writer = new FileWriter("titles.json");
        writer.write(gson.toJson(titles));
        writer.close();
        System.out.println("End of program");

    }
}
