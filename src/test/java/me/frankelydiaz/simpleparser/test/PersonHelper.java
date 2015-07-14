package me.frankelydiaz.simpleparser.test;

import me.frankelydiaz.simpleparser.*;

/**
 * Created by frankelydiaz on 7/13/15.
 */
public class PersonHelper {
    public static final String ELEMENT_WITH_PIPE_SEPARATOR = "Smith | Steve | D | M | Red | 3-3-1985";
    public static final String ELEMENT_WITH_COMMA_SEPARATOR = "Abercrombie, Neil, Male, Tan, 2/13/1943";
    public static final String ELEMENT_WITH_SPACE_SEPARATOR = "Seles Monica H F 12-2-1973 Black";


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
