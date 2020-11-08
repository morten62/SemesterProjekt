package worldofzuul;
import java.util.ArrayList;

public class Inventory {
    public static ArrayList<Items> inventory = new ArrayList<Items>();

    //add item and it will be placed last in the list
    public void addToInventory(Items item){
        inventory.add(item);
    }

    //takes a string and removes the first from list where the name fits the input
    public Items removeFromInventory(String name){
        if (!(inventory.size() == 0)) {
            for (int i = 0; inventory.size() < i; i++){
                if (inventory.get(i).name == name){
                    Items items = inventory.get(i);
                    inventory.remove(i);
                    return items;
                }
            }
        }
        else {
            System.out.println("\nDer er ingen ting i din inventar!\n");
        }
        return null;
    }

    //removes the first item which is identical
    public Items removeFromInventory(Items item){
        if (!(inventory.size() == 0)) {
            for (int i = 0; inventory.size() < i; i++){
                if (inventory.get(i) == item){
                    Items items = inventory.get(i);
                    inventory.remove(i);
                    return items;
                }
            }
        }
        else {
            System.out.println("\nDer er ingen ting i din inventar!");
        }
        return null;
    }

    //removes item by index
    public Items removeFromInventory(int item){
        if (!(inventory.size() == 0)){
            try {
                Items items = inventory.get(item);
                inventory.remove(item);
                return items;
            }
            catch (IndexOutOfBoundsException e){
                System.out.println("\nDer er ingen genstand som matcher det tilspurgte index! :: " + e);
            }
        }
        else {
            System.out.println("\nDer er ingen ting i din inventar!");
        }
        return null;
    }

    //print inventory
    public void printInventory(){
        if (inventory.size() != 0){
            for (Items item : inventory){
                System.out.print("\nGenstand: " + item.name + "\nOm genstanden: " + item.description + "\n");
            }
        }
        else {
            System.out.println("\nDer er ingen ting i din inventar!");
        }
    }
}
