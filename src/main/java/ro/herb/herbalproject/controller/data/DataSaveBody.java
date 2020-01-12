package ro.herb.herbalproject.controller.data;

public class DataSaveBody {


    private String date;
    private int kg;
    private int bodyfat;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getKg() {
        return kg;
    }

    public void setKg(int kg) {
        this.kg = kg;
    }

    public int getBodyfat() {
        return bodyfat;
    }

    public void setBodyfat(int bodyfat) {
        this.bodyfat = bodyfat;
    }
}
