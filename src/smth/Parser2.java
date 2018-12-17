package smth;

import pracX.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Parser2 {

    private List<Token> tokens;
    private int pos = 0;

    public Parser2(List<Token> tokens) {
        this.tokens = tokens;
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
    private Token match(TokenType type) {
        if (pos >= tokens.size())
            return null;
        Token currentToken = tokens.get(pos);
        if (currentToken.type != type)
            return null;
        pos++;
        return currentToken;
    }

    WhileNode loop() {
        Token ident;
        Token variable;
        Token op;
        List<BaseStatement> body = new ArrayList<>();

        // todo: этот метод вызывается, когда while уже прочитан - осталось прочитать сравнение и do ... done
        if ((variable = match(TokenType.NUMBER)) != null){
            if ((op = match(TokenType.GT))!=null||(op = match(TokenType.EQ))!=null||(op = match(TokenType.LT))!=null){
                Token var2;
                if ((( ident = match(TokenType.IDENT))!=null)){

                    if (((match(TokenType.DO))!=null)) {


                        body.add(statement());

                        if (((match(TokenType.DONE)) != null)) {
                            return new WhileNode(variable, op, ident, body);
                        }
                        else error("loops must end with done");
                    }
                    else error("loops must open with do");


                }
                else if ((var2 = match(TokenType.NUMBER)) != null){
                    if (((match(TokenType.DO))!=null)) {
                        body.add(statement());

                        if (((match(TokenType.DONE)) != null)) {
                            return new WhileNode(variable, op, var2, body);
                        }

                    }
                    else error("loops must open with do");
                }
                else error("Need right variable");
            }
            else error("Need operator between variables");


        } else if ((ident = match(TokenType.IDENT)) != null) {
            // Оператор начинается с while - разбираем цикл:
            if ((op = match(TokenType.GT))!=null||(op = match(TokenType.EQ))!=null||(op = match(TokenType.LT))!=null){
                Token ident2;
                if ((( variable = match(TokenType.NUMBER))!=null)){

                    if (((match(TokenType.DO))!=null)) {


                        body.add(statement());

                        if (((match(TokenType.DONE)) != null)) {
                            return new WhileNode(ident, op, variable, body);
                        }
                        else error("loops must end with done");
                    }
                    else error("loops must open with do");
                }
                else if ((ident2 = match(TokenType.IDENT)) != null){
                    if (((match(TokenType.DO))!=null)) {
                        statement();

                        if (((match(TokenType.DONE)) != null)) {
                            return new WhileNode(ident, op, ident2, body);
                        }
                        else error("loops must end with done");
                    }
                    else error("loops must open with do");
                }
                else error("Need right variable");
            }
            else error("Need operator between variables");
        }
        else error("Need left variable!");

        // todo: для чтения операторов в теле цикла вызываем statement() и добавляем результат в body
        return null;
    }

    BaseStatement statement() {
        Token ident;
        if (match(TokenType.PRINT) != null) {
            // Оператор начинается с 'print', требуем, что за ним идет идентификатор переменной:
            Token variable;
            if ((variable = match(TokenType.IDENT)) == null)
                error("Expected variable in print");
            // Возвращаем узел PrintNode:
            return new PrintNode(variable, 0);
        } else if (match(TokenType.WHILE) != null) {
            // Оператор начинается с while - разбираем цикл:
            return loop();
        } else if ((ident = match(TokenType.IDENT)) != null) {
            // Оператор начинается с идентификатора ident, требуем, что за ним идет ++ или --:
            Token op;
            if ((op = match(TokenType.INC)) != null) {
                // Это ++, возвращаем узел IncDecNode:
                return new IncDecNode(ident, op, 0);
            } else if ((op = match(TokenType.DEC)) != null) {
                // Это --, возвращаем узел IncDecNode:
                return new IncDecNode(ident, op, 0);
            } else {
                error("Expected ++ or --");
            }
        } else {
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