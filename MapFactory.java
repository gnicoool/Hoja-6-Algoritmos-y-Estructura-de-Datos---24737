import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.LinkedHashMap;

public class MapFactory {

    /*Creacion de Class Factory para Map
     * @param name
     * @return Map<String, Pokemon>
     */

    public Map<String, Pokemon> createMap(String name) {
        switch (name) {
            case "HashMap":
                return new HashMap<String, Pokemon>();
            case "TreeMap":
                return new TreeMap<String, Pokemon>();
            case "LinkedHashMap":
                return new LinkedHashMap<String, Pokemon>();
            default:
                return null;
        }
    }

}