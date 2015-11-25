import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Created by Moritz on 24.11.2015.
 */
public class CsvReader {

    public static void main(String[]args) throws IOException {

        CSVReader reader = new CSVReader(new FileReader("D:/OpenGeoDB_bundesland_plz_ort_de.csv"));
        String [] PLZ;
        while ((PLZ = reader.readNext()) != null) {
            // nextLine[] is an array of values from the line
            System.out.println(PLZ[0]);
        }


    }
}
