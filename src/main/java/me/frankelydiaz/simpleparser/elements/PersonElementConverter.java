package me.frankelydiaz.simpleparser.elements;

import me.frankelydiaz.simpleparser.Gender;
import me.frankelydiaz.simpleparser.Person;
import me.frankelydiaz.simpleparser.attributes.AttributeConverter;

import java.util.Date;
import java.util.Map;

/**
 * Created by frankelydiaz on 7/13/15.
 */
public class PersonElementConverter extends ElementConverter<Person> {
    public static final String FIRST_NAME = "firstname";
    public static final String LAST_NAME = "lastname";
    public static final String MIDDLE_INITIAL = "middleinitial";
    public static final String GENDER = "gender";
    public static final String DATE_OF_BIRTH = "dateofbirth";
    public static final String FAVORITE_COLOR = "favoritecolor";

    public PersonElementConverter(Map<String, AttributeConverter> attributeConverters) {
        super(attributeConverters);
    }

    public Person convert(Element element) {
        Person person = new Person();

        person.setFirstName((String) convertAttribute(element,FIRST_NAME));
        person.setLastName((String) convertAttribute(element,LAST_NAME));
        person.setFavoriteColor((String) convertAttribute(element,FAVORITE_COLOR));
        person.setMiddleInitial((String) convertAttribute(element, MIDDLE_INITIAL));
        person.setGender((Gender) convertAttribute(element, GENDER));
        person.setDateOfBirth((Date) convertAttribute(element, DATE_OF_BIRTH));

        return person;
    }





}
