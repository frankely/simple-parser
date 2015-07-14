package me.frankelydiaz.simpleparser;

/**
 * Created by frankelydiaz on 7/13/15.
 */
public enum  Gender {
    MALE("Male", "M"),
    FEMALE("Female", "F");

    private String shortDescription;
    private String description;


    Gender(String description, String shortDescription) {
        this.description = description;
        this.shortDescription = shortDescription;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getDescription() {
        return description;
    }
}
