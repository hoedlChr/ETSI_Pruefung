import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class OptionsLoader {
    public static ArrayList<String> load(String path) throws OptionsLoadException {
        ArrayList<String> returnValue = new ArrayList<>();

        try(
                BufferedReader br = new BufferedReader(new FileReader(path))
        ){
            String line;
            while((line = br.readLine()) != null){
                returnValue.add(line);
            }
        } catch (FileNotFoundException e) {
            throw new OptionsLoadException("Datei wurde nicht gefunden",e);
        } catch (IOException e) {
            throw new OptionsLoadException(e);
        }

        return returnValue;
    }

    public static ArrayList<String> load(String path, Comparator<String> yourComparator) throws OptionsLoadException {
        ArrayList<String> returnValue = load(path);

        Collections.sort(returnValue, yourComparator);
        return returnValue;
    }
}
