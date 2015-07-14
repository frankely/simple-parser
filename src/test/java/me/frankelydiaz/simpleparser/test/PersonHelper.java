package me.frankelydiaz.simpleparser.test;

import me.frankelydiaz.simpleparser.*;

/**
 * Created by frankelydiaz on 7/13/15.
 */
public class PersonHelper {
    public static final String ELEMENT_WITH_PIPE_SEPARATOR = "Smith | Steve | D | M | Red | 3-3-1985";
    public static final String ELEMENT_WITH_COMMA_SEPARATOR = "Abercrombie, Neil, Male, Tan, 2/13/1943";
    public static final String ELEMENT_WITH_SPACE_SEPARATOR = "Seles Monica H F 12-2-1973 Black";


    public static final int MALE_PERSON_YEAR_OF_BIRTH = 1955;
    public static final String MALE_PERSON_LAST_NAME = "Doe";
    public static final String FEMALE_PERSON_LAST_NAME = "Kon";


    public static Person getMalePerson() {
        Person person = new Person();
        person.setFirstName("John");
        person.setLastName(MALE_PERSON_LAST_NAME);
        person.setGender(Gender.MALE);
        person.setDateOfBirth(DateUtils.getDateWithoutTime(MALE_PERSON_YEAR_OF_BIRTH, 5, 5));
        person.setFavoriteColor("Blue");
        return person;
    }

    public static Person getFemalePerson() {
        Person person = new Person();
        person.setFirstName("Elizabeth");
        person.setLastName("Kon");
        person.setGender(Gender.FEMALE);
        person.setDateOfBirth(DateUtils.getDateWithoutTime(1980, 2, 2));
        person.setFavoriteColor("Green");
        return person;
    }

    public static Person getPersonFromPipe() {
        StringParser<Person> parser = getParser(Separator.PIPE);


        Person person = parser.parse(ELEMENT_WITH_PIPE_SEPARATOR);

        return person;
    }

    public static Person getPersonFromComma() {
        StringParser<Person> parser = getParser(Separator.COMMA);

        Person person = parser.parse(ELEMENT_WITH_COMMA_SEPARATOR);
        return person;
    }

    public static Person getPersonFromSpace() {
        StringParser<Person> parser = getParser(Separator.SPACE);

        return parser.parse(ELEMENT_WITH_SPACE_SEPARATOR);
    }

    public static StringParser getParser(Separator separator) {
        ParserConfiguration parserConfiguration = ParserConfigurationFactory.newInstance(separator);

        return StringParser.fromParserConfiguration(parserConfiguration);
    }
}
