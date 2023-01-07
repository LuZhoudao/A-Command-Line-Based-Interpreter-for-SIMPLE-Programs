package hk.edu.polyu.comp.comp2021.simple.model;

@SuppressWarnings("ALL")
public class UnExpName extends expName{
    private expName expRef;
    private String uop;
    public UnExpName(String name, Type type,expName expRef,String uop) {
        super(name);
        super.setVarID(varID.UNEXPNAME);
        super.setType(type);
        this.expRef = expRef;
        this.uop = uop;
    }
    public void setValue(){
        setTypeValue(String.valueOf(UnaryOperator.calculate(expRef.getType().getValue(),uop)));
    }

    public String getBop(){return uop;}

    public expName getExpRef(){return expRef;}

    public void setExpRef1(expName exp){
        expRef = exp;
    }
}
