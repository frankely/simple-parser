package me.frankelydiaz.simpleparser.attributes;

import me.frankelydiaz.simpleparser.Gender;

/**
 * Created by frankelydiaz on 7/13/15.
 */
public class GenderAttributeConverter implements AttributeConverter<Gender> {


    public Gender convert(Object value) throws AttributeConversionException {
        if (value.equals(Gender.MALE.getDescription()) || value.equals(Gender.MALE.getShortDescription())) {
            return Gender.MALE;
        }
        else if (value.equals(Gender.FEMALE.getDescription()) || value.equals(Gender.FEMALE.getShortDescription())) {
            return Gender.FEMALE;
        }

        throw new AttributeConversionException();
    }
}
