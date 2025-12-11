import acm.program.ConsoleProgram;

public class AllWordsWithSymbol extends ConsoleProgram {
    public void run() {
        printWordsWithSymbol();
    }

    private void printWordsWithSymbol() {
        print("Enter a string: ");
        String str = readLine().trim();

        while (str.isEmpty()) {
            print("Enter a valid string: ");
            str = readLine().trim();
        }

        print("Enter a desired symbol: ");
        String input = readLine().trim();
        while (input.length() != 1) {
            print("Enter a single char: ");
            input = readLine().trim();
        }
        char symbol = input.charAt(0);
        int index = 0;
        String res = "";
        while (index < str.length()) {
            String word = "";

            while (index < str.length() && Character.isLetterOrDigit(str.charAt(index))) {
                word += str.charAt(index);
                index++;
            }

            if (containsSymbol(word, symbol)) {
                res += word + " ";
            }

            index++;
        }
        println("All words that contain " + symbol + ": " + res);

    }

    private boolean containsSymbol(String s, char smb) {
        boolean hasSymbol = false;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == smb) {
                hasSymbol = true;
                break;
            }
        }
        return hasSymbol;
    }

    public static void main(String[] args) {
        new AllWordsWithSymbol().start(args);
    }
}
