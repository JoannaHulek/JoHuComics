package pl.johu_apps.johucomics.utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import pl.johu_apps.johucomics.specifics.Cage;
import pl.johu_apps.johucomics.specifics.Comic;

public class HttpHandler {

    private static final String comicsURL = "https://api.myjson.com/bins/d7rxb";

    public List<Comic> getComiscList() {
        List<Comic> comics = new ArrayList<>();

        try (InputStream inputStream = new URL(comicsURL).openStream()) {
            String jsonStream = readStream(inputStream);
            JSONObject jsonObject = new JSONObject(jsonStream);
            JSONArray comicsResults = jsonObject.getJSONArray("comics");
            for (int i = 0; i < comicsResults.length(); i++) {
                JSONObject comicResult = comicsResults.getJSONObject(i);
                String title = comicResult.getString("title");
                String author = comicResult.getString("author");

                ArrayList<Cage> cages = new ArrayList<>();
                JSONArray cagesResults = comicResult.getJSONArray("cages");
                for (int j = 0; j < cagesResults.length(); j++) {
                    JSONObject cageResult = cagesResults.getJSONObject(j);
                    int ordinalNumber = cageResult.getInt("ordinalNumber");
                    String imgURL = cageResult.getString("imgURL");
                    cages.add(new Cage(ordinalNumber, imgURL));
                }
                comics.add(new Comic(title, author, cages));
            }
        } catch (IOException | JSONException e) {
            System.out.println("Ups, something went wrong");
        }
        return comics;
    }

    private String readStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null)
                break;
            output.append(line).append("\n");
        }
        return output.toString();
    }
}
