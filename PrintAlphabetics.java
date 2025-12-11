import acm.program.ConsoleProgram;

public class PrintAlphabetics extends ConsoleProgram {
    public void run() {
        printAllAlphabeticLetters();
    }

    private void printAllAlphabeticLetters() {
        print("Enter a string: ");
        String str = readLine();
        while (str.isEmpty()) {
            print("Enter valid string: ");
            str = readLine();
        }

        String res = "";
        int index = 0;
        while (index < str.length()) {
            String word = "";
            while (index < str.length() && Character.isLetterOrDigit(str.charAt(index))) {
                word += str.charAt(index);
                index++;
            }

            if (!word.isEmpty()) {
                boolean hasLetter = true;
                for (int i = 0; i < word.length(); i++) {
                    char ch = word.charAt(i);
                    if (!((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'))) {
                        hasLetter = false;
                        break;
                    }
                }
                if (hasLetter) {
                    res += word + " ";
                }
            }

            index++;
        }

        print(res);
    }

    public static void main(String[] args) {
        new PrintAlphabetics().start(args);
    }
}
