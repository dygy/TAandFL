package pracX;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Lexer {

    private static TokenType toType(int i) {
        switch (i) {
            case 1: return TokenType.WHILE;
            case 2: return TokenType.DONE;
            case 3: return TokenType.DO;
            case 9: return TokenType.NUMBER;
            case 4: return TokenType.NUMBER;
            case 10: return TokenType.IDENT;
            case 5: return TokenType.IDENT;
            case 13: return TokenType.IDENT;
            case 14: return TokenType.IDENT;
            case 6: return TokenType.GT;
            case 7: return TokenType.LT;
            case 8: return TokenType.EQ;
            case 12: return TokenType.PRINT;
            case 16: return TokenType.DEC;
            case 15: return TokenType.INC;
            case 11: return TokenType.END;
            case 17: Parser.error("Imposible to understand what you want to do with IDENT");
        }
        throw new IllegalStateException();
    }
    List<Token> split(String text) {

        final String regex = "(while)|(done)|(do)|(?:(?:(\\d+)|([a-z]+))\\s*(?:([>])|([<])|([=]))\\s*(?:(\\d+)|([a-z])+))|([;])|(?:(print)\\s*([a-z]*))|([a-z]*)(?:([+]{2})|([-]{2})|([a-z]+))";
        List<Token> list = new ArrayList<>();
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            for (int i = 1; i <= matcher.groupCount(); i++) {
                if (matcher.group(i)!=null) {
                    list.add(new Token(matcher.group(i), toType(i)));
                }
            }

        }
        return list;
    }

    public static void main(String[] args) {
        String text =
                "while x < 5 do\n" +
                "   print x\n" +
                "   x++\n" +
                "   while 3 > x do\n" +
                "      print y\n" +
                "      y--\n" +
                "   done\n" +
                "done\n" +
                "while x > y do\n" +
                "  x--\n" +
                "done";
        List<Token> tokens = new Lexer().split(text);
        for (Token token : tokens) {
           System.out.println(token.type + ": " + token.text);

        }
        Parser2 parser2 = new Parser2(tokens);
        List<BaseStatement> program = parser2.program();
        Parser2.statement();
    }
}