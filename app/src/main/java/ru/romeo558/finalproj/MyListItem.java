package ru.romeo558.finalproj;

public class MyListItem {
    private String header;
    private String description;
    private String score;

    public MyListItem(String header, String description, String score) {
        this.header = header;
        this.description = description;
        this.score = score;
    }

    public String getHeader() {
        return header;
    }

    public String getDescription() {
        return description;
    }

    public String getScore() {
        return score;
    }



}