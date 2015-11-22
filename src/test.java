import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import jdk.internal.org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.swing.text.Document;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.helpers.AbstractUnmarshallerImpl;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Moritz on 22.11.2015.
 */
public class test {

    private final String USER_AGENT = "Mozilla/5.0";

    private Wetter sendGet() throws Exception {

        String url = "http://api.wetter.com/forecast/weather/city/DE0001020/project/hsreutlingenqm/cs/f5d68f9f3c301672473d8c61dd69965a";

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();





        String xmlSource = response.toString();

        String name = xmlSource.substring(xmlSource.indexOf("<name>")+6, xmlSource.indexOf("</name>"));
        int PLZ = Integer.parseInt(xmlSource.substring(xmlSource.indexOf("<post_code>")+11, xmlSource.indexOf("</post_code>")));
        int mintemp = Integer.parseInt(xmlSource.substring(xmlSource.indexOf("<tn>")+4, xmlSource.indexOf("</tn>")));
        int maxtemp = Integer.parseInt(xmlSource.substring(xmlSource.indexOf("<tx>")+4, xmlSource.indexOf("</tx>")));
        String date = xmlSource.substring(xmlSource.indexOf("<date value=")+13, xmlSource.indexOf("<date value=")+23);

        date = (date.substring(8,10)+"-"+date.substring(5,7)+"-"+date.substring(0,4));

        System.out.println(name);
        System.out.println(PLZ);
        System.out.println(mintemp);
        System.out.println(maxtemp);
        System.out.println(date);

        int temp = (mintemp+maxtemp)/2;

        Wetter w = new Wetter(name, PLZ, temp, date);

        //print result
        System.out.println(xmlSource);

        return w;
    }
    public static void main(String[]args) {

        test http = new test();

        System.out.println("Testing 1 - Send Http GET request");
        try {
            Wetter wettertest = http.sendGet();
            System.out.println(wettertest.getName());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
