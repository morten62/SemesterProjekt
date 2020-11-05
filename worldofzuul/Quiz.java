package worldofzuul;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

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
            System.out.println("Der er opstået en fejl");
            e.printStackTrace();
        }
    }
    // Starter quizzen ved at bestemme om det er før eller efter spillet er færdigt og indsætter resultatet i Answers.txt
    // Quizzen vil så gå igennem en for loop med alle spørgsmålene som er i det String array som bliver defineret her også.
    public void startQuiz(){
        String[] questions = {"Question1", "Question2", "Question3", "Question4", "Question5"};
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
        number++;
        int temp = 1;
        System.out.println("Dette er en quiz som tester din viden om dette emne.");
        System.out.println("Denne quiz fremkommer også igen efter spillet er slut.");
        for(int v = 0; v<5;v++){
             System.out.println("Spørgsmål "+temp+": "+questions[v]);
             getAnswer(v);
            temp++;
        }

    }
    //Indsamler værdien v som beskriver hvad for et spørgsmål det er. Tager næste String som brugerinput og prøver at konverter til int
    //Hvis det fejler køres brugeren igennem den samme process indtil et validt string som kan konverteres til int findes.
    private void getAnswer(int v){
        int i;
        bool = false;
        while(!bool) {
            String s = sc.nextLine();
            try {
                i = Integer.parseInt(s);
                assembleAnswer(i, v);
                bool = true;
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
