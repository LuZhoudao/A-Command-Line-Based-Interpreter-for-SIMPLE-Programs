package hk.edu.polyu.comp.comp2021.simple.model;


@SuppressWarnings("ALL")
public enum BinaryOperator {
    @SuppressWarnings("MissingJavadoc") ADD("+"), @SuppressWarnings("MissingJavadoc") SUB("-"), @SuppressWarnings("MissingJavadoc") MUL("*"), @SuppressWarnings("MissingJavadoc") DIV("/"), @SuppressWarnings("MissingJavadoc") REM("%"), @SuppressWarnings("MissingJavadoc") LARGE(">"), @SuppressWarnings("MissingJavadoc") LARGEEQAUAL(">="), @SuppressWarnings("MissingJavadoc") LITTLE("<"), @SuppressWarnings("MissingJavadoc") ITTLEEQUAL("<="), @SuppressWarnings("MissingJavadoc") EQUAL("=="), @SuppressWarnings("MissingJavadoc") NOTEQUAL("!="), @SuppressWarnings("MissingJavadoc") AND("&&"), @SuppressWarnings("MissingJavadoc") OR("||");;

    private final String symbol;

    BinaryOperator(String symbol) {this.symbol = symbol;}

    @SuppressWarnings({"ChainOfInstanceofChecks", "MissingJavadoc"})
    public static Object calculate(Object num1, Object num2, String symbol) {
        Object result = null;
        if(num1 instanceof Integer && num2 instanceof  Integer){
            switch(symbol){
                case "+":
                    result =  (Integer) num1 + (Integer) num2;
                    break;
                case "-":
                    result = (Integer) num1 - (Integer) num2;
                    break;
                case "*":
                    result = (Integer) num1 * (Integer) num2;
                    break;
                case "/":
                    result = (Integer) num1 / (Integer) num2;
                    break;
                case "%":
                    result = (Integer) num1 % (Integer) num2;
                    break;
                case ">":
                    result = (Integer) num1 > (Integer) num2;
                    break;
                case ">=":
                    result = (Integer) num1 >= (Integer) num2;
                    break;
                case "<":
                    result = (Integer) num1 < (Integer) num2;
                    break;
                case "<=":
                    result = (Integer) num1 <= (Integer) num2;
                    break;
                case "==":
                    result = num1 ==  num2;
                    break;
                case "!=":
                    result = num1 != num2;
                    break;
                default:
                    throw new IllegalArgumentException("the operator is wrong");
            }
        }
        else if(num1 instanceof Boolean && num2 instanceof  Boolean){
            switch(symbol){
                case "==":
                    result = num1 == num2;
                    break;
                case "!=":
                    result = num1 != num2;
                    break;
                case "&&":
                    result = (Boolean)num1 && (Boolean)num2;
                    break;
                case "||":
                    result = (Boolean)num1 || (Boolean)num2;
                    break;
                default:
                    throw new IllegalArgumentException("the operator is wrong");
            }
        }
        else throw new IllegalArgumentException("the type of the two parameters are wrong");
        return result;
    }

}
