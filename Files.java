import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Files {

    private ArrayList<String> files = null;

    ArrayList<String> getFiles(Scanner in) throws IOException {
        try {
            System.out.println("Enter filenames as space separated.");

            String stringFileNames = in.nextLine();
            String[] filesArr = stringFileNames.split(" ");
            files = new ArrayList<>(Arrays.asList(filesArr));
        } catch (Exception e) {
            e.getStackTrace();
        }
        return files;
    }
}
