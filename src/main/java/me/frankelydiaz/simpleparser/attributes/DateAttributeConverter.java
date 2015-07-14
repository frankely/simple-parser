package me.frankelydiaz.simpleparser.attributes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by frankelydiaz on 7/13/15.
 */
public class DateAttributeConverter implements AttributeConverter<Date> {

    private final SimpleDateFormat formatter;

    public DateAttributeConverter(String format) {
         formatter = new SimpleDateFormat(format);
    }


    public Date convert(Object value) throws AttributeConversionException {
        try {
            return formatter.parse(value.toString());
        } catch (ParseException e) {
            throw new AttributeConversionException();
        }
    }
}
