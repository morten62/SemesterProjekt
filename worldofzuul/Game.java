package worldofzuul;

import java.util.ArrayList;

public class Game
{
    private worldofzuul.Parser parser;
    private Room currentRoom;
    public WellSite wellSite;
    Inventory invent = new Inventory();

    // list of usable items, that can be added to inventory
    Items shovel = new Items("Skovl","Bruges til at grave med.");
    Items bucket = new Items("Spand med reb", "Denne spand har et reb bundet fast til hanken.");
    Items mekPump = new Items("Mekanisk pumpe", "Denne pumpe er mekanisk");
    Items dieselEngine = new Items("Dieselmotor", "Dette er en dieselmotor.");
    Items elEngine = new Items("Elmotor","Dette er en elmotor.");
    Items handPump = new Items("Håndpumpe", "Dette er en pumpe der betjenes med håndkraft.");
    Items planks = new Items("Brædder", "Dette er et sæt brædder.");
    Items liningTree = new Items("Træforing", "Foring lavet af træ.");
    Items liningStone = new Items("Stenforing", "Foring lavet af sten.");
    Items liningBrick = new Items("Murstensforing", "Foring lavet af mursten");
    Items liningConcrete = new Items("Betonforing", "Foring lavet af beton.");

    Article wellArticle = new Article("Artikel om brønde",
            "En brønd er en udgravning i jorden, der kan bruges til at opnå en vandforsyning." +
                    " En brønd kan fores med materialer som træ, sten og beton. Dette kan undlades men vil gøre" +
                    " strukturen ustabil. Der findes forskellige måder at udvinde vandet på. Den mest simple måde" +
                    " er at hente vand op med en spand. Dette kan dog også gøres ved hjælp af en pumpe." +
                    " En brønd kan være åben og lukket. Åbnet er vandforsyningen let tilgængelig, men chancen for" +
                    " forurening er høj. Er en brsønd lukket er det nødvendigt med en pumpe," +
                    " for at etablere en vandforsyning.");
    Article liningArticle = new Article("Artikel om foring",
            "En brønd kan fores med forskellige materialer, der gør strukturen mere stabil og holdbar." +
                    " Nogle af de mest anvendte er træ, sten, mursten, og beton. Træ er et billigt materiale," +
                    " men kan ved ofte kontakt med vand rådne. Sten er et holdbart materiale, men der kan let opstå" +
                    " utætheder. Mursten er lige så holdbar som sten, og med disse undgås utætheder. Dog kan mursten" +
                    " blive slidt ved kontakt med vand. Beton er det mest holdbare materiale, og giver en god " +
                    " struktur. Det er dog også et dyrt materiale.");
    Article pumpArticle = new Article("Artikel om pumper",
            "Den mest hyppige anvendte pumpe er en mekanisk pumpe. Dog er en håndpumpe også stadig anvendt" +
                    " i dag. Den mekaniske pumpe er dyrere end en håndpumpe, og kræver at der er en motor tilsluttet" +
                    " før den kan tages i brug. Dog er denne mere effektiv. Håndpumpen er mindre effektiv en den" +
                    " mekaniske, dog er prisen lavere.");
    Article wellPlacement = new Article("Artikel om brøndplacering",
            "En brønd kan placeres mange steder. Det er oftest bedst at placere brønde, væk fra andre" +
                    " vandkilder, såsom søer og floder, da forurening fra andre kilder kan forværre vandkvaliteten" +
                    " fra brønden. Det kan også være en ulempe at placere en brønd ved foden af en bakke, da" +
                    " spildevand eller lignende kan løbe ned og forurene vandet i brønden. ");
    Article engineArticle = new Article("Artikel om motorer",
            "De to mest anvendte typer af motorer er dieselmotorer, og elmotorer. Prisklassen på disse" +
                    " to typer af motorer er omtrent den samme. Dieselmotoren bruger diesel som brændstof." +
                    " Elmotoren bruger elektricitet for at køre. Dette kan opnås med en tilslutning til en" +
                    " strømkilde, heriblandt er den mest anvendte et batteri.");

    public void useItems(Items items){
        WinCondition winCondition = new WinCondition();
        if (items == shovel){
            wellSite.updateWell(true, (byte)0);
        }
    }

    public Game() 
    {
        createRooms();
        parser = new worldofzuul.Parser();
    }


