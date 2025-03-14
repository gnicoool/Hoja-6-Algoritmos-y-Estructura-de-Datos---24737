import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Administrador {

    /*Lectura de csv y carga  de datos a un Map
     * @param archivo
     * @param tipoMapa
     * @param mapFactory
     * @return Map<String, Pokemon>
     */

    public Map<String, Pokemon> leerPokemon(String archivo, String tipoMapa, MapFactory mapFactory) {

        Map<String, Pokemon> mapa = mapFactory.createMap(tipoMapa);
        try {
            BufferedReader br = new BufferedReader(new FileReader(archivo));
            br.readLine();
            String line;
            while ((line = br.readLine())!= null) {
                List<String> datos = parseCsvLine(line);
                Pokemon pokemon = new Pokemon();
                pokemon.setName(datos.get(0));
                pokemon.setPokedexNumber(Integer.parseInt(datos.get(1)));
                pokemon.setType1(datos.get(2));
                pokemon.setType2(datos.get(3));
                pokemon.setClassification(datos.get(4));
                pokemon.setHeight(Double.parseDouble(datos.get(5)));
                pokemon.setWeight(Double.parseDouble(datos.get(6)));
                String abilitiesStr = datos.get(7);
                if (abilitiesStr.startsWith("\"") && abilitiesStr.endsWith("\"")) {
                    abilitiesStr = abilitiesStr.substring(1, abilitiesStr.length() - 1);
                }
                String[] abilitiesArray = abilitiesStr.split(",");
                List<String> abilitiesList = new ArrayList<>();
                for (String ability : abilitiesArray) {
                    abilitiesList.add(ability.trim());
                }
                pokemon.setAbility(abilitiesList);
                pokemon.setGeneration(Integer.parseInt(datos.get(8)));
                pokemon.setIsLegendary(Boolean.parseBoolean(datos.get(9)));

                mapa.put(pokemon.getName(), pokemon);
            }
            br.close();
        } catch (IOException e) {
            System.err.println("Error al leer el archivo " + e.getMessage());
            e.printStackTrace();
        }
        return mapa;
    }

    /*Separa informacion del csv por comas 
     * @param line
     * @return List<String>
    */
    private List<String> parseCsvLine(String line) {
        List<String> result = new ArrayList<>();
        boolean inQuotes = false;
        StringBuilder field = new StringBuilder();
        
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c == '"') {
                inQuotes = !inQuotes;
            } else if (c == ',' && !inQuotes) {
                result.add(field.toString());
                field.setLength(0);
            } else {
                field.append(c);
            }
        }
        result.add(field.toString());
        return result;
    }
}
