import acm.program.ConsoleProgram;

public class PrintAllNumbers extends ConsoleProgram {
    public void run() {
        printNumbers();
    }

    private void printNumbers() {
        print("Enter a string: ");
        String str = readLine().trim();
        while (str.isEmpty()) {
            print("Enter valid string: ");
            str = readLine().trim();
        }

        int index = 0;

        String nums = "";
        while (index < str.length()) {
            String word = "";
            while (index < str.length() && !Character.isWhitespace(str.charAt(index))) {
                word += str.charAt(index);
                index++;
            }
            if (isNumber(word)) {
                nums += word + " ";
            }
            index++;
        }
        println(nums);
    }

    private boolean isNumber(String s) {
        int countSpecials = 0;
        boolean hasDigit = false;
        int startIndex = 0;

        if (s.charAt(0) == '-') {
            if (s.length() == 1) return false;
            startIndex = 1;
        }

        for (int i = startIndex; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (c == '.' || c == ',') {
                countSpecials++;
                if (countSpecials > 1) return false;
            } else {
                return false;
            }
        }

        return hasDigit;
    }

    public static void main(String[] args) {
        new PrintAllNumbers().start(args);
    }
}
