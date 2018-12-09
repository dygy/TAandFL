package pracX;

public class IdentNode extends BaseStatement{
    Token ident;

    public IdentNode(Token ident) {
        this.ident = ident;
    }
}