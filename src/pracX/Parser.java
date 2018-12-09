package pracX;

import java.util.List;

public class Parser {

    private List<Token> tokens;

    static void parser(List<Token> tokens) {
        int open=0;
        int start = 0;
        int end=0;

        for (int x = 0;x<tokens.size();x++){
            if (tokens.get(x).type.equals(TokenType.IDENT)){
                if (tokens.get(x).text.equals("x")||tokens.get(x).text.equals("y")){

                }
                else error("Illegal name of IDENT!");
            }
            if (tokens.get(x).type.equals(TokenType.DO)){
                start++;
            }

            if (tokens.get(x).type.equals(TokenType.DONE)){
                end++;
                if (x+1<tokens.size()) {
                    if (tokens.get(x + 1).type.equals(TokenType.END)) {

                    }
                    else error("Done must over with ;");
                }
                else error("Done must over with ;");
            }

            if (tokens.get(x).type.equals(TokenType.WHILE)) {
                open++;

                if (tokens.get(x + 1).type.equals(TokenType.NUMBER) || tokens.get(x + 1).type.equals(TokenType.IDENT)) {

                    if (tokens.get(x + 2).type.equals(TokenType.GT) || tokens.get(x + 2).type.equals(TokenType.LT) || tokens.get(x + 2).type.equals(TokenType.EQ)) {

                        if (tokens.get(x + 3).type.equals(TokenType.NUMBER) || tokens.get(x + 3).type.equals(TokenType.IDENT)) {

                            System.out.println("One loop are successfully checked!" +tokens.get(x+3).type);
                         //   WhileNode.WhileNode(tokens.get(x+1),tokens.get(x+2),tokens.get(x+3));

                        }

                        else error("While suppose to have IDENT or NUMBER in condition after operation");

                    }

                    else error("While suppose to have >,< or = operation in condition");

                }

                else {
                    error("While suppose to have IDENT or NUMBER in condition");

                }
            }
            if (tokens.get(x).type.equals(TokenType.PRINT)){
                if (tokens.get(x+1).type.equals(TokenType.IDENT)) {
                    if (tokens.get(x+2).type.equals(TokenType.END)) {
             //           PrintNode.printNode(tokens.get(x + 1));
                    }
                    else error("Print operation suppose to end with ;");
                }
                else error("Print operation suppose to have IDENT");

            }
            if (tokens.get(x).type.equals(TokenType.DEC)) {
                if (tokens.get(x - 1).type.equals(TokenType.IDENT)) {
                    if (tokens.get(x + 1).type.equals(TokenType.END)) {
                //        IncDecNode.IncDecNode(tokens.get(x - 1), tokens.get(x));
                    }
                    else error("DEC operation suppose to end with ;");

                }
                else error("DEC operation suppose to have IDENT");
            }
            if (tokens.get(x).type.equals(TokenType.INC)){
                if (tokens.get(x-1).type.equals(TokenType.IDENT)) {
                    if (tokens.get(x+1).type.equals(TokenType.END)) {
                 //       IncDecNode.IncDecNode(tokens.get(x-1),tokens.get(x));
                    }
                    else error("INC operation suppose to end with ;");
                }
                else error("INC operation suppose to have IDENT");
            }
      //      if ((tokens.get(x).type.equals(TokenType.NUMBER))||(tokens.get(x).type.equals(TokenType.IDENT))){
      //          if ((tokens.get(x+1).type.equals(TokenType.INC))||(tokens.get(x+1).type.equals(TokenType.DEC))||(tokens.get(x+1).type.equals(TokenType.GT))||(tokens.get(x+1).type.equals(TokenType.LT))||(tokens.get(x+1).type.equals(TokenType.EQ))||(tokens.get(x+1).type.equals(TokenType.DO))||(tokens.get(x-1).type.equals(TokenType.PRINT))){
     //
     //           }
     //           else error("Imposible to understand what you want to do with "+ tokens.get(x).text);
     //       }
    // did it in lexer

        }

        if (open!=end||end!=start){
            error("Error. Number of WHILE,DO,DONE are not equal!");
        }
        else{
            System.out.println("All loops was gated successful!");
        }

    }

    // program : loop+;
    // loop : 'while' condition 'do' statement 'done'
    // condition : 'ident' op 'ident' | 'number' op 'ident' | 'ident' op 'number'|'number' op 'number'
    // statement : 'print' 'ident' ';' | 'ident' '++' ';' | 'ident' '--' ';' | loop
    // op : '>' | '<' | '='
    //

    public static void error(String message) {
        throw new IllegalArgumentException(message);

    }

    BaseStatement statement() {

        return null;
    }

    List<BaseStatement> program() {

        return null;
    }
}
