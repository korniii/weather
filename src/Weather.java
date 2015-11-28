/**
 * Created by Moritz on 22.11.2015.
 */
public class Weather {

    boolean error;
    String name;
    int PLZ;
    int temp;
    String date;

    public Weather(String name, int PLZ, int temp, String date, boolean error) {
        this.name = name;
        this.PLZ = PLZ;
        this.temp = temp;
        this.date = date;
        this.error = error;
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

    public boolean getError()  {return error;}
    
    public String toString(){
    	return ("Name: " + name +"\nPLZ: "+PLZ+"\nTemperatur: "+temp+" °C\nDatum: "+date+"\n");
    }
    
    
}