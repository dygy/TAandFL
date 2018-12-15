package pracX;

import java.util.List;

public class WhileNode extends BaseStatement{
    Token left;
    Token op;
    Token right;
    List<BaseStatement> body;
    int open ;

    public WhileNode(Token left, Token op, Token right, List<BaseStatement> body,int open) {
        this.left = left;
        this.op = op;
        this.right = right;
        this.body = body;
        this.open = open;
    }

}

