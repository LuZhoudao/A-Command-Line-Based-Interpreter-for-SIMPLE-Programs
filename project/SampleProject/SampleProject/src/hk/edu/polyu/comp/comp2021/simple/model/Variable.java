package hk.edu.polyu.comp.comp2021.simple.model;

import java.util.ArrayList;
import java.util.Arrays;

import static hk.edu.polyu.comp.comp2021.simple.model.Command.commandList;

@SuppressWarnings("ALL")
public class Variable {
    private String name;
    private varID id;

    public Variable(String name,varID id){
        if(isRight(name)) this.name = name;
        else throw new IllegalArgumentException("the format of the name is wrong.");
        this.id = id;
    }

    public String getName(){return name;}

    public varID getId() {return id;}

    //判断变量是否符合格式
    private boolean isRight(String name){
        int len = name.length();
        if(len > 8) return false;
        ArrayList<String> keywords = commandList;
        keywords.addAll(new ArrayList<String>(Arrays.asList("int","bool")));
        if(keywords.contains(name)) return false;
        for(int i = 0;i < name.length();i++){
            if(i == 0 && name.charAt(0) == '-') continue;
            if(!Character.isLetterOrDigit(name.charAt(i))) return false;

        }
        return true;
    }
    public void setVarID(varID id){this.id = id;}

    public enum varID{
        EXPNAME,VARNAME,BINEXPNAME,UNEXPNAME,LABEL;
    }
}
