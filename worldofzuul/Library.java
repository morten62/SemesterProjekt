package worldofzuul;
import java.util.ArrayList;
public class Library extends Room {
    //en arraylist til artiklerne som er her på bibloteket
    private ArrayList<Article> articles = new ArrayList<Article>();
    //Constructer som viser en beskrivelse og artiklen.
    public Library(String description, ArrayList<Article> articles) {
        super(description);
        this.articles = articles;
    }
    public void readArticle(Article readArticle){
        System.out.println("Dette er artiklen fra bibloteket" + " " + readArticle.description);
    }
}