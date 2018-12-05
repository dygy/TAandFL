package prac2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class Main {
    static boolean isFine;
    static final String string = "   \n"
            + "   print x;\n"
            + "   x+-;\n"
            + "   print x;\n"
            + "   x--;\n"
            + "   while y > x do\n"
            + "      print y;\n"
            + "      y--;\n"
            + "	  print x;\n"
            + "      x--;\n"
            + "   while y > x do\n"
            + "      print y;\n"
            + "      y--;\n"
            + "      print y;\n"
            + "      y--;\n"
            + "	  print x;\n"
            + "   done;\n"
            + "   done;\n\n\n\n"
            + " ";

    public static void main(String[] args) {
        System.out.println(string);

        boolean isEx = checkWithRegExp(string);
            if (isEx){
//                lexerRegEx(string);
            }

    }

    private static boolean checkWithRegExp(String string) {
        final String regex = "\\s*(while)\\s+(true\\s*|\\s*false\\s*|(?:\\w+\\s*[><=]\\s*([a-zA-Z]+|\\d+)))\\s+(do)\\s*(.+|\\n*(?:\\n.*|\\s*)*\\n)\\s*(done)([;])";
        Pattern prac2 = Pattern.compile(regex);
        String newString ="";
        Matcher matcher = prac2.matcher(string);
        final String neewRegex = "\\s*(print\\s+[a-z]*[;])*\\s*([a-z]*(?:[-]|[+]){2}[;])*\\s* (while (?:.+\\s+)+ done[;])*";
        final Pattern pattern = Pattern.compile(neewRegex, Pattern.MULTILINE);
        final Matcher matcher4 = pattern.matcher(string);
        while (matcher4.find()) {

            for (int i = 1; i <= matcher4.groupCount(); i++) {
                if (matcher4.group(i) != null) {
                    if (i == 1) {
                        System.out.println("operation " + ": " + matcher4.group(i));
                    }
                    if (i == 2) {
                        System.out.println("cout " + ": " + matcher4.group(i));
                    }

                }
            }
        }
        while (matcher.find()) {

            for (int i = 1; i <= matcher.groupCount(); i++) {
                if (i == 1) {
                    System.out.println();
                    System.out.println("New expression");
                    System.out.println();
                }

                if (matcher.group(i) != null) {
                    if (i == 1) {
                        System.out.println("opening " + ": " + matcher.group(i));
                    }
                    if (i == 2) {
                        System.out.println("statement " + ": " + matcher.group(i));
                    }
                    if (i == 3) {
                        System.out.println("expression " + ": " + matcher.group(i));
                    }

                    if (i == 4 ) {
                        System.out.println("start " + ": " + matcher.group(i));
                    }
                    if (i == 5 ) {
                       newString = newString + matcher.group(i);
                    }

                    if (i == 6) {
                        System.out.println("closing" + ": " + matcher.group(i));
                    }
                    if (i == 7 ) {
                        System.out.println("separator " + ": " + matcher.group(i));
                    }

                }
            }

        }
        isFine = matcher.matches();
        System.out.println(newString);
        final String newRegex = "\\s*(while)\\s+(true\\s*|\\s*false\\s*|(?:\\w+\\s*[><=]\\s*([a-zA-Z]+|\\d+)))\\s+(do)\\s*(.+|\\n*(?:\\n.*|\\s*)*\\n)\\s*(done)([;])";
        Pattern prac2Sec = Pattern.compile(newRegex, Pattern.MULTILINE);
        Matcher matcher2 = prac2Sec.matcher(newString);
        if (matcher2.find()){

            chekAgain(newString);
        }
       else {
            final String newOneRegex = "\\s*(print\\s+[a-z]*[;])*\\s*([a-z]*(?:[-]|[+]){2}[;])*\\s*";
            Pattern prac2Ther = Pattern.compile(newOneRegex, Pattern.MULTILINE);
            Matcher matcher3 = prac2Ther.matcher(newString);
            while (matcher3.find()) {
                for (int i = 1; i <= matcher3.groupCount(); i++) {
                    if (matcher3.group(i)!=null) {
                        if (i == 1) {
                            System.out.println("cout " + ": " + matcher3.group(i));
                        }
                        if (i == 2) {
                            System.out.println("calc " + ": " + matcher3.group(i));
                        }

                    }
                }
            }
        }

     return isFine;
    }
    private static void chekAgain (String string) {
        final String regex = "\\s*(while)\\s+(true\\s*|\\s*false\\s*|(?:\\w+\\s*[><=]\\s*([a-zA-Z]+|\\d+)))\\s+(do)\\s*(.+|\\n*(?:\\n.*|\\s*)*\\n)\\s*(done)([;])";
        Pattern prac2 = Pattern.compile(regex, Pattern.MULTILINE);
        String newString = "";
        Matcher matcher = prac2.matcher(string);
        final String newRegex = "\\s*(print\\s+[a-z]*[;])*\\s*([a-z]*(?:[-]|[+]){2}[;])*\\s* (while (?:.+\\s+)+ done[;])*";
        final Pattern pattern = Pattern.compile(newRegex, Pattern.MULTILINE);
        final Matcher matcher4 = pattern.matcher(string);
        while (matcher4.find()) {

            for (int i = 1; i <= matcher4.groupCount(); i++) {
                if (matcher4.group(i) != null) {
                    if (i == 1) {
                        System.out.println("operation " + ": " + matcher4.group(i));
                    }
                    if (i == 2) {
                        System.out.println("cout " + ": " + matcher4.group(i));
                    }

                }
            }
        }
        while (matcher.find()) {

            for (int i = 1; i <= matcher.groupCount(); i++) {
                if (i == 1) {
                    System.out.println();
                    System.out.println("New expression");
                    System.out.println();
                }

                if (matcher.group(i) != null) {
                    if (i == 1) {
                        System.out.println("operation " + ": " + matcher.group(i));
                    }
                    if (i == 2) {
                        System.out.println("cout " + ": " + matcher.group(i));
                    }
                    if (i == 3) {
                        System.out.println("opening " + ": " + matcher.group(i));
                    }
                    if (i == 4) {
                        System.out.println("statement " + ": " + matcher.group(i));
                    }
                    if (i == 5) {
                        System.out.println("expression " + ": " + matcher.group(i));
                    }

                    if (i == 6) {
                        System.out.println("start " + ": " + matcher.group(i));
                    }
                    if (i == 7) {
                        newString = newString + matcher.group(i);
                    }

                    if (i == 8) {
                        System.out.println("closing" + ": " + matcher.group(i));
                    }
                    if (i == 9) {
                        System.out.println("separator " + ": " + matcher.group(i));
                    }

                }
            }
        }
        Matcher matcher2 = prac2.matcher(newString);
        if (matcher2.find()){
            chekAgain(newString);
        }
        else {
            final String newOneRegex = "\\s*(print\\s+[a-z]*[;])*\\s*([a-z]*(?:[-]|[+]){2}[;])*\\s*";
            Pattern prac2Ther = Pattern.compile(newOneRegex, Pattern.MULTILINE);
            Matcher matcher3 = prac2Ther.matcher(newString);
            while (matcher3.find()) {
                for (int i = 1; i <= matcher3.groupCount(); i++) {
                    if (matcher3.group(i)!=null) {
                        if (i == 1) {
                            System.out.println("cout " + ": " + matcher3.group(i));
                        }
                        if (i == 2) {
                            System.out.println("calc " + ": " + matcher3.group(i));
                        }

                    }
                }
            }
        }
        isFine = matcher.matches();
    }
    private static void lexerRegEx (String string){
        final String regex = "(\\d+)|(\\-)|(\\+)|(\\*)|(\\/)";


        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(string);

        while (matcher.find()) {
            for (int i = 1; i <= matcher.groupCount(); i++) {
                if (matcher.group(i)!=null) {
                    if (i == 1) {
                        System.out.println("Number " + ": " + matcher.group(i));
                    }
                    if (i == 2) {
                        System.out.println("Sub " + ": " + matcher.group(i));
                    }
                    if (i == 3) {
                        System.out.println("Plus " + ": " + matcher.group(i));
                    }
                    if (i == 4) {
                        System.out.println("Multiplication" + ": " + matcher.group(i));
                    }
                    if (i == 5) {
                        System.out.println("Divide" + ": " + matcher.group(i));
                    }
                }
            }
        }
    }
}
