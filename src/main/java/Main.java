import me.frankelydiaz.simpleparser.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by frankelydiaz on 7/14/15.
 */
public class Main {

    public static final FileEntry[] ENTRIES = {
            new FileEntry("/Users/frankelydiaz/Desktop/codetest_files/input_files/comma.txt", Separator.COMMA),
            new FileEntry("/Users/frankelydiaz/Desktop/codetest_files/input_files/pipe.txt", Separator.PIPE),
            new FileEntry("/Users/frankelydiaz/Desktop/codetest_files/input_files/space.txt", Separator.SPACE),
    };

    public static void main(String[] args) throws IOException {

        List<Person> persons = new ArrayList<Person>();


        for (FileEntry fileEntry : ENTRIES) {
           persons.addAll(parseFromFileEntry(fileEntry));
        }
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
}
