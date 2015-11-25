import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Moritz on 24.11.2015.
 */
public class ArrayTest {

    public static void main(String[]args) throws Exception {

        CityCode test = new CityCode();
        //Gross-/Kleinschreibung ist bei den Städtennamen wichtig

        ArrayList<Weather> wetterListe = new ArrayList<Weather>();

        CSVReader reader = new CSVReader(new FileReader("D:/OpenGeoDB_bundesland_plz_ort_de.csv"));
        String [] PLZ;
        while((PLZ = reader.readNext()) != null) {

            PLZ = reader.readNext();

            //for Schleife über alle Städte abhier beginnen
            String code = test.getCityCode(PLZ[0]);

            if (code != null) {

                //System.out.println("Get City Code:");
                WeatherRequester http = new WeatherRequester();

                //System.out.println("Get Weather:");
                try {
                    Weather wettertest = http.getWeather(code);

                    System.out.println(wettertest);

                    if (wettertest.getError() == false) {

                        wetterListe.add(wettertest);
                        //System.out.println(wetterListe.get(wetterListe.size()-1));
                        //System.out.println(wettertest.getError());
                    }


                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println(wetterListe.size());

                }

            }

            else System.out.println("Keine Wetterstation gefunden");

        }

        System.out.println(wetterListe.size());


    }

}
