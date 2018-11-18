package prac3;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Main {


    static final String regex = "(\\d+)(?:([+])(\\d+))*";
    static final String string = "35+34\n"
            + "35\n"
            + "345+324+53523 \n"
            + "+";

    static final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
    static final Matcher matcher = pattern.matcher(string);

   public static void main(String[] args) {
       while (matcher.find()) {
           for (int i = 1; i <= matcher.groupCount(); i++) {
               if (matcher.group(i)!=null) {
                   if (i == 1) {
                       System.out.println("Number " + ": " + matcher.group(i));
                   }
                   if (i == 2) {
                       System.out.println("Plus " + ": " + matcher.group(i));
                   }
                   if (i == 3) {
                       System.out.println("Number " + ": " + matcher.group(i));
                   }
               }
           }
       }
    }
}
