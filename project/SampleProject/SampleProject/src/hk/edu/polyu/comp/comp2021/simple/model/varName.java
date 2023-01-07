package hk.edu.polyu.comp.comp2021.simple.model;

@SuppressWarnings("ALL")
public class varName extends Variable {
    private Type type;

    public varName(String name){
        super(name,varID.VARNAME);
    }

    public void setType(Type type){
        this.type = type;
    }

    public Type getType() {return type;}
}
