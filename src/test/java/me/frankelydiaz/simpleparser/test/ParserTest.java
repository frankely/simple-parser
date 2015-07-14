package me.frankelydiaz.simpleparser.test;

import junit.framework.Assert;
import me.frankelydiaz.simpleparser.StringParser;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by frankelydiaz on 7/13/15.
 */
public class ParserTest {

    private static final char COMMA_SEPARATOR = ',';
    private static final char PIPE_SEPARATOR = '|';
    private static final String ELEMENT_WITH_PIPE_SEPARATOR = "Smith | Steve | D | M | Red | 3-3-1985";
    public static final String ELEMENT_WITH_COMMA_SEPARATOR = "Abercrombie, Neil, Male, Tan, 2/13/1943";

    @Test
    public void parseElementWithCommaSeparator() {
        StringParser parser = StringParser.fromCharacterSeparator(COMMA_SEPARATOR);
        String[] attributes = parser.parse(ELEMENT_WITH_COMMA_SEPARATOR);

        assertEquals("Abercrombie", attributes[0]);
        assertEquals("Neil", attributes[1]);

    }

    @Test
    public void parseElementWithPipeSeparator() {
        StringParser parser = StringParser.fromCharacterSeparator(PIPE_SEPARATOR);
        String[] attributes = parser.parse(ELEMENT_WITH_PIPE_SEPARATOR);

        assertEquals("Smith", attributes[0]);
        assertEquals("Steve", attributes[1]);

    }
}
