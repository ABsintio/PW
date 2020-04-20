import java.io.*;

public class Parser {

    public static String parse(String filename) {
        String testHTML = "";

        try (FileReader stream = new FileReader(filename)) {
            int next = 0;

            do {
                next = stream.read();
                if (next != -1)
                    testHTML = testHTML.concat(String.valueOf((char) next));
            } while (next != -1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return testHTML;
    }   

}