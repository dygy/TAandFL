package prac5;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class Main {

    static final String string = "-9+9+9*34-324+425-3+3*4/4";
    private static List<String> list = new ArrayList<>();
    private static List<String> forTree = new ArrayList<String>();
    private static List<Integer> atFirst = new ArrayList<Integer>();
    private static List<Integer> toRemove = new ArrayList<Integer>();

    public static void main(String[] args) {
        boolean isEx = checkWithRegExp(string);
        if (isEx) {
            lexerRegEx(string);
            Calc.calc(list,toRemove,atFirst);
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
                        forTree.add(matcher.group(i));
                    }
                    if (i == 2) {
                        System.out.println("Sub " + ": " + matcher.group(i));
                        list.add(matcher.group(i));
                        forTree.add(matcher.group(i));

                    }
                    if (i == 3) {
                        System.out.println("Plus " + ": " + matcher.group(i));
                        list.add(matcher.group(i));
                        forTree.add(matcher.group(i));
                    }
                    if (i == 4) {
                        list.add(matcher.group(i));
                        atFirst.add(list.lastIndexOf(matcher.group(i)));
                        forTree.add(matcher.group(i));

                    }
                    if (i == 5) {
                        System.out.println("Divide" + ": " + matcher.group(i));
                        list.add(matcher.group(i));
                        atFirst.add(list.lastIndexOf(matcher.group(i)));
                        forTree.add(matcher.group(i));

                    }

                }

            }

        }
    }

}