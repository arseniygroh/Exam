import acm.program.ConsoleProgram;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class EvenPosInString extends ConsoleProgram {
    public void run() {
        evenWords();
    }

    private void evenWords() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("myFile.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                int index = 0;
                int counter = 1;
                while (index < line.length()) {
                    String word = "";

                    while (index < line.length() && !Character.isLetterOrDigit(line.charAt(index))) {
                        index++;
                    }

                    if (index >= line.length()) break;

                    while (index < line.length() && Character.isLetterOrDigit(line.charAt(index))) {
                        word += line.charAt(index);
                        index++;
                    }

                    if (counter % 2 == 0) {
                        println("Word: \"" + word + "\". At position: " + counter);
                    }

                    counter++;
                }
            }
            reader.close();
        } catch (IOException e) {
            println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        new EvenPosInString().start(args);
    }
}
