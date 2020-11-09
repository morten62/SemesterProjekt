package worldofzuul;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Denne klasse laver og fremviser en quiz der tager brugerinput ind og printer ud på et txt dokument
 *
 * @author Rasmus
 * @version 1.1
 */
public class Quiz {
    Scanner sc = new Scanner(System.in);
    FileWriter writeToFile;
    BufferedWriter writer;
    int number=1;
    boolean bool;
    {
        try {
            writeToFile = new FileWriter("Answers.txt");
            writer = new BufferedWriter(writeToFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // Prøver at skabe en txt fil ved navn Answers
    public void createFile(){
        try{
            File obj = new File("Answers.txt");
            }
        catch(Exception e) {
            System.out.println("Der er opstået en fejl: Filen kunne ikke oprettes, eller den eksister allerede");
            e.printStackTrace();
        }
    }

    // Starter quizzen ved at bestemme om det er før eller efter spillet er færdigt og indsætter resultatet i Answers.txt
    // Quizzen vil så gå igennem en for loop med alle spørgsmålene som er i det String array som bliver defineret her også.
    // Quizzen checker om det er første gang eller anden gang den kører igennem denne quiz for at fremvise de rigtige spørgsmål.
    public void startQuiz(){
        String[] questions = {"Vil du mene at din viden af indvinding af rent drikkevand er høj?", "Vil du sige at alle mennesker i verden har lige god mulighed for rent drikkevand?", "Vil du sige at spillet har været med til at forhøje din viden om indvinding af rent drikkevand og dets udfordringer?", "Vil du sige at spillet fremvist at der er nogle steder hvor det ikke er muligt at lave en ordentlig løsning pga. ressource mangler?", "Var spillet sjovt?"};
        if (number==1){
            try {
                writer.write("Svar før spillet:");
                writer.newLine();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Der er opstået en fejl i udskrivning af tegn");
            }

        }
        else if (number==2){
            try {
                writer.write("Svar efter spillet:");
                writer.newLine();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Der er opstået en fejl i udskrivning af tegn");
            }
        }

        int temp = 1;
        System.out.println("Dette er en quiz som tester din viden om dette emne.");
        System.out.println("Denne quiz fremkommer også igen efter spillet er slut, dog med andre spørgsmål.");
        System.out.println("Du har følgende svarmulligheder:");
        System.out.println("1 - Meget uenig");
        System.out.println("2 - Lidt uenig");
        System.out.println("3 - Hverken uenig eller enig/Ved ikke");
        System.out.println("4 - Lidt enig");
        System.out.println("5 - Meget enig");
        if(number==1) {
            for (int v = 0; v < 2; v++) {
                System.out.println("Spørgsmål " + temp + ": " + questions[v]);
                getAnswer(v);
                temp++;
            }
        }
        if(number==2){
            for (int v = 2; v < 5; v++) {
                System.out.println("Spørgsmål " + temp + ": " + questions[v]);
                getAnswer(v);
                temp++;
            }
        }
        number++;
    }
    //Indsamler værdien v som beskriver hvad for et spørgsmål det er. Tager næste String som brugerinput og prøver at konverter til int mellem 1 og 5.
    //Hvis det fejler køres brugeren igennem den samme process indtil et validt string som kan konverteres til int findes.
    private void getAnswer(int v){
        int i;
        bool = false;
        while(!bool) {
            String s = sc.nextLine();
            try {
                i = Integer.parseInt(s);
                if(i>=1 && i<=5) {
                    assembleAnswer(i, v);
                    bool = true;
                }
                else{
                    System.out.println("Du skal svare med et nummer mellem 1 og 5");
                }
            } catch (Exception e) {
                System.out.println("Ikke et validt tal, prøv igen.");
            }
        }
    }
    //Indskriver en String i Answers.txt og laver linjeskift
    private void printAnswer(String s){
        try {
            writer.write(s);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //Samler og formater Stringen som skal indskrives i Answers.txt
    private void assembleAnswer (int i, int v){
        String s = String.valueOf(i);
        String number = String.valueOf(v+1);
        String answer = "Svar til spørgsmål ";
        String semiColon = ": ";
        String fullAnswer = answer+number+semiColon+s;
        printAnswer(fullAnswer);
    }
    //Stopper BufferedWriter
    public void stopWriter(){
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
