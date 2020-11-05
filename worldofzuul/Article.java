package worldofzuul;

public class Article extends Items {

    public Article(String name, String description) {

        super(name, description);
    }


    Article wellArticle = new Article("Artikel om brønde",
            "Selve artiklen. Graves. Åben/Lukket. Pumper");
    Article liningArticle = new Article("Artikel om foring",
            "Selve artiklen. Omhandler de tre typer af foring, og deres fordele og ulepmer");
    Article pumpArticle = new Article("Artikel om pumper",
            "Selve artiklen. Omhandler de forskellige pumper.");
    Article wellPlacement = new Article("working title Artikel om brøndsteder",
            "Omhandler hvilke steder det er godt at placere brønde.");

}
