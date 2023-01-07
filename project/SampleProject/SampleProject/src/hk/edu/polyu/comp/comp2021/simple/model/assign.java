package hk.edu.polyu.comp.comp2021.simple.model;

@SuppressWarnings("ALL")
public class assign extends Command{
    private Label lab;
    private varName var;
    private expName expRef1;

    @SuppressWarnings("MissingJavadoc")
    protected assign(String[] array,Simple simple) {
        super(commandID.ASSIGN);
        if(array.length != 4) throw new IllegalArgumentException("the number of the parameters of assign is wrong");
        lab = new Label(array[1]);
        if(simple.getLabMap().containsKey(lab.getName())) throw new IllegalArgumentException("the name of the label in assign command ablready existed");
        expRef1 = new expName(array[3]);
        var = new varName(array[2]);
    }

    @SuppressWarnings("MissingJavadoc")
    public void setVarAndExpRef(Simple simple){
        expRef1 = expName.setExpRef(expRef1.getName(),simple);
        var.setType(expRef1.getType());
        if (simple.getVarMap().containsKey(var.getName())) {
            simple.getVarMap().get(var.getName()).setType(getExpRef1().getType());
        }
        else  throw new IllegalArgumentException("the name of the varName doesn't exist");
    }

    @SuppressWarnings("MissingJavadoc")
    public expName getExpRef1(){return expRef1;}

    @Override
    public commandID getId() {return commandID.ASSIGN;}

    @Override
    public boolean haveLabel() {return true;}

    @Override
    public Label getLab() {return lab;}

    @Override
    public boolean haveExpName() {return false;}

    @Override
    public expName getExpName() {return null;}

    @Override
    public boolean haveVrName() {return false;}

    @Override
    public varName getVarName() {return null;}
}
