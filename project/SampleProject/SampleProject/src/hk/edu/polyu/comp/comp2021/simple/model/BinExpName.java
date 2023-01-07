package hk.edu.polyu.comp.comp2021.simple.model;

@SuppressWarnings("ALL")
public class BinExpName extends expName {
    private expName expRef1;
    private String bop;
    private expName expRef2;


    @SuppressWarnings("MissingJavadoc")
    public BinExpName(String name, Type type, expName expRef1, String bop, expName expRef2) {
        super(name);
        super.setVarID(varID.BINEXPNAME);
        super.setType(type);
        this.expRef1 = expRef1;
        this.bop = bop;
        this.expRef2 = expRef2;
    }

    @SuppressWarnings("MissingJavadoc")
    public void setValue(){
        setTypeValue(String.valueOf(BinaryOperator.calculate(expRef1.getType().getValue(),expRef2.getType().getValue(),bop)));
    }

    @SuppressWarnings("MissingJavadoc")
    public String getBop(){return bop;}

    @SuppressWarnings("MissingJavadoc")
    public expName getExpRef1(){return expRef1;}

    @SuppressWarnings("MissingJavadoc")
    public expName getExpRef2(){return expRef2;}

    @SuppressWarnings("MissingJavadoc")
    public void setExpRef1(expName exp){
        this.expRef1 = exp;
    }

    @SuppressWarnings("MissingJavadoc")
    public void setExpRef2(expName exp){
        this.expRef2 = exp;
    }



}
