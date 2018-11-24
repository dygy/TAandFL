package lab2;

import com.sun.org.apache.xerces.internal.xs.StringList;
import com.sun.xml.internal.fastinfoset.util.StringArray;

import java.io.IOException;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class Main {
    private static List<String> list = new ArrayList<String>();
    private static List<Integer> atFirst = new ArrayList<Integer>();
    private static List<Integer> toRemove = new ArrayList<Integer>();
    private static String string;
    public static void main(String[] args) throws IOException {
        readTxt();
        boolean isEx = checkWithRegExp(string);
        if (isEx) {
            lexerRegEx(string);
            calc();
        }

    }

    private static void readTxt() throws IOException{
        Scanner file = new Scanner(new File("src//lab2//data.txt"));
        string = file.next();
    }

    private static boolean checkWithRegExp(String string) {

        Pattern prac3 = Pattern.compile("^([-+]?)(\\d+)(?:([-+*/])(\\d+))+$");
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
                        list.add(matcher.group(i));
                        atFirst.add(list.lastIndexOf(matcher.group(i)));

                    }
                    if (i == 5) {
                        System.out.println("Divide" + ": " + matcher.group(i));
                        list.add(matcher.group(i));
                        atFirst.add(list.lastIndexOf(matcher.group(i)));

                    }

                }

            }

        }
    }
    private static void calc() {
        if (list.get(0).equals("-")) {
            int result = Integer.parseInt(list.get(1)) * -1;

            for (int z = 0; z< atFirst.size(); z++) {
                if (list.get(atFirst.get(z)).equals("*")){
                    list.set(atFirst.get(z)+1,String.valueOf(
                            Integer.parseInt(
                                    list.get(atFirst.get(z)-1))*
                                    Integer.parseInt(list.get(atFirst.get(z)+1
                                            )
                                    )
                            )
                    );

                    toRemove.add(atFirst.get(z));
                    toRemove.add(atFirst.get(z)-1);

                }
                if (list.get(atFirst.get(z)).equals("/")){
                    list.set(atFirst.get(z)+1,String.valueOf(
                            Integer.parseInt(list.get(atFirst.get(z)-1)
                            )
                                    /
                                    Integer.parseInt(list.get(atFirst.get(z)+1
                                            )
                                    )
                            )
                    );

                    toRemove.add(atFirst.get(z));
                    toRemove.add(atFirst.get(z)-1);

                }
            }

            Collections.sort(toRemove);
            Collections.reverse(toRemove);

            for (int removeIndex=0;removeIndex<toRemove.size();removeIndex++) {
                int remove = toRemove.get(removeIndex);

                list.remove(remove);


            }
            for (int y = 2; y < list.size(); y++) {

                if (list.get(y).equals("+")) {
                    result = result + Integer.parseInt(list.get(y + 1));
                }
                if (list.get(y).equals("-")) {
                    result = result - Integer.parseInt(list.get(y + 1));
                }

            }
            System.out.println(result);
        } else {

            int result = Integer.parseInt(list.get(0));
            for (int z = 0; z< atFirst.size(); z++) {
                if (list.get(atFirst.get(z)).equals("*")){
                    list.set(atFirst.get(z)+1,String.valueOf(
                            Integer.parseInt(
                                    list.get(atFirst.get(z)-1))*
                                    Integer.parseInt(list.get(atFirst.get(z)+1
                                            )
                                    )
                            )
                    );

                    toRemove.add(atFirst.get(z));
                    toRemove.add(atFirst.get(z)-1);

                }
                if (list.get(atFirst.get(z)).equals("/")){
                    list.set(atFirst.get(z)+1,String.valueOf(
                            Integer.parseInt(list.get(atFirst.get(z)-1)
                            )
                                    /
                                    Integer.parseInt(list.get(atFirst.get(z)+1
                                            )
                                    )
                            )
                    );

                    toRemove.add(atFirst.get(z));
                    toRemove.add(atFirst.get(z)-1);

                }
            }

            Collections.sort(toRemove);
            Collections.reverse(toRemove);

            for (int removeIndex=0;removeIndex<toRemove.size();removeIndex++) {
                int remove = toRemove.get(removeIndex);

                list.remove(remove);


            }
            for (int y = 1; y < list.size(); y++) {

                if (list.get(y).equals("+")) {
                    result = result + Integer.parseInt(list.get(y + 1));
                }
                if (list.get(y).equals("-")) {
                    result = result - Integer.parseInt(list.get(y + 1));
                }
            }
            System.out.println(result);
        }
    }

}