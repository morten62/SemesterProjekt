package worldofzuul;

public class Game {
    private worldofzuul.Parser parser;
    private Room currentRoom;
        

    public Game() {
        createRooms();
        parser = new worldofzuul.Parser();
    }

    //the rooms har set up according to the map
    private void createRooms() {
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

        start.setExit("south", cityCenter);
        cityCenter.setExit("north", start);
        cityCenter.setExit("west", library);
        cityCenter.setExit("south", wellSite);
        cityCenter.setExit("east", street);
        street.setExit("north", blacksmith);
        street.setExit("west", cityCenter);
        street.setExit("south", carpenter);
        street.setExit("east", egdeOfCity);
        egdeOfCity.setExit("north", mechanic);
        egdeOfCity.setExit("west", street);
        egdeOfCity.setExit("south", riverbank);
        library.setExit("east", cityCenter);
        wellSite.setExit("north", cityCenter);
        blacksmith.setExit("south", street);
        carpenter.setExit("north", street);
        mechanic.setExit("south", egdeOfCity);
        riverbank.setExit("north", egdeOfCity);

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
        System.out.println("Thank you for playing.  Good bye.");
    }

    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        if(commandWord == CommandWord.UNKNOWN) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        if (commandWord == CommandWord.HELP) {
            printHelp();
        }
        else if (commandWord == CommandWord.GO) {
            goRoom(command);
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

    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
    }

    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;
        }
    }
}
