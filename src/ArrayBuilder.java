import com.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Moritz on 27.11.2015.
 */
public class ArrayBuilder {

    private String csvDat = "lib/OpenGeoDB_bundesland_plz_ort_de.csv";
    private CityCode test = new CityCode();
    private List<String[]> PLZArray;
    private HashMap<String,Weather> wetterListe = new HashMap();
    private ArrayList<String> errorList = new ArrayList<>();


    public ArrayBuilder() throws IOException {
        CityCode test = this.test;
        HashMap<String,Weather> wetterListe = this.wetterListe;

    }

    public HashMap<String,Weather> getWetterList() throws Exception {

        CSVReader reader = new CSVReader(new FileReader(this.csvDat));
        List<String[]> PLZArray;
        PLZArray = reader.readAll();

        for (String[] PLZ : PLZArray){



            String code = test.getCityCode(PLZ[0]);

            if (code != null) {

                WeatherRequester http = new WeatherRequester();

                try {
                    Weather wettertest = http.getWeather(code);


                    if (!wettertest.getError()) {

                        wetterListe.put(PLZ[0],wettertest);
                    }


                } catch (Exception e) {
                    errorList.add(PLZ[0]);
                    System.out.println("Fehler bei PLZ: "+PLZ[0]);

                }

            }

            else System.out.println("Keine Wetterstation gefunden für die PLZ: "+PLZ[0]);

        }

    return wetterListe;

    }

    public List<String> getErrorPLZ(){
        return errorList;
    }



    }


