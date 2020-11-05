package worldofzuul;

public enum CommandWord
{
    GO("gå"), QUIT("quit"), HELP("hjælp"), UNKNOWN("?"),
    PICKUP("tag"), PUTDOWN("læg"), SEEINVENTORY("se"), USEITEM("brug");
    
    private String commandString;
    
    CommandWord(String commandString)
    {
        this.commandString = commandString;
    }
    
    public String toString()
    {
        return commandString;
    }
}
