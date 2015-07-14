package me.frankelydiaz.simpleparser.test;

import me.frankelydiaz.simpleparser.*;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by frankelydiaz on 7/14/15.
 */
public class ComparatorTest {





    @Test
    public void sortByGender() {
        List<Person> persons = new ArrayList<Person>();
        persons.add(PersonHelper.getMalePerson());
        persons.add(PersonHelper.getFemalePerson());


        Person anotherFemale = PersonHelper.getFemalePerson();
        anotherFemale.setLastName("Abott");

        persons.add(anotherFemale);

        Collections.sort(persons,new GenderComparator());


        Person firstPerson = persons.get(0);
        Person secondPerson = persons.get(1);

        assertEquals(Gender.FEMALE, firstPerson.getGender());
        assertEquals(Gender.FEMALE, secondPerson.getGender());
        assertEquals("Abott",firstPerson.getLastName());

    }


    @Test
    public void sortByDateOfBirth() {
        List<Person> persons = new ArrayList<Person>();
        persons.add(PersonHelper.getFemalePerson());
        persons.add(PersonHelper.getMalePerson());

        Collections.sort(persons,new DateOfBirthComparator());


        Person firstPerson = persons.get(0);

        int actualYear = DateUtils.getCalendarWithoutTime(firstPerson.getDateOfBirth()).get(Calendar.YEAR);

        assertEquals(PersonHelper.MALE_PERSON_YEAR_OF_BIRTH, actualYear);

    }

    @Test
    public void sortByLastNameDescending() {
        List<Person> persons = new ArrayList<Person>();
        persons.add(PersonHelper.getFemalePerson());
        persons.add(PersonHelper.getMalePerson());

        Collections.sort(persons,new LastNameDescendingComparator());

        Person firstPerson = persons.get(0);

        assertEquals(PersonHelper.FEMALE_PERSON_LAST_NAME, firstPerson.getLastName());


    }
}
