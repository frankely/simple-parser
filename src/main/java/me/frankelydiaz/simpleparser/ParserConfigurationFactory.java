package me.frankelydiaz.simpleparser;

import me.frankelydiaz.simpleparser.attributes.AttributeConverter;
import me.frankelydiaz.simpleparser.attributes.DateAttributeConverter;
import me.frankelydiaz.simpleparser.attributes.GenderAttributeConverter;
import me.frankelydiaz.simpleparser.elements.PersonElementConverter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by frankelydiaz on 7/14/15.
 */
public class ParserConfigurationFactory {

    public static final String[] PIPE_ATTRIBUTES = {
            PersonElementConverter.LAST_NAME,
            PersonElementConverter.FIRST_NAME,
            PersonElementConverter.MIDDLE_INITIAL,
            PersonElementConverter.GENDER,
            PersonElementConverter.FAVORITE_COLOR,
            PersonElementConverter.DATE_OF_BIRTH
    };

    public static final String PIPE_DATE_FORMAT = "M-d-yyyy";

    public static final String[] COMMA_ATTRIBUTES = {
            PersonElementConverter.LAST_NAME,
            PersonElementConverter.FIRST_NAME,
            PersonElementConverter.GENDER,
            PersonElementConverter.FAVORITE_COLOR,
            PersonElementConverter.DATE_OF_BIRTH
    };
    private static final String COMMA_DATE_FORMAT = "M/d/yyyy";

    public static final String[] SPACE_ATTRIBUTES = {
            PersonElementConverter.LAST_NAME,
            PersonElementConverter.FIRST_NAME,
            PersonElementConverter.MIDDLE_INITIAL,
            PersonElementConverter.GENDER,
            PersonElementConverter.DATE_OF_BIRTH,
            PersonElementConverter.FAVORITE_COLOR
    };

    public static final String SPACE_DATE_FORMAT = "M-d-yyyyy";


    public static ParserConfiguration newInstance(Separator separator) {
        if (separator == Separator.PIPE) {
            Map<String, AttributeConverter> attributeConverters = new HashMap<String, AttributeConverter>();
            attributeConverters.put(PersonElementConverter.DATE_OF_BIRTH, new DateAttributeConverter(PIPE_DATE_FORMAT));
            attributeConverters.put(PersonElementConverter.GENDER, new GenderAttributeConverter());
            PersonElementConverter personElementConverter = new PersonElementConverter(attributeConverters);

            return new ParserConfiguration(PIPE_ATTRIBUTES,personElementConverter, separator);

        } else if (separator == Separator.COMMA) {
            Map<String, AttributeConverter> attributeConverters = new HashMap<String, AttributeConverter>();
            attributeConverters.put(PersonElementConverter.DATE_OF_BIRTH, new DateAttributeConverter(COMMA_DATE_FORMAT));
            attributeConverters.put(PersonElementConverter.GENDER, new GenderAttributeConverter());
            PersonElementConverter personElementConverter = new PersonElementConverter(attributeConverters);

            return new ParserConfiguration(COMMA_ATTRIBUTES,personElementConverter, separator);

        } else if (separator == Separator.SPACE) {

            Map<String, AttributeConverter> attributeConverters = new HashMap<String, AttributeConverter>();
            attributeConverters.put(PersonElementConverter.DATE_OF_BIRTH, new DateAttributeConverter(SPACE_DATE_FORMAT));
            attributeConverters.put(PersonElementConverter.GENDER, new GenderAttributeConverter());
            PersonElementConverter personElementConverter = new PersonElementConverter(attributeConverters);
            return new ParserConfiguration(SPACE_ATTRIBUTES, personElementConverter,separator);
        }

        return null;
    }

}
