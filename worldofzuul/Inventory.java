package worldofzuul;
import java.util.ArrayList;

public class Inventory {
    public ArrayList<Item> inventory = new ArrayList<Item>();

    //add item and it will be placed last in the list
    public void addToInventory(Item item){
        inventory.add(item);
    }

    //takes a string and removes the first from list where the name fits the input
    public void removeFromInventory(String name){
        try {
            for (int i = 0; inventory.size() < i; i++){
                if (inventory[i].name == name){
                    inventory.remove(i);
                    break;
                }
            }
        }
        catch (Exception e){
            System.out.println("\nThere is no items to remove from the inventory!\n");
        }
    }

    //removes the first item which is identical
    public void removeFromInventory(Item item){
        try {
            for (int i = 0; inventory.size() < i; i++){
                if (inventory[i] == item){
                    inventory.remove(i);
                    break;
                }
            }
        }
        catch (Exception e){
            System.out.println("\nThere is no items to remove from the inventory");
        }
    }

    //removes item by index
    public void removeFromInventory(int item){
        try {
            inventory.remove(item);
        }
        catch (Exception e){
            System.out.println("\nThere is no items to remove from the inventory");
        }
    }
}
