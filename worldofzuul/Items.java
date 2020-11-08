package worldofzuul;

public class Items{
     String name;
     String description;

    public Items(String name, String description){
        this.name = name;
        this.description = description;

    }

    public String showDescription(){
        return description;

    }
}
