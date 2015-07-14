package me.frankelydiaz.simpleparser;

/**
 * Created by frankelydiaz on 7/13/15.
 */
public enum  Gender {
    MALE("M", "Male"),
    FEMALE("Female", "F");

    private String shortDescription;
    private String description;


    Gender(String shortDescription, String description) {
        this.shortDescription = shortDescription;
        this.description = description;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getDescription() {
        return description;
    }
}
