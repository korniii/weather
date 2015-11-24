/**
 * Created by Moritz on 22.11.2015.
 */
public class Weather {

    String name;
    int PLZ;
    int temp;
    String date;

    public Weather(String name, int PLZ, int temp, String date) {
        this.name = name;
        this.PLZ = PLZ;
        this.temp = temp;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public int getPLZ() {
        return PLZ;
    }

    public int getTemp() {
        return temp;
    }
    
    public String toString(){
    	return ("Name: " + name +"\nPLZ: "+PLZ+"\nTemperatur: "+temp+" °C\nDatum: "+date);
    }
    
    
}