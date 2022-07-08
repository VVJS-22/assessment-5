import java.io.FileNotFoundException;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class Main extends Thread {

    static String[] b = {"consectetur", "vulputate", "morbi", "Quam", "pharetra", "condimentum", "sadasdasdasd"};
    static HashSet<String> c = null;

    String fileName = null;

    protected Main (String file) {
        fileName = file;
    }

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

    public void run() {

            try {
                Main.searchInFile(fileName);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    public static void main(String[] args) throws ArrayIndexOutOfBoundsException, FileNotFoundException, IOException, InterruptedException {

        // String[] a = {"consectetur", "vulputate", "morbi", "Quam", "pharetra", "condimentum", "sadasdasdasd"};
        // b = new ArrayList<String>();
        // b.addAll(Arrays.asList(a));
        c = new HashSet<>();

        Main t1 = new Main("sample.txt");
        Main t2 = new Main("sample2.txt");
        Main t3 = new Main("sample3.txt");

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();
    }
}
