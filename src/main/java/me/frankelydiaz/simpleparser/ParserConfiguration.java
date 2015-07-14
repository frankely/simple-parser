package me.frankelydiaz.simpleparser;

import me.frankelydiaz.simpleparser.elements.ElementConverter;

/**
 * Created by frankelydiaz on 7/14/15.
 */
public class ParserConfiguration {
    private String[] attributeNames;
    private ElementConverter elementConverter;
    private Separator separator;


    public ParserConfiguration(String[] attributeNames, ElementConverter elementConverter, Separator separator) {
        this.attributeNames = attributeNames;
        this.elementConverter = elementConverter;
        this.separator = separator;
    }

    public ElementConverter getElementConverter() {
        return elementConverter;
    }

    public String[] getAttributeNames() {
        return attributeNames;
    }

    public Separator getSeparator() {
        return separator;
    }
}
