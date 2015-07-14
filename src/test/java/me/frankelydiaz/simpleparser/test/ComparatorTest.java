package me.frankelydiaz.simpleparser.test;

import me.frankelydiaz.simpleparser.*;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by frankelydiaz on 7/14/15.
 */
public class ComparatorTest {

    public static final int MALE_PERSON_YEAR_OF_BIRTH = 1955;
    public static final String MALE_PERSON_LAST_NAME = "Doe";
    public static final String FEMALE_PERSON_LAST_NAME = "Kon";


    public static Person getMalePerson() {
        Person person = new Person();
        person.setFirstName("John");
        person.setLastName(MALE_PERSON_LAST_NAME);
        person.setGender(Gender.MALE);
        person.setDateOfBirth(DateUtils.getDateWithoutTime(MALE_PERSON_YEAR_OF_BIRTH, 5, 5));
        return person;
    }

    public static Person getFemalePerson() {
        Person person = new Person();
        person.setFirstName("Elizabeth");
        person.setLastName("Kon");
        person.setGender(Gender.FEMALE);
        person.setDateOfBirth(DateUtils.getDateWithoutTime(1980, 2, 2));
        return person;
    }



    @Test
    public void sortByGender() {
        List<Person> persons = new ArrayList<Person>();
        persons.add(getMalePerson());
        persons.add(getFemalePerson());


        Person anotherFemale = getFemalePerson();
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
        persons.add(getFemalePerson());
        persons.add(getMalePerson());

        Collections.sort(persons,new DateOfBirthComparator());


        Person firstPerson = persons.get(0);

        int actualYear = DateUtils.getCalendarWithoutTime(firstPerson.getDateOfBirth()).get(Calendar.YEAR);

        assertEquals(MALE_PERSON_YEAR_OF_BIRTH, actualYear);

    }

    @Test
    public void sortByLastNameDescending() {
        List<Person> persons = new ArrayList<Person>();
        persons.add(getFemalePerson());
        persons.add(getMalePerson());

        Collections.sort(persons,new LastNameDescendingComparator());

        Person firstPerson = persons.get(0);

        assertEquals(FEMALE_PERSON_LAST_NAME, firstPerson.getLastName());


    }
}
