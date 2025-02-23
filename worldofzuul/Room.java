package worldofzuul;

import java.util.ArrayList;
import java.util.Set;
import java.util.HashMap;

public class Room {
    private String description;
    private HashMap<String, Room> exits;

    public ArrayList<Items> ItemsArrayList = new ArrayList<Items>();

    public Room(String description) {
        this.description = description;
        exits = new HashMap<String, Room>();
    }
    //Jeg har tilføjet Arraylist
    public Room(String description, ArrayList<Items> ItemsArrayList) {
        //Arraylisten vises også når man kommer ind i et rum
        this.ItemsArrayList = ItemsArrayList;
        this.description = description;
        exits = new HashMap<String, Room>();
    }

    public void setExit(String direction, Room neighbor) {
        exits.put(direction, neighbor);
    }

    public String getShortDescription() {
        return description;
    }

    public String getLongDescription() {
        return description + ". " + getExitString();
    }

    private String getExitString() {
        String returnString = "Udgange:";
        Set<String> keys = exits.keySet();
        for (String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }
    public String printExitString(){
        return getExitString();
    }
    public Room getExit(String direction) {
        return exits.get(direction);
    }

    //Metode til at tilføjer genstande til arraylisten
    public void addItem(Items items) {
        ItemsArrayList.add(items);
    }
    //Denne fjerner genstande fra arraylisten
    public Items RemoveItem(String name) {
        //if statement som enten printer "Der er ikke ting i dette rum" ud hvis der er tomt i rummet, eller loopet gennemgåes som vil fjerne en genstand.
        if (!(ItemsArrayList.size() == 0)) {
            for (int i = 0; i<ItemsArrayList.size(); i++) {
                if (ItemsArrayList.get(i).name.equals(name)) {
                    Items items = ItemsArrayList.get(i);
                    ItemsArrayList.remove(i);
                    return items;
                }
            }
        }
        else {System.out.println("Der er ikke ting i dette rum");}
        return null;
    }
    public void PrintItems(){
        if (!(ItemsArrayList.size() == 0))
        {
            System.out.println("Der er følgende ting i dette rum: ");
            for (int i = 0; i<ItemsArrayList.size(); i++)
            {
                System.out.println("   " + ItemsArrayList.get(i).name);
            }
        }
        else
        {
            System.out.println("Der er ikke ting i dette rum");
        }
    }

    public void ReadArticle(String name){
        if (!(ItemsArrayList.size() == 0))
        {
            for (int i = 0; i<ItemsArrayList.size(); i++)
            {
                if(ItemsArrayList.get(i).name.equals(name)){
                    System.out.println(ItemsArrayList.get(i).description);
                }
            }
        }
        else
        {
            System.out.println("Der er ikke ting i dette rum");
        }
    }

    public Items GetItem(String name){
        Items item;
        if (!(ItemsArrayList.size() == 0))
        {
            for (Items items : ItemsArrayList) {
                if (items.name.equals(name)) {
                    return items;
                }
            }
        }
        return null;
     }

}








