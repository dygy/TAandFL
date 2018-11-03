package prac2;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.script.ScriptException;

public class Main {

    private static List<String> list = new ArrayList<>();




    public static void main(String[] args) throws NoSuchMethodException, ScriptException, IOException {
        final String regex = "W*((?i)while(?-i))\\W*W*((?i)true(?-i)\\W*|W*(?i)false(?-i)\\W*|(?:\\w+[>,<,=]\\S+))([;])(?:.+(?:\\n.+)*)\\nW*((?i)done(?-i))";
        final String string = "while true; do\n"
                + "echo \"Нажмите CTRL-C для выхода.\"\n"
                + "done\n\n"
                + "while x>19; do\n"
                + "echo \"Нажмите CTRL-C для выхода.\"\n"
                + "done";
        System.out.println("Group 1 is opening");
        System.out.println("Group 2 is statement");
        System.out.println("Group 3 is separator");
        System.out.println("Group 4 is closing");


        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(string);

        while (matcher.find()) {
           // System.out.println("Full match: " + matcher.group(0));
            for (int i = 1; i <= matcher.groupCount(); i++) {
                if (i == 1)
                {
                    System.out.println();
                    System.out.println("New expression");
                    System.out.println();
                }
                System.out.println("Group " + i + ": " + matcher.group(i));
            }
        }
    }

    private static boolean checkWithRegExp(String string) {
        final String regex = "(W*((?i)while(?-i))\\W*(W*((?i)true(?-i))\\W*|W*((?i)false(?-i))\\W*|\\w+[>,<,=]\\S+)[;].+(\\n.+)*\\nW*((?i)done(?-i)))";

        Pattern prac2 = Pattern.compile(regex);
        Matcher m = prac2.matcher(string);
        return m.matches();
    }
    private static void splitToList(String string){

        list.addAll(Arrays.asList(string.split("")));
    }
}
