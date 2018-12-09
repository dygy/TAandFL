package pracX;

public class IncDecNode extends BaseStatement {
    Token ident;
    Token op;

    public IncDecNode(Token ident, Token op) {
        this.ident = ident;
        this.op = op;
    }
}
