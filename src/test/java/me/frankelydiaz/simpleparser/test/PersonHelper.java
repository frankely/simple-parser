package me.frankelydiaz.simpleparser.test;

import me.frankelydiaz.simpleparser.Person;
import me.frankelydiaz.simpleparser.Separator;
import me.frankelydiaz.simpleparser.StringParser;
import me.frankelydiaz.simpleparser.attributes.AttributeConverter;
import me.frankelydiaz.simpleparser.attributes.DateAttributeConverter;
import me.frankelydiaz.simpleparser.attributes.GenderAttributeConverter;
import me.frankelydiaz.simpleparser.elements.PersonElementConverter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by frankelydiaz on 7/13/15.
 */
public class PersonHelper {
    public static final String ELEMENT_WITH_PIPE_SEPARATOR = "Smith | Steve | D | M | Red | 3-3-1985";
    public static final String ELEMENT_WITH_COMMA_SEPARATOR = "Abercrombie, Neil, Male, Tan, 2/13/1943";
    public static final String ELEMENT_WITH_SPACE_SEPARATOR = "Seles Monica H F 12-2-1973 Black";

    public static final String[] PIPE_ATTRIBUTES = {
            PersonElementConverter.LAST_NAME,
            PersonElementConverter.FIRST_NAME,
            PersonElementConverter.MIDDLE_INITIAL,
            PersonElementConverter.GENDER,
            PersonElementConverter.FAVORITE_COLOR,
            PersonElementConverter.DATE_OF_BIRTH
    };


    public static final String[] COMMA_ATTRIBUTES = {
            PersonElementConverter.LAST_NAME,
            PersonElementConverter.FIRST_NAME,
            PersonElementConverter.GENDER,
            PersonElementConverter.FAVORITE_COLOR,
            PersonElementConverter.DATE_OF_BIRTH
    };

    public static final String[] SPACE_ATTRIBUTES = {
            PersonElementConverter.LAST_NAME,
            PersonElementConverter.FIRST_NAME,
            PersonElementConverter.MIDDLE_INITIAL,
            PersonElementConverter.GENDER,
            PersonElementConverter.DATE_OF_BIRTH,
            PersonElementConverter.FAVORITE_COLOR
    };

    public static Person getPersonFromPipe() {
        StringParser<Person> parser = StringParser.fromSeparator(Separator.PIPE);

        Map<String, AttributeConverter> attributeConverters = new HashMap<String, AttributeConverter>();
        attributeConverters.put(PersonElementConverter.DATE_OF_BIRTH, new DateAttributeConverter("M-d-yyyy"));
        attributeConverters.put(PersonElementConverter.GENDER, new GenderAttributeConverter());
        PersonElementConverter personElementConverter = new PersonElementConverter(attributeConverters);


        Person person = parser.parse(ELEMENT_WITH_PIPE_SEPARATOR, PIPE_ATTRIBUTES, personElementConverter);

        return person;
    }

    public static Person getPersonFromComma() {
        StringParser<Person> parser = StringParser.fromSeparator(Separator.COMMA);

        Map<String, AttributeConverter> attributeConverters = new HashMap<String, AttributeConverter>();
        attributeConverters.put(PersonElementConverter.DATE_OF_BIRTH, new DateAttributeConverter("M/d/yyyy"));
        attributeConverters.put(PersonElementConverter.GENDER, new GenderAttributeConverter());
        PersonElementConverter personElementConverter = new PersonElementConverter(attributeConverters);


        Person person = parser.parse(ELEMENT_WITH_COMMA_SEPARATOR, COMMA_ATTRIBUTES, personElementConverter);
        return person;
    }

    public static Person getPersonFromSpace() {
        StringParser<Person> parser = StringParser.fromSeparator(Separator.SPACE);

        Map<String, AttributeConverter> attributeConverters = new HashMap<String, AttributeConverter>();
        attributeConverters.put(PersonElementConverter.DATE_OF_BIRTH, new DateAttributeConverter("M-d-yyyyy"));
        attributeConverters.put(PersonElementConverter.GENDER, new GenderAttributeConverter());
        PersonElementConverter personElementConverter = new PersonElementConverter(attributeConverters);


        return parser.parse(ELEMENT_WITH_SPACE_SEPARATOR, SPACE_ATTRIBUTES, personElementConverter);
    }
}
