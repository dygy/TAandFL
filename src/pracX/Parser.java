package pracX;

import java.util.List;

public class Parser {

    private List<Token> tokens;

    public Parser(List<Token> tokens) {
        this.tokens = tokens;
    }

    // program : statement+;
    // statement : 'print' 'ident' ';' | 'ident' '++' | 'ident' '--' | 'while'
    //

    private void error(String message) {
        throw new IllegalArgumentException(message);
    }

    BaseStatement statement() {

    }

    List<BaseStatement> program() {

    }
}
