package lab1;

import javax.script.ScriptException;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.* ;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    public static String string = scanner.next();
    private static List<String> list = new ArrayList<>();
    private static boolean br = false;

    public static void main (String[] args) throws NoSuchMethodException, ScriptException, IOException {
        splitToList(string);

        boolean NotBrEx = checkWithRegExp(string);
        if (!br) {
            if (!NotBrEx){
                System.out.println("The regular expression didn't recognize needed input!");
            }
            if (NotBrEx){
                Lexer.goJS();
            }
        }
    }
    private static boolean checkWithRegExp(String string){
        Pattern lab1 = Pattern.compile("^(([\"(\"])*(\\d+)([\",\"](\\d+))*([\")\"])*(?:([-+*\\/])" +
                "*([\")\"])*((?:[-+])?([\"(\"])*\\d+)" +
                "([\",\"](\\d+))*)+([\")\"])*(=)(\\d+)([\",\"](\\d+))*(;))+");
        Matcher m = lab1.matcher(string);
        return m.matches();
    }

    private static void splitToList(String string){

        list.addAll(Arrays.asList(string.split("")));
        chekList(list);
    }
    private static void chekList (List list){

        int open = 0;
        int close =0;

        for (int i=0;i<list.size();i++) {


            if ("(".equals(list.get(i))) {
                open++;
            }
            if (")".equals(list.get(i))) {
                close++;
            }

        }
        if (open != close){
            System.out.println("false! Missing ) or ( !" );
            br = true;
        }

    }
}