package me.frankelydiaz.simpleparser;

import java.util.Comparator;

/**
 * Created by frankelydiaz on 7/14/15.
 */
public class LastNameDescendingComparator implements Comparator<Person>{
    public int compare(Person thisPerson, Person thatPerson) {
        return thatPerson.getLastName().compareTo(thisPerson.getLastName());
    }
}
