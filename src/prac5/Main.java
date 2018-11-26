package prac5;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class Main {

    static final String string = "-9+9+9*34-324+425-3+3*4/4";
    private static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        boolean isEx = checkWithRegExp(string);
        if (isEx) {
            lexerRegEx(string);
            calc();
        }


    }

    private static boolean checkWithRegExp(String string) {

        Pattern prac3 = Pattern.compile("^([-]?)(\\d+)(?:([-+*/])(\\d+))+$");
        Matcher m = prac3.matcher(string);
        return m.matches();
    }

    private static void lexerRegEx(String string) {
        final String regex = "(\\d+)|(\\-)|(\\+)|(\\*)|(\\/)";


        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(string);

        while (matcher.find()) {
            for (int i = 1; i <= matcher.groupCount(); i++) {
                if (matcher.group(i) != null) {
                    if (i == 1) {
                        System.out.println("Number " + ": " + matcher.group(i));
                        list.add(matcher.group(i));
                    }
                    if (i == 2) {
                        System.out.println("Sub " + ": " + matcher.group(i));
                        list.add(matcher.group(i));
                    }
                    if (i == 3) {
                        System.out.println("Plus " + ": " + matcher.group(i));
                        list.add(matcher.group(i));
                    }
                    if (i == 4) {
                        System.out.println("Multiplication" + ": " + matcher.group(i));
                        list.add(matcher.group(i));
                    }
                    if (i == 5) {
                        System.out.println("Divide" + ": " + matcher.group(i));
                        list.add(matcher.group(i));
                    }

                }

            }

        }
    }

    public static void calc() {

        if (list.get(0).equals("-")) {
            int result = Integer.parseInt(list.get(1))*-1;
            for (int y = 2; y < list.size(); y++) {
                if (list.get(y).equals("+")) {
                    result = result + Integer.parseInt(list.get(y + 1));
                }
                if (list.get(y).equals("-")) {
                    result = result - Integer.parseInt(list.get(y + 1));
                }
                if (list.get(y).equals("*")) {
                    result = result * Integer.parseInt(list.get(y + 1));
                }
                if (list.get(y).equals("/")) {
                    result = result / Integer.parseInt(list.get(y + 1));
                }
            }
            System.out.println(result);
        }
        else {

            int result = Integer.parseInt(list.get(0));
            for (int y = 1; y < list.size(); y++) {

                if (list.get(y).equals("+")) {
                    result = result + Integer.parseInt(list.get(y + 1));
                }
                if (list.get(y).equals("-")) {
                    result = result - Integer.parseInt(list.get(y + 1));
                }
                if (list.get(y).equals("*")) {
                    result = result * Integer.parseInt(list.get(y + 1));
                }
                if (list.get(y).equals("/")) {
                    result = result / Integer.parseInt(list.get(y + 1));
                }
            }
            System.out.println(result);
        }
    }
}