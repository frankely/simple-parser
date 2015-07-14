package me.frankelydiaz.simpleparser;

import java.util.Comparator;

/**
 * Created by frankelydiaz on 7/14/15.
 */
public class DateOfBirthComparator implements Comparator<Person> {
    public int compare(Person thisPerson, Person thatPerson) {
        return thisPerson.getDateOfBirth().compareTo(thatPerson.getDateOfBirth());
    }
}
