package worldofzuul;
import java.io.*;
public class Quiz {
    private void createFile(){
        try{
            File obj = new File("Answers.txt");
            }
        catch(Exception e) {
            System.out.println("Der er opstået en fejl");
            e.printStackTrace();
        }
    }
    private void startQuiz(){
        boolean b = false;
        int i = 1;
        System.out.println("Dette er en quiz som tester din viden om dette emne.");
        System.out.println("Denne quiz fremkommer også igen efter spillet er slut.");
    }
    private void getAnswer(String s){
        int i;
        boolean b = false;
        while(b=false) {
            try {
                i = Integer.parseInt(s);
                b=true;
            } catch (Exception e) {
                System.out.println("Ikke et validt tal, prøv igen.");
            }
        }

    }
}
