package me.frankelydiaz.simpleparser;

import me.frankelydiaz.simpleparser.elements.Element;
import me.frankelydiaz.simpleparser.elements.ElementConverter;

/**
 * Created by frankelydiaz on 7/13/15.
 */
public class StringParser<T> extends Parser<T,String> {

    private Separator separator;

    protected StringParser(Separator separator) {
        this.separator = separator;
    }

    public static StringParser fromSeparator(Separator separator) {
        return new StringParser(separator);

    }

    @Override
    public T parse(String value, String[] attributeNames, ElementConverter<T> elementConverter) {
        final String[] attributes = newArrayWithoutSpaces(value.split(separator.getExpression()));

        Element element = Element.fromArray(attributes,attributeNames);

        return elementConverter.convert(element);
    }

    private String[] newArrayWithoutSpaces(String[] attributes) {
        String[] attributesWithoutSpaces = new String[attributes.length];

        for (int i = 0; i < attributes.length; i++) {
            attributesWithoutSpaces[i] = attributes[i].trim();
        }

        return attributesWithoutSpaces;
    }
}
