package me.frankelydiaz.simpleparser.test;

import me.frankelydiaz.simpleparser.Gender;
import me.frankelydiaz.simpleparser.Person;
import me.frankelydiaz.simpleparser.Separator;
import me.frankelydiaz.simpleparser.StringParser;
import me.frankelydiaz.simpleparser.attributes.AttributeConverter;
import me.frankelydiaz.simpleparser.attributes.DateAttributeConverter;
import me.frankelydiaz.simpleparser.attributes.GenderAttributeConverter;
import me.frankelydiaz.simpleparser.elements.PersonElementConverter;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by frankelydiaz on 7/13/15.
 */
public class StringParserTest {


    @Test
    public void parseElementWithPipeSeparator() {

        Person person = PersonHelper.getPersonFromPipe();

        assertEquals("Smith", person.getLastName());
        assertEquals("Steve", person.getFirstName());
        assertEquals(Gender.MALE, person.getGender());
        assertEquals("Red", person.getFavoriteColor());


        Date expectedDateOfBirth = DateUtils.getDateWithoutTime(1985, 3, 3);
        Date actualDateOfBirth = DateUtils.getDateWithoutTime(person.getDateOfBirth());

        assertEquals(expectedDateOfBirth, actualDateOfBirth);


    }

    @Test
    public void parseElementWithCommaSeparator() {
        Person person = PersonHelper.getPersonFromComma();

        assertEquals("Abercrombie", person.getLastName());
        assertEquals("Neil", person.getFirstName());
        assertEquals(Gender.MALE, person.getGender());
        assertEquals("Tan", person.getFavoriteColor());

        Date expectedDateOfBirth = DateUtils.getDateWithoutTime(1943, 2, 13);
        Date actualDateOfBirth = DateUtils.getDateWithoutTime(person.getDateOfBirth());

        assertEquals(expectedDateOfBirth, actualDateOfBirth);

    }

    @Test
    public void parseElementWithSpaceSeparator() {
        Person person = PersonHelper.getPersonFromSpace();

        assertEquals("Seles", person.getLastName());
        assertEquals("Monica", person.getFirstName());
        assertEquals(Gender.FEMALE, person.getGender());
        assertEquals("Black", person.getFavoriteColor());

        Date expectedDateOfBirth = DateUtils.getDateWithoutTime(1973, 12, 2);
        Date actualDateOfBirth = DateUtils.getDateWithoutTime(person.getDateOfBirth());

        assertEquals(expectedDateOfBirth, actualDateOfBirth);

    }

}
