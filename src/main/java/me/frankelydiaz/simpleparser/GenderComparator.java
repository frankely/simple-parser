package me.frankelydiaz.simpleparser;

import java.util.Comparator;

/**
 * Created by frankelydiaz on 7/14/15.
 */
public class GenderComparator implements Comparator<Person> {
    public int compare(Person thisPerson, Person thatPerson) {
        int genderComparison = thisPerson.getGender().getShortDescription().compareTo(thatPerson.getGender().getShortDescription());

        if (genderComparison != 0) return genderComparison;

        int nameComparison = thisPerson.getLastName().compareTo(thatPerson.getLastName());

        return nameComparison;
    }
}
