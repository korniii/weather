import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Moritz on 24.11.2015.
 */
public class ArrayTest {

    public static void main(String[]args) throws Exception {

        CityCode test = new CityCode();
        //Gross-/Kleinschreibung ist bei den Städtennamen wichtig

        ArrayList<Weather> wetterListe = new ArrayList<Weather>();

        CSVReader reader = new CSVReader(new FileReader("lib/OpenGeoDB_bundesland_plz_ort_de.csv"));

        //TODO: Bricht bei dem Nachfolger der PLZ = 79429 ab.
        List<String[]> PLZArray = reader.readAll();
        for (String[] PLZ : PLZArray){



            //for Schleife über alle Städte abhier beginnen
            String code = test.getCityCode(PLZ[0]);

            if (code != null) {

                //System.out.println("Get City Code:");
                WeatherRequester http = new WeatherRequester();

                //System.out.println("Get Weather:");
                try {
                    Weather wettertest = http.getWeather(code);

                    System.out.println(wettertest+"\n");

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
