package worldofzuul;

public class Items {

     String name;
     String description;

    public Items(String name, String description){
        this.name = name;
        this.description = description;

    }


    public void useItem(){

    }

    public String showDescription(){
        return description;

    }

    // list of usable items, that can be added to inventory
    Items shovel = new Items("Skovl","Bruges til at grave med.");
    Items bucket = new Items("Spand med reb", "Denne spand har et reb bundet fast til hanken.");
    Items mekPump = new Items("Mekanisk pumpe", "Denne pumpe er mekanisk");
    Items engine = new Items("Motor", "Dette er en dieselmotor.");
    Items handPump = new Items("Håndpumpe", "Dette er en pumpe der betjenes med håndkraft.");
    Items planks = new Items("Brædder", "Dette er et sæt brædder.");
    Items liningTree = new Items("Træforing", "Foring lavet af træ.");
    Items liningStone = new Items("Stenforing", "Foring lavet af sten.");
    Items liningConcrete = new Items("Betonforing", "Foring lavet af beton.");



}
