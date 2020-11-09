package worldofzuul;
import java.util.ArrayList;
public class Library extends Room {
    private ArrayList<Article> articles = new ArrayList<Article>();
    public Library(String description, ArrayList<Article> articles) {
        super(description);
        this.articles = articles;
    }
    public void readArticle(Article readArticle){
        System.out.println("Dette er artiklen fra bibloteket" + " " + readArticle.description);
    }
}