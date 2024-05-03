import java.awt.image.DataBufferDouble;
import java.io.*;
import java.net.Socket;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.HashMap;

public class GameLogic implements Runnable{
    private Socket socket;

    public GameLogic(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        GameManager manager = new GameManager(new ArrayList<>());
        ArrayList<String> options = new ArrayList<>();
        Boolean managerInitialized = false;
        try(
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        ) {
            String line;
            while((line = br.readLine()) != null){
                String[] input = line.split(" ");
                if("EXIT".equals(input[0])){
                    break;
                }
                else if("Start".equals(input[0])){
                    options = new OptionsLoader().load(input[1]);
                    manager = new GameManager(options);
                    managerInitialized = true;
                    bw.write("Auswahlmöglichkeiten: " + options);
                }
                else if ("Play".equals(input[0]) && managerInitialized){
                    if(options.contains(input[1])){
                        bw.write(manager.getWinner(input[1]));
                    }
                    else {
                        bw.write("Auswahlmöglichkeiten: " + options);
                    }
                }
                else if ("Stats".equals(input[0]) && managerInitialized){
                    HashMap<String, Integer> stats = manager.getGameStats();
                    bw.write("Spieler: "+stats.get("Spieler") + " Siege");
                    bw.newLine();
                    bw.write("Computer: "+stats.get("Computer") + " Siege");
                }
                else if ("Play".equals(input[0]) && managerInitialized == false){
                    bw.write("Fehler: Bitte zuerst Datei laden");
                }
                else if ("Stats".equals(input[0]) && managerInitialized == false){
                    bw.write("Fehler: Bitte zuerst Datei laden");
                }
                else {
                    bw.write("Fehlerhafte Eingabe");
                }

                bw.newLine();
                bw.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (OptionsLoadException e) {
            throw new RuntimeException(e);
        }

    }
}
