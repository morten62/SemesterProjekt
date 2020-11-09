/**
 * Legal words to use in the game
 *
 *
 * @author Orig. + Morten
 * @version 1.1
 */
package worldofzuul;

public enum CommandWord
{
    GO("gå"), QUIT("quit"), HELP("hjælp"), UNKNOWN("?"),
    PICKUP("tag"), PUTDOWN("læg"), SEEINVENTORY("se"),
    USEITEM("brug"), READ("læs"), FINISH("færdig");
    
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
