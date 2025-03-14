import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        boolean continuar = true;
        Scanner sc = new Scanner(System.in);
        Administrador admin = new Administrador();
        MapFactory mapFactory = new MapFactory();
        String[] opciones = {"HashMap", "TreeMap", "LinkedHashMap"};
        
        System.out.println("----- Colección de Pokémon -----");
        System.out.println("Seleccione el tipo de mapa que desea utilizar:");
        for (int i = 0; i < opciones.length; i++) {
            System.out.println((i+1) + ". " + opciones[i]);
        }
        int opcion = sc.nextInt();
        Map<String, Pokemon> mapa = admin.leerPokemon("pokemon_data_pokeapi.csv", opciones[opcion], mapFactory);
        TreeMap<String, Pokemon> coleccion = new TreeMap<>();

        while (continuar) {
            System.out.println();
            System.out.println("----- Menú -----");
            System.out.println("1. Agregar Pokémon a la colección");
            System.out.println("2. Buscar y mostrar datos de un Pokémon");
            System.out.println("3. Mostrar Pokémones de la coleccion");
            System.out.println("4. Mostrar todos los Pokemones");
            System.out.println("5. Buscar Pokémones segun habilidad");
            System.out.println("6. Salir");
            int opcionMenu = sc.nextInt();
            sc.nextLine();
            String name;
            switch (opcionMenu) {
                case 1:/*Agregar pokemon a la coleccion del usuario */
                    System.out.println("Ingrese el nombre del Pokémon que desea agregar:");
                    name = sc.nextLine();
                    if (mapa.containsKey(name)) {
                        coleccion.put(name, mapa.get(name));
                        System.out.println("Se ha agregado el Pokémon a la colección");
                    } else if (coleccion.containsKey(name)) {
                        System.out.println("El Pokémon ya se encuentra en la colección");
                    } else {
                        System.out.println("No se encontró el Pokémon");   
                    }
                    break;
                case 2: /*Buscar y mostrar datos de un pokemon especifico ingresado por el usuario*/
                    System.out.println("Ingrese el nombre del Pokémon que desea buscar:");
                    name = sc.nextLine();
                    if (mapa.containsKey(name)) {
                        Pokemon pokemon = mapa.get(name);
                        System.out.println();
                        System.out.println("Nombre: " + pokemon.getName());
                        System.out.println("Pokédex: " + pokemon.getPokedexNumber());
                        System.out.println("Tipo 1: " + pokemon.getType1());
                        System.out.println("Tipo 2: " + pokemon.getType2());
                        System.out.println("Clasificación: " + pokemon.getClassification());
                        System.out.println("Altura: " + pokemon.getHeight());
                        System.out.println("Peso: " + pokemon.getWeight());
                        System.out.println("Habilidades: " + pokemon.getAbility());
                        System.out.println("Generación: " + pokemon.getGeneration());
                        System.out.println("Legendario: " + pokemon.getIsLegendary());
                    } else {
                        System.out.println("No se encontró el Pokémon");
                    }
                    break;
                case 3: /*Mostrar los pokemones de la coleccion del usuario, unicamente muestra nombre y  tipo 1*/
                    System.out.println("----- Colección de Pokémones -----");
                    if (!coleccion.isEmpty()) {
                        List<Pokemon> pokeOrden = new ArrayList<>(coleccion.values());
                        Collections.sort(pokeOrden, Comparator.comparing(Pokemon::getType1));
                        for (Pokemon pokemon : pokeOrden) {
                            System.out.println("Nombre: " + pokemon.getName() + " Tipo: " + pokemon.getType1());
                        }
                    } else {
                        System.out.println("La colección está vacía");
                    }
                    break;
                case 4:/*Muestra todos los pokemones que existen en el map, muestra unicamente nombre  y tipo 1 */
                    System.out.println("----- Todos los Pokémones -----");
                    if (!mapa.isEmpty()) {
                        List<Pokemon> pokeOrden = new ArrayList<>(mapa.values());
                        Collections.sort(pokeOrden, Comparator.comparing(Pokemon::getType1));
                        for (Pokemon pokemon : pokeOrden) {
                            System.out.println("Nombre: " + pokemon.getName() + " Tipo: " + pokemon.getType1());
                        }
                    } else {
                        System.out.println("No hay Pokémones");
                        
                    }
                    break;

                case 5:/*Busca y muestra los pokemones con una habilidad especifica ingresada por el usuario, solo muestra  el nombre */
                    System.out.println("Ingrese la habilidad que desea buscar:");
                    String ability = sc.nextLine();
                    boolean encontrado = false;
                    Collection<Pokemon> pokemones = mapa.values();
                    for (Pokemon pokemon : pokemones) {
                        if (pokemon.getAbility().contains(ability)) {
                            System.out.println("Nombre: " + pokemon.getName());
                            encontrado = true;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("No se encontraron Pokémones con esa habilidad");
                    }
                    break;

                case 6:
                    System.out.println("Saliendo del programa");
                    sc.close();
                    continuar = false;
                    return;
                default:
                    System.out.println("Ingrese una opcion valida, entre 1 y 6");
                    break;
            }
        }
        sc.close();
    }
}