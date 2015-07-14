package me.frankelydiaz.simpleparser.attributes;

/**
 * Created by frankelydiaz on 7/13/15.
 */
public interface AttributeConverter<T> {
    T convert(Object value) throws AttributeConversionException;
}
