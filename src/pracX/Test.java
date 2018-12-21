package pracX;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {



    /**
     * @param variables значения переменных; ключ в Map - имя переменной, значение - значение переменной
     */
    private static void executeStatements(List<BaseStatement> statements, Map<String, Integer> variables) {
        for (BaseStatement statement : statements) {
            executeStatement(statement, variables);
        }
    }

    private static void executeStatement(BaseStatement statement, Map<String, Integer> variables) {
        if (statement instanceof PrintNode) {
            PrintNode printNode = (PrintNode) statement;
            String variable = printNode.ident.text;
            Integer value = variables.get(variable);
            System.out.println(value);
        } else if (statement instanceof IncDecNode) {
            IncDecNode incDecNode = (IncDecNode) statement;
            String variable = incDecNode.ident.text;
            Integer value = variables.get(variable);
            Integer newValue = incDecNode.op.type == TokenType.INC ? value + 1 : value - 1;
            variables.put(variable,newValue);

        }
        else if (statement instanceof WhileNode) {
            WhileNode whileNode = (WhileNode) statement;

           if (((WhileNode) statement).left.type == TokenType.IDENT) {
               String leftVar =  ((WhileNode) statement).left.text;
            }

            else  {
                int leftVar = Integer.parseInt(((WhileNode) statement).left.text);
            }

            String opr=whileNode.op.text;

            if (((WhileNode) statement).left.type == TokenType.IDENT) {
                String rightVar =  ((WhileNode) statement).right.text;
            }
            else {
                int rightVar = Integer.parseInt(((WhileNode) statement).right.text);
            }
            // todo: допишите сами
        }
    }
}