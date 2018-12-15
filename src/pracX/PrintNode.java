package pracX;

public class PrintNode extends BaseStatement {
    Token ident;
int numberOfWhile;
     public PrintNode (Token ident, int numberOfWhile) {
       this.ident = ident;
         this.numberOfWhile = numberOfWhile;
    }
}
