import me.frankelydiaz.simpleparser.*;
import me.frankelydiaz.simpleparser.Formatter;

import java.io.BufferedReader;
import java.io.Console;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by frankelydiaz on 7/14/15.
 */
public class Main {

    public static final FileEntry[] ENTRIES = {
            new FileEntry("", Separator.COMMA),
            new FileEntry("", Separator.PIPE),
            new FileEntry("", Separator.SPACE),
    };

    public static void main(String[] args) throws IOException {

        setUpArguments(args);

        start();
    }

    public static void start() {
        List<Person> persons = new ArrayList<Person>();

        for (FileEntry fileEntry : ENTRIES) {
            persons.addAll(parseFromFileEntry(fileEntry));
        }

        printOutput1(persons);
        printOutput2(persons);
        printOutput3(persons);
    }

    public static void setUpArguments(String[] args) {

        if (args == null || args.length != ENTRIES.length)
            throw new IllegalArgumentException("You must supply comma, pipe and space file paths");

        for (int i = 0; i < args.length; i++) {
            ENTRIES[i].setFilePath(args[i]);
        }
    }

    public static void printOutput(List<Person> persons, String title, Comparator comparator) {
        System.out.println(title);
        Formatter personFormatter = new PersonFormatter();

        Collections.sort(persons, comparator);

        for (Person person : persons) {
            System.out.println(personFormatter.format(person));
        }
        System.out.println();

    }

    public static void printOutput1(List<Person> persons) {
        printOutput(persons, "Output 1:", new GenderComparator());
    }

    public static void printOutput2(List<Person> persons) {
        printOutput(persons, "Output 2:", new DateOfBirthComparator());
    }

    public static void printOutput3(List<Person> persons) {
        printOutput(persons, "Output 3:", new LastNameDescendingComparator());
    }

    public static List<Person> parseFromFileEntry(FileEntry fileEntry) {
        List<Person> persons = new ArrayList<Person>();
        ParserConfiguration parserConfiguration = ParserConfigurationFactory.newInstance(fileEntry.getSeparator());

        StringParser<Person> parser = StringParser.fromParserConfiguration(parserConfiguration);


        BufferedReader br;
        br = null;
        String sCurrentLine;
        try {

            br = new BufferedReader(new FileReader(fileEntry.getFilePath()));

            while ((sCurrentLine = br.readLine()) != null) {
                persons.add(parser.parse(sCurrentLine));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        return persons;
    }
}

class FileEntry {
    private String filePath;
    private Separator separator;


    FileEntry(String filePath, Separator separator) {
        this.filePath = filePath;
        this.separator = separator;
    }

    public String getFilePath() {
        return filePath;
    }

    public Separator getSeparator() {
        return separator;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}