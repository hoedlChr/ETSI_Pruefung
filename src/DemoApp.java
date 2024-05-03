import java.net.Socket;
import java.util.ArrayList;

public class DemoApp {
    public static void main(String[] args) throws OptionsLoadException {
        ArrayList<String> myOptions = new OptionsLoader().load("./files/options.txt", new OptionsComparator());
//        ArrayList<String> myOptions = new OptionsLoader().load("./files/options.txt");
        System.out.println(myOptions);
        GameManager myManager = new GameManager(myOptions);
        System.out.println(myManager.getWinner("Schere"));
        System.out.println(myManager.getWinner("Papier"));
        System.out.println(myManager.getWinner("Stein"));
        System.out.println(myManager.getGameStats());

    }
}
