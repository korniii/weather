/**
 * Created by Moritz on 22.11.2015.
 */
public class test {
	
    public static void main(String[] args) throws Exception {
    	
    	CityCode test = new CityCode();
    	//Gross-/Kleinschreibung ist bei den Städtennamen wichtig
    	
    	//for Schleife über alle Städte abhier beginnen
    	String code = test.getCityCode("79539");

    	System.out.println("Get City Code:");
        WeatherRequester http = new WeatherRequester();

        System.out.println("Get Weather:");
        try {
            Weather wettertest = http.getWeather(code);
            System.out.println(wettertest);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    

}