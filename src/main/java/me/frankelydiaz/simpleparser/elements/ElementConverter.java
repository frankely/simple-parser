package me.frankelydiaz.simpleparser.elements;

import me.frankelydiaz.simpleparser.attributes.AttributeConversionException;
import me.frankelydiaz.simpleparser.attributes.AttributeConverter;

import java.util.Map;

/**
 * Created by frankelydiaz on 7/13/15.
 */
public abstract class ElementConverter<T> {

    private Map<String, AttributeConverter> attributeConverters;

    public ElementConverter(Map<String,AttributeConverter> attributeConverters) {

        this.attributeConverters = attributeConverters;
    }


    public abstract T convert(Element element);

    protected Object convertAttribute(Element element, String name) {

        final Object value = element.getAttribute(name);

        if (attributeConverters != null && attributeConverters.containsKey(name)) {
            try {
                return attributeConverters.get(name).convert(value);
            } catch (AttributeConversionException e) {
                e.printStackTrace();
            }
        }

        return value;
    }
}
