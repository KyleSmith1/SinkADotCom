package dotcombust;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * @author 14001835
 */
public class DotComBust {

    private GameHelper helper = new GameHelper();
    ArrayList<DotCom> dotComsList = new ArrayList<DotCom>();
    ArrayList<String> locations = new ArrayList<>();
    int numOfGuesses = 0;

    private void setUpGame() {
        DotCom dot1 = new DotCom();
        DotCom dot2 = new DotCom();
        DotCom dot3 = new DotCom();

        dot1.setName("Go2.com");
        dot2.setName("Pets.com");
        dot3.setName("AskMe.com");

        dotComsList.add(dot1);
        dotComsList.add(dot2);
        dotComsList.add(dot3);

        for (DotCom dotComToSet : dotComsList) {
            ArrayList<String> newLocation = helper.placeDotCom(3);
            dotComToSet.setLocationCells(newLocation);
        }
    }

    private void startPlaying() {
        while (!dotComsList.isEmpty()) {
            String userGuess = helper.getUserInput("Enter a guess ");
            checkUserGuess(userGuess);
        }
        finishGame();
    }

    private void checkUserGuess(String userGuess) {
        numOfGuesses++;
        String result = "miss";

        for (DotCom dotComToTest : dotComsList) {
            result = dotComToTest.checkYourself(userGuess);
            if (result.equals("hit")) {
                break;
            }
            if (result.equals("kill")) {
                dotComsList.remove(dotComToTest);
                break;
            }
        }
        System.out.println(result);

    }

    private void finishGame() {
        System.out.println("All Dot Coms are dead!");
        if(numOfGuesses < 11){
            System.out.println("That was good!");
            System.out.println("Number of guesses: " + numOfGuesses); 
        }
        else{
            System.out.println("That was bad!");
            System.out.println("Number of guesses: " + numOfGuesses);
        }
        
    }
    
    public static void main (String[] args){
        DotComBust game = new DotComBust();
        game.setUpGame();
        game.startPlaying();
    }

}
