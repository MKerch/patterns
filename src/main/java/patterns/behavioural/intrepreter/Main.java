package patterns.behavioural.intrepreter;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        String expression = "1+2+3-4";
        Expression evaluate = new Evaluate(expression);
        System.out.println(evaluate.intrepreter(evaluate));
    }
}

interface Expression {

    int intrepreter(Expression context);

}

class Number implements Expression {

    int number;

    public Number(int number) {
        this.number = number;
    }

    @Override
    public int intrepreter(Expression context) {
        return number;
    }
}

class Plus implements Expression {
    Expression expressionLeft;
    Expression expressionRight;

    public Plus(Expression expressionLeft, Expression expressionRight) {
        this.expressionLeft = expressionLeft;
        this.expressionRight = expressionRight;
    }

    @Override
    public int intrepreter(Expression context) {
        return expressionLeft.intrepreter(context) + expressionRight.intrepreter(context);
    }
}

class Minus implements Expression {
    Expression expressionLeft;
    Expression expressionRight;

    public Minus(Expression expressionLeft, Expression expressionRight) {
        this.expressionLeft = expressionLeft;
        this.expressionRight = expressionRight;
    }

    @Override
    public int intrepreter(Expression context) {
        return expressionLeft.intrepreter(context) - expressionRight.intrepreter(context);
    }
}

class Evaluate implements Expression {

    Expression evaluate;

    public Evaluate(String expression) {
        Stack<Expression> expressions = new Stack<>();
        String expressionRever = new StringBuilder(expression).reverse().toString();
        for (String s : expressionRever.split("\\D")) {
            expressions.push(new Number(Integer.parseInt(s)));
        }

        for (String s : expression.split("\\d")) {
            if (s.equals("+")) {
                expressions.push(new Plus(expressions.pop(), expressions.pop()));
            } else if (s.equals("-")) {
                expressions.push(new Minus(expressions.pop(), expressions.pop()));
            }
        }
        evaluate = expressions.pop();
    }

    @Override
    public int intrepreter(Expression context) {
        return evaluate.intrepreter(context);
    }
}