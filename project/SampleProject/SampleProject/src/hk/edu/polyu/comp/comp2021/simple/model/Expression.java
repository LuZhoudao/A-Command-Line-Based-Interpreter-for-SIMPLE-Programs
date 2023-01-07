package hk.edu.polyu.comp.comp2021.simple.model;

import java.util.ArrayList;
import java.util.Arrays;

@SuppressWarnings("ALL")
public abstract class Expression extends Command{

    public static final ArrayList<String> intSymbol = new ArrayList<>(Arrays.asList("+","-","*","/","%","#","~"));
    public static final ArrayList<String> boolSymbol = new ArrayList<>(Arrays.asList(">",">=","<","<=","==","!=","&&","||","!"));

    protected Expression(commandID id) {
        super(id);
    }


    public static boolean judgeInt(String s){
        if(intSymbol.contains(s)) return true;
        else if(boolSymbol.contains(s)) return false;
        else throw new IllegalArgumentException("the name of the operator is wrong");

    }

}
