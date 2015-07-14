package me.frankelydiaz.simpleparser;

import me.frankelydiaz.simpleparser.elements.Element;
import me.frankelydiaz.simpleparser.elements.ElementConverter;

/**
 * Created by frankelydiaz on 7/13/15.
 */
public class StringParser<T> extends Parser<T, String> {

    private Separator separator;
    private ElementConverter<T> elementConverter;
    private String[] attributeNames;

    protected StringParser(ParserConfiguration configuration) {
        this.separator = configuration.getSeparator();
        this.elementConverter = configuration.getElementConverter();
        this.attributeNames = configuration.getAttributeNames();
    }

    public static StringParser fromParserConfiguration(ParserConfiguration configuration) {
        return new StringParser(configuration);

    }

    @Override
    public T parse(String value) {
        final String[] attributes = newArrayWithoutSpaces(value.split(separator.getExpression()));

        Element element = Element.fromArray(attributes, attributeNames);

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
