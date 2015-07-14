package me.frankelydiaz.simpleparser;


import java.text.SimpleDateFormat;

/**
 * Created by frankelydiaz on 7/14/15.
 */
public class PersonFormatter implements Formatter<Person> {
    public String format(Person person) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("M/d/yyyy");
        String dateOfBirth = simpleDateFormat.format(person.getDateOfBirth());

        return String.format("%s %s %s %s %s", person.getLastName(), person.getFirstName(), person.getGender().getDescription(), dateOfBirth, person.getFavoriteColor());
    }
}
