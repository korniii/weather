public class WeatherRequester {
	
	private final String projectName = "hsreutlingenqm";


    public Weather getWeather(String city) throws Exception {
    	
    	//MD5 Checksum generieren
    	MD5Hash hashCreator = new MD5Hash(city);
    	String hash = hashCreator.createHash();

    	//Anfragestring zusammenbauen
        String url = "http://api.wetter.com/forecast/weather/city/"+city+"/project/"+projectName+"/cs/"+hash;

        //HTTP Response abfangen
        httpRequester http = new httpRequester();
        String xmlSource = http.getResponse(url);

        //System.out.println(url);

                //errortest
        boolean errortest = false;
        if (xmlSource.contains("<error>")) errortest = true;
        else{

            //Daten aus XML extrahieren
            String name = xmlSource.substring(xmlSource.indexOf("<name>")+6, xmlSource.indexOf("</name>"));
            //Funktioniert im Ausland nicht!!!!
            int PLZ = Integer.parseInt(xmlSource.substring(xmlSource.indexOf("<post_code>")+11, xmlSource.indexOf("</post_code>")));
            int mintemp = Integer.parseInt(xmlSource.substring(xmlSource.indexOf("<tn>")+4, xmlSource.indexOf("</tn>")));
            int maxtemp = Integer.parseInt(xmlSource.substring(xmlSource.indexOf("<tx>")+4, xmlSource.indexOf("</tx>")));
            String date = xmlSource.substring(xmlSource.indexOf("<date value=")+13, xmlSource.indexOf("<date value=")+23);



            date = (date.substring(8,10)+"-"+date.substring(5,7)+"-"+date.substring(0,4));
/*
        System.out.println("Name: "+name);
        System.out.println("PLZ: "+PLZ);
        System.out.println("Minimale Temperatur: "+mintemp);
        System.out.println("Maximale Temperatur: "+maxtemp);
        System.out.println("Datum: "+date);
*/
            //Mittelwert aus den Temperaturen bilden
            int temp = (mintemp+maxtemp)/2;

            return new Weather(name, PLZ, temp, date, errortest);


        }




    return null;}

}
