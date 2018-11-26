package prac1;


import java.util.Scanner;
        import java.util.regex.Matcher;
        import java.util.regex.Pattern;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static String string = scanner.next();
    public static void main (String[] args) {
        Pattern prac1 = Pattern.compile("[\"^\"]",Pattern.MULTILINE);
        Matcher m = prac1.matcher(string);

        while (m.find()) {
            System.out.println("exponentiation: " + m.group(0));
            for (int i = 1; i <= m.groupCount(); i++) {
                System.out.println(" " + i + ": " + m.group(i));
            }

        }
    }

}
