public class Pokemon {
    String name;
    int pokedexNumber;
    int level;
    String type1;
    String type2;
    String classification;
    double height;
    double weight;
    String ability;
    int generation;
    boolean isLegendary;


    public Pokemon(){}

    /*
     * Constructor de la clase Pokemon con toda la informacion del csv de un pokemon
     */
    public Pokemon(String name, int pokedexNumber, int level, String type1, String type2, String classification, double height,double weight, String ability, int generation, boolean isLegendary){
        this.name = name;
        this.pokedexNumber = pokedexNumber;
        this.level = level;
        this.type1 = type1;
        this.type2 = type2;
        this.classification = classification;
        this.height = height;
        this.weight = weight;
        this.ability = ability;
        this.generation = generation;
        this.isLegendary = isLegendary;
    }
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPokedexNumber() {
        return this.pokedexNumber;
    }

    public void setPokedexNumber(int pokedexNumber) {
        this.pokedexNumber = pokedexNumber;
    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getType1() {
        return this.type1;
    }

    public void setType1(String type1) {
        this.type1 = type1;
    }

    public String getType2() {
        return this.type2;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }

    public String getClassification() {
        return this.classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public double getHeight() {
        return this.height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return this.weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getAbility() {
        return this.ability;
    }

    public void setAbility(String ability) {
        this.ability = ability;
    }

    public int getGeneration() {
        return this.generation;
    }

    public void setGeneration(int generation) {
        this.generation = generation;
    }

    public boolean isIsLegendary() {
        return this.isLegendary;
    }

    public void setIsLegendary(boolean isLegendary) {
        this.isLegendary = isLegendary;
    }

    
    

    


}
