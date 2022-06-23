import java.io.FileNotFoundException;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<String> a = null;
    static ArrayList<String> b = null;
    static HashSet<String> c = null;

    static Scanner in = new Scanner(System.in);

    protected static void searchInFile(String filename) throws FileNotFoundException, IOException {
        File file = null;

        try {
            file = new File(filename);
            try (Scanner fileIn = new Scanner(file)) {
                
                while (fileIn.hasNext()) {
                    String word = fileIn.next();
                    for (String item : b) {
                        if (item.equals(word)) {
                            c.add(item);
                            break;
                        }
                    }
                }
            }
        } finally {
            System.out.println("\n\n" + filename + "\n" + c + "\n\n");
            c.clear();
        }
    }
    public static void main(String[] args) throws ArrayIndexOutOfBoundsException, FileNotFoundException, IOException {

        Files f = new Files();
        StringKeys sk = new StringKeys();

        a = f.getFiles(in);
        b = sk.read(in);
        c = new HashSet<>();

        for (String file : a) {
            Main.searchInFile(file);
        }
    }
}
