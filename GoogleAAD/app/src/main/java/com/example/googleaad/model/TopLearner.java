package com.example.googleaad.model;

public class TopLearner {
    private String name, country, badgeUrl;
    private int hours;

    public TopLearner(String name, String country, String badgeUrl, int hours) {
        this.name = name;
        this.country = country;
        this.badgeUrl = badgeUrl;
        this.hours = hours;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getBadgeUrl() {
        return badgeUrl;
    }

    public void setBadgeUrl(String badgeUrl) {
        this.badgeUrl = badgeUrl;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    @Override
    public String toString() {
        return "TopLearner{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", badgeUrl='" + badgeUrl + '\'' +
                ", hours=" + hours +
                '}';
    }
}
