package hk.edu.polyu.comp.comp2021.simple.model;

@SuppressWarnings("ALL")
public class binexpr extends Expression{
    private final expName exp;


    public binexpr(String[] array,Simple simple){
        super(commandID.BINEXPR);
        if(array.length != 5) throw new IllegalArgumentException("the number of the parameters of binexpr is wrong");
        String bop = array[3];
        expName expRef1 = new expName(array[2]);
        expName expRef2 = new expName(array[4]);
        exp = new BinExpName(array[1],Type.valueOf("int"), expRef1, bop, expRef2);
        if(simple.getExpMap().containsKey(exp.getName())) throw new IllegalArgumentException("the name of the expName in binexpr command already existed");

    }


    public static void setExpAndExpRef(BinExpName exp,Simple simple){
        String bop = exp.getBop();
        exp.setExpRef1(expName.setExpRef(exp.getExpRef1().getName(),simple));
        exp.setExpRef2(expName.setExpRef(exp.getExpRef2().getName(),simple));
        if(!Expression.judgeInt(bop)){
            exp.setType(Type.valueOf("bool"));
        }
        exp.setValue();
    }

    @Override
    public commandID getId() {return commandID.BINEXPR;}

    @Override
    public boolean haveLabel() {return false;}

    @Override
    public Label getLab() {return null;}

    @Override
    public boolean haveExpName() {return true;}

    @SuppressWarnings("unused")
    @Override
    public expName getExpName() {return exp;}

    @Override
    public boolean haveVrName() {return false;}

    @Override
    public varName getVarName() {return null;}
}
