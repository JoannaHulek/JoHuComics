package pl.johu_apps.johucomics.specifics;

import java.util.ArrayList;

public class Comic {
    private String title;
    private String author;
    private String comicLogoURL;
    private ArrayList<Cage> cagesList;

    public Comic(String title, String author, ArrayList<Cage> cagesList) {
        this.title = title;
        this.author = author;
        this.cagesList = cagesList;
        this.comicLogoURL = "https://vgarmada.files.wordpress.com/2011/08/dilbert.jpg";
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public ArrayList<Cage> getCagesList() {
        return cagesList;
    }

    public String getComicLogoURL() {
        return comicLogoURL;
    }
}
