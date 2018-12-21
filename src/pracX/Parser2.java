package pracX;

import pracX.*;

import java.util.ArrayList;
import java.util.List;

public class Parser2 {

    private static List<Token> tokens;
    private static int pos = 0;

    public Parser2(List<Token> tokens) {
        Parser2.tokens = tokens;
    }

    // program : statement+;
    // loop : 'while' condition 'do' statement+ 'done'
    // condition : 'ident' op 'ident' | 'number' op 'ident' | 'ident' op 'number'|'number' op 'number'
    // statement : 'print' 'ident' | 'ident' '++' | 'ident' '--' | loop
    // op : '>' | '<' | '='
    //

    private static void error(String message) {
        throw new IllegalArgumentException(message);
    }

    /**
     * Если текущая лексема имеет тип type, то возвращает текущую лексему и переходит к следующей лексеме; иначе
     * возвращает null.
     */
    private static Token match(TokenType type) {

        if (pos >= tokens.size())
            return null;

        Token currentToken = tokens.get(pos);

        if (currentToken.type != type)
            return null;

        pos++;
        return currentToken;
    }

    private static Token checkOp(){
        Token toReturn;
        if ((toReturn = match(TokenType.GT))!=null||(toReturn = match(TokenType.EQ))!=null||(toReturn = match(TokenType.LT))!=null) {}
        else error("Need operator between variables");
        return toReturn;
    }
    private static Token checkSide() {
        Token toReturn;
        if ((toReturn = match(TokenType.NUMBER)) != null) {}
        else if ((toReturn= match(TokenType.IDENT)) != null){}
        else error("Missed variable");
        return toReturn;
    }


    private static WhileNode loop() {
        Token left;
        Token right;
        Token op;

        // todo: этот метод вызывается, когда while уже прочитан - осталось прочитать сравнение и do ... done
        left = checkSide();
        op = checkOp();
        right = checkSide();
            // Оператор начинается с while - разбираем цикл:


        List<BaseStatement> body = new ArrayList<>();
        if (((match(TokenType.DO))!=null)) {
            while (hasStatement()) {
                body.add(statement());
            }

         }
        else error("loops must open with do");
        // todo: для чтения операторов в теле цикла вызываем statement() и добавляем результат в body
        return new WhileNode(left, op, right, body);
    }
    static boolean hasStatement(){

        if (match(TokenType.DONE) != null) {
            return false;
        }

        else return true;
    }

   static BaseStatement statement() {
        Token ident;
        if (match(TokenType.PRINT) != null) {
            // Оператор начинается с 'print', требуем, что за ним идет идентификатор переменной:
            Token variable;
            if ((variable = match(TokenType.IDENT)) == null)
                error("Expected variable in print");
            // Возвращаем узел PrintNode:
            return new PrintNode(variable);
        } else if (match(TokenType.WHILE) != null) {
            // Оператор начинается с while - разбираем цикл:
            return loop();
        } else if ((ident = match(TokenType.IDENT)) != null) {
            // Оператор начинается с идентификатора ident, требуем, что за ним идет ++ или --:
            Token op;
            if ((op = match(TokenType.INC)) != null) {
                // Это ++, возвращаем узел IncDecNode:
                return new IncDecNode(ident, op);
            } else if ((op = match(TokenType.DEC)) != null) {
                // Это --, возвращаем узел IncDecNode:
                return new IncDecNode(ident, op);
                }
            else {
                error("Expected ++ or --");
            }

        }
        else  if ((match(TokenType.END)) != null){


        }
        else if((match(TokenType.END)) == null){

       }
        else {
            // Оператор должен начинаться с print, while или идентификатора:

            error("Expected 'print', 'while' or ident");
        }
        return null;
    }

    List<BaseStatement> program() {
        List<BaseStatement> statements = new ArrayList<>();
        while (pos < tokens.size()) {
            BaseStatement st = statement();
            statements.add(st);
        }
        return statements;
    }
}