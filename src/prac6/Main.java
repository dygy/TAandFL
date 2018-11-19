package prac6;



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
                if (i == 1) {
                    System.out.println();
                    System.out.println("New expression");
                    System.out.println();
                    System.out.println("_______________________________________________");
                    System.out.println("|NAME  | " + "TYPE     " +"|"+
                            "DESCRIPTION" +"                |");

                }

                        if (matcher.group(i)!=null) {
                            if (i == 1) {
                                System.out.println("_______________________________________________");
                                System.out.println("|"+matcher.group(i) + " | " + "opening  " +"|"+
                                        "Used to open a loops" +"       |");


                            }
                            if (i == 2) {
                                System.out.println("_______________________________________________");

                                final String regex1 = "(true)|(false)|((?:(?:\\d+)|(?:[a-z]+))[>,<,=](?:(?:\\d+)|(?:[a-z]+)))";
                                final Pattern pattern1 = Pattern.compile(regex1, Pattern.MULTILINE);
                                final Matcher matcher1 = pattern1.matcher(matcher.group(i));
                                while (matcher1.find()) {
                                    for (int y = 1; y <= matcher1.groupCount(); y++) {
                                        if (matcher1.group(y) != null) {
                                            if (y==1){
                                                System.out.println("|"+ matcher1.group(y) + "  | " +"statement"+"|"+"Will always work"+"           |");
                                            }
                                            if (y==2){
                                                System.out.println("|"+ matcher1.group(y) + "  | " +"statement"+"|"+"Will never work"+"            |");
                                            }
                                            if (y==3){
                                                System.out.println("|"+ matcher1.group(y) + "  | " +"statement"+"|"+"Will work until it's true"+"  |");
                                            }

                                        }
                                    }

                                }


                            }
                            if (i == 3) {
                                System.out.println("_______________________________________________");
                                System.out.println("|"+matcher.group(i) + "     | " + "separator"+
                                        "|"+ "Used to separate lines" +"     |" );
                            }
                            if (i == 4) {
                                System.out.println("_______________________________________________");
                                System.out.println("|"+matcher.group(i) + "  | " +"closing  "+"|"+
                                        "Used to close the statement"+"|");
                                System.out.println("_______________________________________________");

                            }
                        }
                }
            }
        }
    }
