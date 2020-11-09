package worldofzuul;

/**
 *  This class is used to create the objects the user can interact with
 * @author Mike
 * @version 1.0
 */
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
