package worldofzuul;

public class Quiz {

    private String getAnswer(String s){
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
