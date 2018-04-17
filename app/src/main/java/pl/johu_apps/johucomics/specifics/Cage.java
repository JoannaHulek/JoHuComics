package pl.johu_apps.johucomics.specifics;

public class Cage {
    private static int ordinalNumber;
    private static String imgURL;

    public Cage(int ordinalNumber, String imgURL) {
        this.ordinalNumber = ordinalNumber;
        this.imgURL = imgURL;
    }

    public static int getOrdinalNumber() {
        return ordinalNumber;
    }

    public static String getImgURL() {
        return imgURL;
    }
}
