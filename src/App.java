import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class App {

    public static void main(String[] args) throws Exception {
        Random r = new Random();

        Scanner s = new Scanner(System.in);
        int lives = 6;

        String[] words = getWords();
        String ans = words[r.nextInt(words.length)];

        ArrayList<String> l = new ArrayList<String>();
        
        String[] letters = ans.split("");
        String[] display = new String[ans.length()];
        for (int m = 0; m < ans.length(); m++){
            display[m] = "_";
        }

        while (lives > 0 && !checker(display)) {
            Boolean correct =  false;
            printboard(lives, display);
            System.out.println(ans);
            System.out.println("Word Bank: " + (l));
            System.out.print("Enter a letter: ");
            String input = s.nextLine();

            l.add(input);
            
            for (int n = 0; n < ans.length(); n++){
    
                if (letters[n].equals(input)){
                    display[n] = input;
                    correct = true;
                    
                }
                
            }    
            if (!correct){
                lives--;
            }   
        }
        if (lives == 0){
            System.out.println("You failed.");
        }
        else{
            System.out.println("You didn't fail.");
        }
        
    }


    public static void printboard(int lives, String[] word) {
        String[] victim = new String[] { "O", "|", "/", "\\", "/", "\\" };

        String[] temp = new String[] { "", "", "", "", "", "" };

        for (int i = 0; i < (6 - lives); i++)
            temp[i] = victim[i];

        System.out.println("----------");
        System.out.println("         |");
        System.out.println("         " + temp[0]);
        System.out.println("        " + temp[2] + temp[1] + temp[3]);
        System.out.println("        " + temp[4] + " " + temp[5]);
        System.out.println();
        System.out.println(String.join(" ", word));
    }

    public static String[] getWords() throws Exception {
        BufferedReader b = new BufferedReader(new FileReader("src/words.txt"));
        String[] words = new String[9892];
        int i = 0;
        String s = b.readLine();
        
        while (s != null) {
            words[i] = s;
            i++;
            s = b.readLine();
        }
       return words;
    }

    public static boolean checker(String[] display){
        for(String s:display){
            if (s.equals("_")){
                return false;
            }
        }
        return true;
    }
}

/*
 * all code needs class, one public class per file
 * oop = object orientated programming (JAVA) - using class to create the object
 * Four Pillars of Oop: Abstraction, Encapsulation, Inheritance, Polymorphism =
 * BLUEPRINTING
 * everything inside, "public static void main(String[] args)" in class;
 * everything inside will run
 */