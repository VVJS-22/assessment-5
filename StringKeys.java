import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class StringKeys {

    private ArrayList<String> keys = null;

    ArrayList<String> read(Scanner in) throws IOException {
        try {
            System.out.println("Enter strings to be searched as space separated.");

            String stringKeys = in.nextLine();
            String[] keysArr = stringKeys.split(" ");
            keys = new ArrayList<>(Arrays.asList(keysArr));
        } catch (Exception e) {
            e.getStackTrace();
        }
        return keys;
    }
}
