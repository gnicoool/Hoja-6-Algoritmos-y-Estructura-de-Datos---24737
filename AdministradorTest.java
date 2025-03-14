import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.Map;
public class AdministradorTest {
    @Test
    public void testLeerPokemon() throws Exception {
        String archivoCSV = "pokemon_data_pokeapi.csv"; 
        Administrador admin = new Administrador();
        MapFactory factory = new MapFactory();

        Map<String, Pokemon> mapa = admin.leerPokemon(archivoCSV, "HashMap", factory);
        assertNotNull(mapa);
        assertFalse(mapa.isEmpty());
        assertTrue(mapa.containsKey("Charizard"));
        Pokemon Charizard = mapa.get("Charizard");
        assertEquals(6, Charizard.getPokedexNumber());
        assertEquals("Fire", Charizard.getType1());
        assertEquals("Flying", Charizard.getType2());
    }

    @Test
    public void testBuscarHabilidad(){
        String archivoCSV = "pokemon_data_pokeapi.csv";
        Administrador admin = new Administrador();
        MapFactory factory = new MapFactory();
        Map<String, Pokemon> mapa = admin.leerPokemon(archivoCSV, "HashMap", factory);
        
        List<Pokemon> resultados = new java.util.ArrayList<>();
        String habilidadBuscada = "Blaze";
        for (Pokemon pokemon : mapa.values()) {
            if (pokemon.getAbility().contains(habilidadBuscada)) {
                resultados.add(pokemon);
            }
        }
        assertFalse(resultados.isEmpty());
        assertTrue(resultados.stream().anyMatch(p -> p.getName().equals("Charmeleon")));
    }
}
