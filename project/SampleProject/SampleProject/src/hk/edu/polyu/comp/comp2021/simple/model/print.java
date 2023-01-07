package hk.edu.polyu.comp.comp2021.simple.model;

@SuppressWarnings("ALL")
public class print extends Command{
    private Label lab;
    private expName expRef;
    protected print(String[] array,Simple simple) {
        super(commandID.PRINT);
        if(array.length != 3) throw new IllegalArgumentException("the number of the parameters of print is wrong");
        lab = new Label(array[1]);
        if(simple.getLabMap().containsKey(lab.getName())) throw new IllegalArgumentException("the name of the label in print command ablready existed");
        expRef = new expName(array[2]);
    }
    public void setExpRef(Simple simple){
        expRef = expName.setExpRef(expRef.getName(),simple);
    }

    public expName printExp(){return expRef;}

    @Override
    public commandID getId() {return commandID.PRINT;}

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
