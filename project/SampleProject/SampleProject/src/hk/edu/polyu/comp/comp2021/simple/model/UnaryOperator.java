package hk.edu.polyu.comp.comp2021.simple.model;

@SuppressWarnings("ALL")
public enum UnaryOperator {
    ADD("#"),SUB("~"),NOT("!");

    private final String symbol;

    UnaryOperator(String symbol) {this.symbol = symbol;}

    public static Object calculate(Object num1,String symbol) {
        Object result = null;
        //noinspection ChainOfInstanceofChecks
        if(num1 instanceof Integer){
            switch(symbol){
                case "#":
                    result =   num1 ;
                    break;
                case "~":
                    result = -(Integer) num1 ;
                    break;
                default:
                    throw new IllegalArgumentException("the operator is wrong");
            }
        }
        else if(num1 instanceof Boolean){
            switch(symbol){
                case "!":
                    result = !(Boolean)num1;
                    break;
                default:
                    throw new IllegalArgumentException("the operator is wrong");
            }
        }
        else throw new IllegalArgumentException("the type of the parameter is wrong");
        return result;
    }
}
