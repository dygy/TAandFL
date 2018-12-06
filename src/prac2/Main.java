package prac2;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class Main {
    private static List<String> list = new ArrayList<>();
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
                        System.out.println("cout " + ": " + matcher4.group(i));
                    }
                    if (i == 2) {
                        System.out.println("calc " + ": " + matcher4.group(i));
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
            //            list.add()
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
                        System.out.println("cout " + ": " + matcher4.group(i));
                    }
                    if (i == 2) {
                        System.out.println("calc " + ": " + matcher4.group(i));
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

                    if (i == 4) {
                        System.out.println("start " + ": " + matcher.group(i));
                    }
                    if (i == 5) {
                        newString = newString + matcher.group(i);
                    }

                    if (i == 6) {
                        System.out.println("closing" + ": " + matcher.group(i));
                    }
                    if (i == 7) {
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

    public static boolean countInside (){
        int opening=0;
        int close=0;
        int start=0;
        int statement=0;
        int separator=0;
        System.out.println(list);
        for (int i =0;i<list.size();i++) {

            if (list.get(i).equals("opening")){
                opening++;

            }
            if (list.get(i).equals("closing")){
                close++;

            }
            if (list.get(i).equals("start")){
                start++;

            }
            if (list.get(i).equals("statement")){
                statement++;

            }
            if (list.get(i).equals("separator")){
                separator++;

            }


        }

        return separator == statement && start == statement &&
                opening == start && opening == close;
    }

}
