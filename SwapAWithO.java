import acm.program.ConsoleProgram;

public class SwapAWithO extends ConsoleProgram {
    public void run() {
        swapLetters();
    }
    private void swapLetters() {
        print("Enter a string: ");
        String str = readLine().trim();
        while (str.length() == 0) {
            print("Enter valid string: ");
            str = readLine().trim();
        }

        int countA = 0;
        int countO = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'а') {
                countA++;
            } else if (str.charAt(i) == 'о') {
                countO++;
            }
        }

        int maxPairs;
        if (countA < countO) {
            maxPairs = countA;
        } else {
            maxPairs = countO;
        }
        int currentA = 0;
        int currentO = 0;

        String res = "";
        if (str.contains("а") || str.contains("о")) {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == 'а') {
                    currentA++;
                    if (currentA <= maxPairs) {
                        res += "о";
                    } else res += "a";

                } else if (str.charAt(i) == 'о') {
                    currentO++;
                    if (currentO <= maxPairs) {
                        res += "а";
                    } else res += "o";
                } else {
                    res += str.charAt(i);
                }
            }
        } else println(str);

        println(str + " = " + res);
    }

    public static void main(String[] args) {
        new SwapAWithO().start(args);
    }
}
