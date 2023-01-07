package hk.edu.polyu.comp.comp2021.simple.model;

@SuppressWarnings("ALL")
public class IntType extends Type{
    private int value;
    public IntType() {
        super(TypeID.INT);
    }

    @SuppressWarnings("override")
    public void setValue(String value){
        for(int i = 0;i < value.length();i++){
            if(i == 0 && value.charAt(0) == '-') continue;
            if(!Character.isDigit(value.charAt(i))) throw new IllegalArgumentException("the value to set is not a number");
        }
        int num = Integer.valueOf(value);
        if(num > 99999) num = 99999;
        else if (num < -99999) num = -99999;

        this.value = num;

    }

    @SuppressWarnings("override")
    public Integer getValue(){
        return value;
    }

}
