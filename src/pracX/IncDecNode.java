package pracX;

public class IncDecNode extends BaseStatement {
    Token ident;
    Token op;
    int numberOfWhile;

    public IncDecNode(Token ident, Token op,int numberOfWhile) {
       this.ident = ident;
        this.op = op;
        this.numberOfWhile = numberOfWhile;
    }
}
