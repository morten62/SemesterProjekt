package worldofzuul;

public class Game 
{
    private worldofzuul.Parser parser;
    private Room currentRoom;
        

    public Game() 
    {
        createRooms();
        parser = new worldofzuul.Parser();
    }


    private void createRooms()
    {
        Room start, cityCenter, library, wellSite, street, blacksmith, carpenter, egdeOfCity, mechanic, riverbank;
        start = new Room("Du er i dit hus og overvejer hvordan du skal løse byens vand problem");
        cityCenter = new Room("Du er i by centeret");
        library = new Room("Du er i byens bibliotek, her burde du kunne finde alt den nødvendige viden for at løse dit problem");
        wellSite = new Room("Det her er et perfekt sted for at bygge en brøn");
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
            // printInventory();
        }
        else if (commandWord == CommandWord.QUIT) {
            wantToQuit = quit(command);
        }

        return wantToQuit;
    }

    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }
    private void getItem(Command command)
    {
        if(!command.hasSecondWord()) {
            System.out.println("Tag hvad?");
            return;
        }

        String item = command.getSecondWord();
/*
        Item nItem = currentRoom.getItem(item); // #¤# takes a string with the name of an item in the room and returns
                                                // the item to be made in room

        if (nItem == null) {
            System.out.println("Det er ikke her!");
        }
        else {
            inventory.addToInventory(nItem);     // #¤# add to inventory needs to be made
            currentRoom.inventory.remove(nItem); // #¤# removes item from the room
        }
 */
    }
    private void putItem(Command command)
    {
        if(!command.hasSecondWord()) {
            System.out.println("Læg hvad?");
            return;
        }

        String item = command.getSecondWord();
/*
        Item nItem = inventory.getItem(item); // #¤# takes a string with the name of an item in the inventor and returns
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
