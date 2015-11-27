import com.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Moritz on 27.11.2015.
 */
public class ArrayBuilder {

    String csvDat = "lib/OpenGeoDB_bundesland_plz_ort_de.csv";
    CityCode test = new CityCode();
    List<String[]> PLZArray;
    ArrayList<Weather> wetterListe = new ArrayList<Weather>();


    public ArrayBuilder() throws IOException {
        CityCode test = this.test;
        ArrayList<Weather> wetterListe = this.wetterListe;

    }

    public List<Weather> getWetterList() throws Exception {

        CSVReader reader = new CSVReader(new FileReader(this.csvDat));
        List<String[]> PLZArray = this.PLZArray;
        PLZArray = reader.readAll();
        //TODO: Bricht bei dem Nachfolger der PLZ = 79429 ab.
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

                    if (!wettertest.getError()) {

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


    return wetterListe;
    }



    }


