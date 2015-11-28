import javafx.beans.binding.MapBinding;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Moritz on 27.11.2015.
 */
public class ArrayBuilderTest {

    public static void main(String[]args) throws Exception {

        ArrayBuilder a1 = new ArrayBuilder();
        HashMap<String, Weather> test = a1.getWetterList();
        System.out.println("Alle Wetterdaten erhalten.");

        for(String wetter : test.keySet()){
            System.out.println("-----------------");
            System.out.println(test.get(wetter));
        }

        System.out.println(a1.getErrorPLZ().size());


    }

}
