package com.example.filmeFinder.domain.gateway;

public class APIMovie {
    private String title;
    private String originalTitle;
    private String gender;
    private String releaseDate;
    private boolean adult;
    private double popularity;
    private int voteCount;

    public APIMovie(String title, String originalTitle, String gender, String releaseDate, boolean adult, double popularity, int voteCount) {
        this.title = title;
        this.originalTitle = originalTitle;
        this.gender = gender;
        this.releaseDate = releaseDate;
        this.adult = adult;
        this.popularity = popularity;
        this.voteCount = voteCount;
    }

    public String getTitle() {
        return title;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getGender() {
        return gender;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public boolean isAdult() {
        return adult;
    }

    public double getPopularity() {
        return popularity;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }
}
