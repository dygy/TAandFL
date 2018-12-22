package pracX;

import java.util.List;

public class WhileNode extends BaseStatement{
    public Token left;
    public Token op;
    public Token right;
    public List<BaseStatement> body;

    public WhileNode(Token left, Token op, Token right, List<BaseStatement> body) {
        this.left = left;
        this.op = op;
        this.right = right;
        this.body = body;
    }

}

