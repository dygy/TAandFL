package pracX;

public class WhileNode extends BaseStatement{
    Token left;
    Token op;
    Token right;

    public WhileNode(Token left, Token op, Token right) {
        this.left = left;
        this.op = op;
        this.right = right;
    }
}
