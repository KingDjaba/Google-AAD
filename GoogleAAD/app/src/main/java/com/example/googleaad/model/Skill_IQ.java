package com.example.googleaad.model;

public class Skill_IQ {
    private String name, country, badgeUrl;
    private int score;

    public Skill_IQ(String name, String country, String badgeUrl, int score) {
        this.name = name;
        this.country = country;
        this.badgeUrl = badgeUrl;
        this.score = score;
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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String  toString() {
        return "SkillIQ{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", badgeUrl='" + badgeUrl + '\'' +
                ", score=" + score +
                '}';
    }
}

