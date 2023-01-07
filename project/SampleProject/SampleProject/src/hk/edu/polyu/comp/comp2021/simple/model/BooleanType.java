package hk.edu.polyu.comp.comp2021.simple.model;

@SuppressWarnings("ALL")
public class BooleanType extends Type{
    @SuppressWarnings("PackageVisibleField")
    boolean value;
    public BooleanType() {super(TypeID.BOOL);}

    public void setValue(String value){
        if(value.equals("true")) this.value = true;
        else if(value.equals("false")) this.value = false;
        else throw new IllegalArgumentException("the boolean value is wrong");


    }

    public Boolean getValue(){
        return value;
    }
}
