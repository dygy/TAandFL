package pracX;

import java.util.Scanner;

public class compile {
    /*
    int x = Scanner;
    int y = Scanner;
    public static void body{
    if TokenType.DEC && tokens.get(n-1).text = "x"{
        x--;
    }
    if TokenType.INC && tokens.get(n-1).text = "x"{
        x++;
    }
    if TokenType.DEC && tokens.get(n-1).text = "y"{
        y--;
    }
    if TokenType.INC && tokens.get(n-1).text = "x"{
        y++;
    }
     if TokenType.PRINT && tokens.get(n+1).text = "x"{
        System.out.println(x);
    }
     if TokenType.PRINT && tokens.get(n+1).text = "y"{
        System.out.println(y);
    }
    if TokenType.WHILE (){
    loop();
    }
    }

    public static void loop (){
     if tokens.get(n).text = "=" tokens.get(n+1).text = "x" && tokens.get(n-1).text = "x"{
       while (x = x){
       body();
       }
       }
      else if tokens.get(n).text = ">" tokens.get(n+1).text = "x" && tokens.get(n-1).text = "x"{
       while (x > x){
       body();
       }
       }
        if tokens.get(n).text = "<" tokens.get(n+1).text = "x" && tokens.get(n-1).text = "x"{
       while (x < x){
       body();
       }
       }
        if tokens.get(n).text = "=" tokens.get(n+1).text = "x" && tokens.get(n-1).text = "y"{
       while (y = x){
       body();
       }
       }
        if tokens.get(n).text = ">" tokens.get(n+1).text = "x" && tokens.get(n-1).text = "y"{
       while (y > x){
       body();
       }
       }
        if tokens.get(n).text = "< tokens.get(n+1).text = "x" && tokens.get(n-1).text = "y"{
       while (y < x){
       body();
       }
       }
        if tokens.get(n).text = ">" tokens.get(n+1).text = "y" && tokens.get(n-1).text = "x"{
       while (x > y){
       body();
       }
       }
        if tokens.get(n).text = "=" tokens.get(n+1).text = "y" && tokens.get(n-1).text = "x"{
       while (x = y){
       body();
       }
       }
        if tokens.get(n).text = "<" tokens.get(n+1).text = "y" && tokens.get(n-1).text = "x"{
       while (x < y){
       body();
       }
       }
    }
    }
      lrParser parser = new lrParser(new CommonTokenStream(lexer));
        parser.setErrorHandler(new BailErrorStrategy());
        lrParser.BodyContext bodyContext = parser.body();
        List<BaseStatement> result = contextToTree(bodyContext);
        System.out.println(result);
        Map<String, Double> vars = new HashMap<>();
        for (int i = 0; i < result.size(); i++){
            eval(result.get(i), vars);
        }
    }

    static List<BaseStatement> contextToTree(lrParser.BodyContext bodyContext) {
        // todo: написать это!
        List<BaseStatement> list = new ArrayList<>();
        for (lrParser.StatementContext statementContext : bodyContext.statement()) {
            list.add(contextToTree(statementContext));
        }
        return list;
    }

    static Token getCompareSide(lrParser.ElmContext c) {
        if (c.IDENT() != null) {
            return c.IDENT().getSymbol();
        } else {
            return c.NUMBER().getSymbol();
        }
    }

    static BaseStatement contextToTree(lrParser.StatementContext statementContext) {
        if (statementContext.D_WHILE() != null) {
            lrParser.YslovieContext yslovie = statementContext.yslovie();
            Token left = getCompareSide(yslovie.left);
            Token op = yslovie.ZNAK().getSymbol();
            Token right = getCompareSide(yslovie.right);
            List<BaseStatement> body = contextToTree(statementContext.body());
            WhileNode my_while = new WhileNode(left, op, right, body);
            return my_while;
        } else if (statementContext.PLPL() != null) {
            Token op = statementContext.PLPL().getSymbol();
            Token ident = statementContext.plplIdent;
            return new IncDecNode(ident, op);
        } else if (statementContext.MNMN() != null) {
            Token op = statementContext.PLPL().getSymbol();
            Token ident = statementContext.plplIdent;
            return new IncDecNode(ident, op);
        } else if (statementContext.PRINT() != null) {
            Token indent = statementContext.printIndent;
            return new PrintNode(indent);
        }
        return null;
    }

    static void ask(Map<String, Double> vars, String name) {
        if (vars.containsKey(name))
            return;
        System.out.println("Input " + name + ":");
        double value = new Scanner(System.in).nextDouble();/////////////////////
        vars.put(name, value);
    }

    static void eval(BaseStatement statement, Map<String, Double> vars) {
        if (statement instanceof WhileNode) {
            WhileNode whileNode = (WhileNode) statement;
            eval_while(whileNode, vars);
        } else if (statement instanceof IncDecNode) {
            IncDecNode id = (IncDecNode) statement;
            String name = id.ident.getText();
            ask(vars, name);
            if (id.op.getType() == lrLexer.PLPL) {
                double newValue = vars.get(name) + 1.0;
                vars.put(name, newValue);
            } else if (id.op.getType() == lrLexer.MNMN) {
                double newValue = vars.get(name) - 1.0;
                vars.put(name, newValue);
            }
        } else if (statement instanceof PrintNode) {
            PrintNode id = (PrintNode) statement;
            String name = id.token.getText();
            ask(vars, name);
            System.out.println(vars.get(name));
        }
    }

    private static double getNumber(Token token, Map<String, Double> vars) {
        if (token.getType() == lrLexer.NUMBER) {
            switch (token.getText()) {
                case "I":
                    return 1;
                case "V":
                    return 5;
                case "X":
                    return 10;
            }
            return 0;
        } else {
            ask(vars, token.getText());
            return vars.get(token.getText());
        }
    }

    static void eval_while(WhileNode whileNode, Map<String, Double> vars) {
        while (true) {
            boolean condition = evalCondition(whileNode, vars);
            if (!condition)
                break;
            for (BaseStatement child : whileNode.body) {
                eval(child, vars);
            }
        }
    }

    private static boolean evalCondition(WhileNode whileNode, Map<String, Double> vars) {
        if (whileNode.op.getText().equals("=")) {
            return getNumber(whileNode.left, vars) == getNumber(whileNode.right, vars);
        } else if (whileNode.op.getText().equals(">")) {
            return getNumber(whileNode.left, vars) > getNumber(whileNode.right, vars);
        } else if (whileNode.op.getText().equals("<")) {
            return getNumber(whileNode.left, vars) < getNumber(whileNode.right, vars);
        } else {
            throw new IllegalStateException();
        }
    }
    */

}
