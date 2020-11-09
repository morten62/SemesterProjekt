package worldofzuul;
import java.util.ArrayList;
public class Library extends Room {
    private ArrayList<Article> articles = new ArrayList<Article>(); //en arraylist til artiklerne som er her på bibloteket
    public Library(String description, ArrayList<Article> articles) { //Constructer som viser en beskrivelse og artiklen.
        super(description);
        this.articles = articles;
    }
}