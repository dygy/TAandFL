package pracX;

public class IncDecNode extends BaseStatement {
    public Token ident;
    public Token op;

    public IncDecNode(Token ident, Token op) {
       this.ident = ident;
        this.op = op;
    }
}
