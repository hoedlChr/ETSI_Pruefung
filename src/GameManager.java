import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class GameManager {
    private ArrayList<String> options = new ArrayList<>();
    private int playerWins;
    private int computerWins;

    public GameManager(ArrayList<String> options) {
        this.options = options;
        this.playerWins = 0;
        this.computerWins = 0;
    }

    public String getWinner(String playerSelection){
        String pcSelection = options.get(new Random().nextInt(0,3));
        Boolean playerWon = false;
        if(pcSelection.equals(playerSelection)){
            return pcSelection + " vs " + playerSelection + " -> Unentschieden";
        }
        else if ("Stein".equals(playerSelection) && "Schere".equals(pcSelection)){
            playerWins++;
            playerWon = true;
        }
        else if ("Schere".equals(playerSelection) && "Papier".equals(pcSelection)){
            playerWins++;
            playerWon = true;
        }
        else if ("Papier".equals(playerSelection) && "Stein".equals(pcSelection)){
            playerWins++;
            playerWon = true;
        }
//        else if ("Stein".equals(pcSelection) && "Schere".equals(playerSelection)){
//            computerWins++;
//        }
//        else if ("Schere".equals(pcSelection) && "Papier".equals(playerSelection)){
//            computerWins++;
//        }
//        else if ("Papier".equals(pcSelection) && "Stein".equals(playerSelection)){
//            computerWins++;
//        }
        if(playerWon){
            return playerSelection + " schlägt " + pcSelection + " -> Spieler gewinnt";
        }
        computerWins++;
        return pcSelection + " schlägt " + playerSelection + " -> Computer gewinnt";
    }

    public HashMap<String, Integer> getGameStats(){
        HashMap<String, Integer> myHash = new HashMap<>();
        myHash.put("Spieler", playerWins);
        myHash.put("Computer", computerWins);
        return myHash;
    }
}
