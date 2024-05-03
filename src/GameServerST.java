import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class GameServerST {

    public static void main(String[] args) {
        try (
            ServerSocket myServer = new ServerSocket(8000);
        ){
            System.out.println("Server gestartet");
            while(true){
                Socket player = myServer.accept();
//                System.out.println("Spieler verbunden");
                GameLogic logic = new GameLogic(player);
//                logic.run();
               Thread th = new Thread(logic);
               th.start();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
