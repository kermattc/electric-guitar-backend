package com.kermatt.guitar_api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "guitar_models")
public class Guitar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String maker;
    private String model;
    private Integer introduced;
    private String notableUser1;
    private String notableUser2;
    private String notableUser3;
    private String feature1;
    private String feature2;
    private String feature3;
    private String feature4;
    private String feature5;
    private String popularity;
    private String dates; 
    private String finish1;
    private String finish2;
    private String finish3;
    private String finish4;
    private String finish5;

    private Guitar() {}

    public Guitar(String maker, String model, Integer introduced, String notableUser1, String notableUser2, String notableUser3, String feature1, String feature2, String feature3, String feature4, String feature5, String popularity, String dates, String finish1, String finish2, String finish3, String finish4, String finish5) {
        this.maker = maker;
        this.model = model;
        this.introduced = introduced;
        this.notableUser1 = notableUser1;
        this.notableUser2 = notableUser2;
        this.notableUser3 = notableUser3;
        this.feature1 = feature1;
        this.feature2 = feature2;
        this.feature3 = feature3;
        this.feature4 = feature4;
        this.feature5 = feature5;
        this.popularity = popularity;
        this.dates = dates;
        this.finish1 = finish1;
        this.finish2 = finish2;
        this.finish3 = finish3;
        this.finish4 = finish4;
        this.finish5 = finish5;
    }

    public String getMaker() {
        return this.maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getIntroduced() {
        return this.introduced;
    }

    public void setIntroduced(Integer introduced) {
        this.introduced = introduced;
    }

    public String getNotableUser1() {
        return this.notableUser1;
    }

    public void setNotableUser1(String notableUser1) {
        this.notableUser1 = notableUser1;
    }

    public String getNotableUser2() {
        return this.notableUser2;
    }

    public void setNotableUser2(String notableUser2) {
        this.notableUser2 = notableUser2;
    }

    public String getNotableUser3() {
        return this.notableUser3;
    }

    public void setNotableUser3(String notableUser3) {
        this.notableUser3 = notableUser3;
    }

    public String getFeature1() {
        return this.feature1;
    }

    public void setFeature1(String feature1) {
        this.feature1 = feature1;
    }

    public String getFeature2() {
        return this.feature2;
    }

    public void setFeature2(String feature2) {
        this.feature2 = feature2;
    }

    public String getFeature3() {
        return this.feature3;
    }

    public void setFeature3(String feature3) {
        this.feature3 = feature3;
    }

    public String getFeature4() {
        return this.feature4;
    }

    public void setFeature4(String feature4) {
        this.feature4 = feature4;
    }

    public String getFeature5() {
        return this.feature5;
    }

    public void setFeature5(String feature5) {
        this.feature5 = feature5;
    }

    public String getPopularity() {
        return this.popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }

    public String getDates() {
        return this.dates;
    }

    public void setDates(String dates) {
        this.dates = dates;
    }

    public String getFinish1() {
        return this.finish1;
    }

    public void setFinish1(String finish1) {
        this.finish1 = finish1;
    }

    public String getFinish2() {
        return this.finish2;
    }

    public void setFinish2(String finish2) {
        this.finish2 = finish2;
    }

    public String getFinish3() {
        return this.finish3;
    }

    public void setFinish3(String finish3) {
        this.finish3 = finish3;
    }

    public String getFinish4() {
        return this.finish4;
    }

    public void setFinish4(String finish4) {
        this.finish4 = finish4;
    }

    public String getFinish5() {
        return this.finish5;
    }

    public void setFinish5(String finish5) {
        this.finish5 = finish5;
    }
}