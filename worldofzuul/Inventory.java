package worldofzuul;
import java.util.ArrayList;

public class Inventory {
    public ArrayList<Items> inventory = new ArrayList<Items>();

    //add item and it will be placed last in the list
    public void addToInventory(Items item){
        inventory.add(item);
    }

    //takes a string and removes the first from list where the name fits the input
    public void removeFromInventory(String name){
        if (!(inventory.size() == 0)) {
            for (int i = 0; inventory.size() < i; i++){
                if (inventory.get(i).name.equals(name)){
                    inventory.remove(i);
                    break;
                }
            }
        }
        else {
            System.out.println("\nDer er ingen ting i din inventar!\n");
        }
    }

    //removes the first item which is identical
    public void removeFromInventory(Items item){
        if (!(inventory.size() == 0)) {
            for (int i = 0; inventory.size() < i; i++){
                if (inventory.get(i) == item){
                    inventory.remove(i);
                    break;
                }
            }
        }
        else {
            System.out.println("\nDer er ingen ting i din inventar!");
        }
    }

    //removes item by index
    public void removeFromInventory(int item){
        if (!(inventory.size() == 0)){
            try {
                inventory.remove(item);
            }
            catch (IndexOutOfBoundsException e){
                System.out.println("\nDer er ingen genstand som matcher det tilspurgte index! :: " + e);
            }
        }
        else {
            System.out.println("\nDer er ingen ting i din inventar!");
        }
    }

    public Items getItemFromInventory(String item){
        if (!(inventory.size() == 0)){
            for (int i = 0; i<inventory.size(); i++) {
                if (inventory.get(i).name.equals(item)) {
                    Items items = inventory.get(i);
                    inventory.remove(i);
                    return items;
                }
                else {

                    return null;
                }
            }

        }
        else {

            return null;
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
