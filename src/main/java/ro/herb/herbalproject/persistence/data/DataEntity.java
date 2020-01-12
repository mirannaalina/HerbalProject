package ro.herb.herbalproject.persistence.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class DataEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name ="date")
    private String date;

    @Column(name ="kg")
    private int kg;

    @Column(name ="bodyfat")
    private int bodyfat;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
