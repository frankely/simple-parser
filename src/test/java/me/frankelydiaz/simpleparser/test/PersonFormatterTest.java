package me.frankelydiaz.simpleparser.test;

import me.frankelydiaz.simpleparser.Person;
import me.frankelydiaz.simpleparser.PersonFormatter;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by frankelydiaz on 7/14/15.
 */
public class PersonFormatterTest {

    @Test
    public void formatFemalePerson() {
        PersonFormatter formatter = new PersonFormatter();
        Person person = PersonHelper.getFemalePerson();

        String expectedPerson = "Kon Elizabeth Female 2/2/1980 Green";
        String formattedPerson = formatter.format(person);


        assertEquals(expectedPerson,formattedPerson);

    }

    @Test
    public void formatMalePerson() {
        PersonFormatter formatter = new PersonFormatter();
        Person person = PersonHelper.getMalePerson();

        String expectedPerson = "Doe John Male 5/5/1955 Blue";
        String formattedPerson = formatter.format(person);


        assertEquals(expectedPerson,formattedPerson);

    }
}