    private void createRooms()
    {
        ArrayList<Article> articles = new ArrayList<Article>();
        Room start, cityCenter, library, wellSite, street, blacksmith, carpenter, egdeOfCity, mechanic, riverbank;
        start = new Room("Du er i dit hus og overvejer hvordan du skal løse byens vand problem");
        cityCenter = new Room("Du er i by centeret");
        library = new Library("Du er i byens bibliotek, her burde du kunne finde alt den nødvendige viden for at løse dit problem", articles);
        wellSite = new WellSite("Det her er et perfekt sted for at bygge en brøn");
        street = new Room("Du er i en gade som kan føre dig ud til alle butikker som kan give dig de nødvendige ressursor");
        blacksmith = new Room("Du er ved smeden");
        carpenter = new Room("Du er ved tømrene");
        egdeOfCity = new Room("Du er ved udkanten af byen");
        mechanic = new Room("Du er ved mekanikeren");
        riverbank = new Room("Du er ved flodbredden");
        start.setExit("syd", cityCenter);
        cityCenter.setExit("nord", start);
        cityCenter.setExit("vest", library);
        cityCenter.setExit("syd", wellSite);
        cityCenter.setExit("øst", street);
        street.setExit("nord", blacksmith);
        street.setExit("vest", cityCenter);
        street.setExit("syd", carpenter);
        street.setExit("øst", egdeOfCity);
        egdeOfCity.setExit("nord", mechanic);
        egdeOfCity.setExit("vest", street);
        egdeOfCity.setExit("syd", riverbank);
        library.setExit("øst", cityCenter);
        wellSite.setExit("nord", cityCenter);
        blacksmith.setExit("syd", street);
        carpenter.setExit("nord", street);
        mechanic.setExit("syd", egdeOfCity);
        riverbank.setExit("nord", egdeOfCity);
        currentRoom = start;
    }

    public void play() 
    {            
        printWelcome();

                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Tak for at du spillede. Farvel.");
    }

    private void printWelcome()
    {
        System.out.println();
        System.out.println("Velkommen til en fantastisk dag i en brøndgravers hverdag!");
        System.out.println("Dette er et fantastisk spil (eller som nogen siger \"It's great! It's perfect\" )");
        System.out.println("som sidegevinst er det muligt at lære noget om udfordringerne med vand i verdens resourcesvage lande.");
        System.out.println("Skriv '" + CommandWord.HELP + "' hvis du har brug for hjælp.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        if(commandWord == CommandWord.UNKNOWN) {
            System.out.println("Hvad mener du...");
            return false;
        }

        if (commandWord == CommandWord.HELP) {
            printHelp();
        }
        else if (commandWord == CommandWord.GO) {
            goRoom(command);
        }
        else if (commandWord == CommandWord.PICKUP) {
            // Pick up an item ;
            getItem(command);
        }
        else if (commandWord == CommandWord.PUTDOWN) {
            // Puts down a item
            putItem(command);
        }
        else if (commandWord == CommandWord.SEEINVENTORY) {
            // See the inventory
            invent.printInventory();
        }
        else if (commandWord == CommandWord.QUIT) {
            wantToQuit = quit(command);
        }

        return wantToQuit;
    }

    private void printHelp() 
    {
        System.out.println("Du er ganske alene og fortabt og vandrer rundt i byen");
        System.out.println("for at finde de ting som du skal bruge.");
        System.out.println();
        System.out.println("Dine mulige kommandoer er:");
        parser.showCommands();
    }
/*
  getItem()
  Input:   command  obj. containing 2 strings commandWord and secondWord
  Output:  void
  Side-effect: An Item is taken from the room and put in the inventory
*/
    private void getItem(Command command)
    {
        if(!command.hasSecondWord()) {
            System.out.println("Tag hvad?");
            return;
        }

        String itemName = command.getSecondWord();
/*
        Item nItem = currentRoom.getItem(itemName); // #¤# takes a string with the name of an item in the room and returns
                                                // the item to be made in room

        if (nItem == null) {
            System.out.println("Det er ikke her!");
        }
        else {
            inventory.addToInventory(nItem);     // #¤# add to inventory needs to be made
            currentRoom.remove(nItem);           // #¤# removes item from the room
        }
 */
    }
/*
  putItem()
  Input:   command  obj. containing 2 strings commandWord and secondWord
  Output:  void
  Side-effect: An Item is taken from the inventory and put in the room
*/

    private void putItem(Command command)
    {
        if(!command.hasSecondWord()) {
            System.out.println("Læg hvad?");
            return;
        }

        String itemName = command.getSecondWord();
/*
        Item nItem = inventory.getItem(itemName); // #¤# takes a string with the name of an item in the inventory and returns
                                                  // the item, to be made in inventory

        if (nItem == null) {
            System.out.println("Det er ikke i din besidelse!");
        }
        else {
            currentRoom.addToInventory(nItem);   // #¤# add to room, needs to be made
            inventory.removeFromInventory(nItem);// #¤# removes item from the inventory
        }
 */
    }

    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            System.out.println("Gå hvor?");
            return;
        }

        String direction = command.getSecondWord();

        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("Du kan ikke gå den vej!");
        }
        else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
    }

    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit hvad?");
            return false;
        }
        else {
            return true;
        }
    }
}
