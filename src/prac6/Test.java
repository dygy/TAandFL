package prac6;

import pracX.*;

import java.util.*;

public class Test {

    public static void main(String[] args) {
        /*
         * while x < 5 do
         *   print x;
         *   x++;
         * done
         * print x;
         */
        List<BaseStatement> program = Arrays.asList(
                // Первый оператор программы - while ...
                new WhileNode(
                        // Условие while: x < 5
                        new Token("x", TokenType.IDENT), new Token("<", TokenType.LT), new Token("5", TokenType.NUMBER),
                        // Тело while - из двух операторов:
                        Arrays.asList(
                                // Первый оператор тела while - print x:
                                new PrintNode(new Token("x", TokenType.IDENT)),
                                // Второй оператор тела while - x++:
                                new IncDecNode(new Token("x", TokenType.IDENT), new Token("++", TokenType.INC))
                        )
                ),
                // Второй оператор программы - print x:
                new PrintNode(new Token("x", TokenType.IDENT))
        );
        Map<String, Integer> variables = new HashMap<>();
        variables.put("x", 1);
        executeStatements(program, variables);
    }

    /**
     * @param variables значения переменных; ключ в Map - имя переменной, значение - значение переменной
     */
    public static void executeStatements(List<BaseStatement> statements, Map<String, Integer> variables) {
        for (BaseStatement statement : statements) {
            executeStatement(statement, variables);
        }
    }

    private static double compareSide(Token value, Map<String, Integer> variables) {
        if (value.type == TokenType.NUMBER) {
            return Double.parseDouble(value.text);
        } else {
            return ask(variables, value.text);
        }
    }

    private static int ask(Map<String, Integer> variables, String name) {
        if (variables.containsKey(name)) {
            return variables.get(name);
        } else {
            System.out.println("Input " + name);
            int v = new Scanner(System.in).nextInt();
            variables.put(name, v);
            return v;
        }
    }

    private static void executeStatement(BaseStatement statement, Map<String, Integer> variables) {
        if (statement instanceof PrintNode) {
            PrintNode printNode = (PrintNode) statement;
            String variable = printNode.ident.text;
            Integer value = ask(variables, variable);
            System.out.println(value);
        } else if (statement instanceof IncDecNode) {
            IncDecNode incDecNode = (IncDecNode) statement;
            String variable = incDecNode.ident.text;
            Integer value = ask(variables, variable);
            Integer newValue = incDecNode.op.type == TokenType.INC ? value + 1 : value - 1;
            variables.put(variable, newValue);
        } else if (statement instanceof WhileNode) {
            WhileNode whileNode = (WhileNode) statement;
            while (true) {
                double left = compareSide(whileNode.left, variables);
                double right = compareSide(whileNode.right, variables);
                boolean result = false;
                switch (whileNode.op.type) {
                    case EQ:
                        result = left == right;
                        break;
                    case GT:
                        result = left > right;
                        break;
                    case LT:
                        result = left < right;
                        break;
                }
                if (!result)
                    break;
                executeStatements(whileNode.body, variables);
            }
            // break
        }
    }
}
