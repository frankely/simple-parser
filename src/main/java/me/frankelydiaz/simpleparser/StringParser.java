package me.frankelydiaz.simpleparser;

import java.util.StringTokenizer;

/**
 * Created by frankelydiaz on 7/13/15.
 */
public class StringParser extends Parser<String, String[]> {

    private char separator;

    protected StringParser(char separator) {
        this.separator = separator;
    }

    public static StringParser fromCharacterSeparator(char separator) {
        return new StringParser(separator);

    }

    @Override
    public String[] parse(String element) {
        final String[] attributes = element.split(String.format("%c", separator));
        return newArrayWithoutSpaces(attributes);
    }

    private String[] newArrayWithoutSpaces(String[] attributes) {
        String[] attributesWithoutSpaces = new String[attributes.length];

        for (int i = 0; i < attributes.length; i++) {
            attributesWithoutSpaces[i] = attributes[i].trim();
        }

        return attributesWithoutSpaces;
    }
}
