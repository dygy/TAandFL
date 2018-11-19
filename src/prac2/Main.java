package prac2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class Main {

    public static void main(String[] args)  {
        final String regex = "W*((?i)while(?-i))\\W*W*((?i)true(?-i)\\W*|W*(?i)false(?-i)\\W*|(?:\\w+[>,<,=]\\S+))([;])(?:.+(?:\\n.+)*)\\nW*((?i)done(?-i))";
        final String string = "while true; do\n"
                + "echo \"Нажмите CTRL-C для выхода.\"\n"
                + "done\n\n"
                + "while x>19; do\n"
                + "echo \"Нажмите CTRL-C для выхода.\"\n"
                + "done";


        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(string);

        while (matcher.find()) {

            for (int i = 1; i <= matcher.groupCount(); i++) {
                if (i == 1)
                {
                    System.out.println();
                    System.out.println("New expression");
                    System.out.println();
                }

                if (matcher.group(i)!=null) {
                    if (i == 1) {
                        System.out.println("opening " + ": " + matcher.group(i));
                    }
                    if (i == 2) {
                        System.out.println("statement " + ": " + matcher.group(i));
                    }
                    if (i == 3) {
                        System.out.println("separator " + ": " + matcher.group(i));
                    }
                    if (i == 4) {
                        System.out.println("closing" + ": " + matcher.group(i));
                    }
                    if (i == 5) {
                        System.out.println("Divide" + ": " + matcher.group(i));
                    }
                }
            }
        }
    }
}
