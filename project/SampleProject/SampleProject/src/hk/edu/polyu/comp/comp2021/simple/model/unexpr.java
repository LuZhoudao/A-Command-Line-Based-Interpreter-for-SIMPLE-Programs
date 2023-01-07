package hk.edu.polyu.comp.comp2021.simple.model;

@SuppressWarnings("ALL")
public class unexpr extends Expression{
    private UnExpName exp;

    protected unexpr(String[] array,Simple simple) {
        super(commandID.UNEXPR);
        if(array.length != 4) throw new IllegalArgumentException("the number of the parameters of unexpr is wrong");
        expName expRef1 = new expName(array[3]);
        exp = new UnExpName(array[1],Type.valueOf("int"),expRef1,array[2]);
        if(simple.getExpMap().containsKey(exp.getName())) throw new IllegalArgumentException("the name of the expName in unexpf command already existed");

    }


    public static void setExpAndExpRef(UnExpName exp,Simple simple){
        expName expRef1 = exp.getExpRef();
        String uop = exp.getBop();
        exp.setExpRef1(expName.setExpRef(expRef1.getName(),simple));
        if(!Expression.judgeInt(uop)){
            exp.setType(Type.valueOf("bool"));
        }
        exp.setValue();
    }


    @Override
    public commandID getId() {return commandID.UNEXPR;}

    @Override
    public boolean haveLabel() {return false;}

    @Override
    public Label getLab() {return null;}

    @Override
    public boolean haveExpName() {return true;}

    @Override
    public expName getExpName() {return exp;}

    @Override
    public boolean haveVrName() {return false;}

    @Override
    public varName getVarName() {return null;}
}
