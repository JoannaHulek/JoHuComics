package pl.johu_apps.johucomics.specifics;

import java.util.ArrayList;

public class Comic {
    private static String title;
    private static String author;
    private static ArrayList<Cage> cagesList;

    public Comic(String title, String author, ArrayList<Cage> cagesList) {
        this.title = title;
        this.author = author;
        this.cagesList = cagesList;
    }

    public static String getTitle() {
        return title;
    }

    public static String getAuthor() {
        return author;
    }

    public static ArrayList<Cage> getCagesList() {
        return cagesList;
    }
}
