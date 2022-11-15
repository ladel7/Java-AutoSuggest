/**
 * Lucy Adelson (ema53)
 * AutoSuggest class that suggests complete words based on partial words that a user inputs
 */
import java.util.*;

public class AutoSuggest{
    private static String typedLetters; //letters/partial word that user inputs

    /**
     * constructor that takes input String and assigns it to field typedLetters
     * @param type String that the user inputs
     */
    public AutoSuggest(String type){

        typedLetters = type;
    }

    /**
     * creates Dictionary object and sees if the dictionary contains the letter combinations
     * if it contains the letter combination the user inputs, then returns list of suggestions
     * @return String of list of suggested words
     */
    public static String suggestion(){
        Dictionary di = new Dictionary();
        boolean contain = di.contains(typedLetters);
        if(contain){
           return di.getSuggestion(typedLetters);
        }
        else{
            return null;
        }

    }


    /**
     * main method that prompts user to type letters or a partial word
     * prints list of suggested words based on user input
     * @param args String
     */
    public static void main(String[] args){
        System.out.println("Type partial word here: ");
        Scanner sc = new Scanner(System.in);
        String type = sc.next();
        type = type.toLowerCase();

        AutoSuggest a = new AutoSuggest(type);

        if(a.suggestion() != null){
            System.out.println("Suggested words:");
            System.out.println(a.suggestion());
        }
        else{
            System.out.println("Sorry, there are no suggested words.");
        }


    }

}
