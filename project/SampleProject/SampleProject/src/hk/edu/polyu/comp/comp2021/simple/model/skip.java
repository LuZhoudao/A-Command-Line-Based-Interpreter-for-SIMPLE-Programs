package hk.edu.polyu.comp.comp2021.simple.model;

@SuppressWarnings("ALL")
public class skip extends Command{
    private Label lab;
    protected skip(String[] array,Simple simple) {
        super(commandID.SKIP);
        if(array.length != 2) throw new IllegalArgumentException("the number of the parameters of skip is wrong");
        lab = new Label(array[1]);
        if(simple.getLabMap().containsKey(lab.getName())) throw new IllegalArgumentException("the name of the label in skip command ablready existed");

    }

    @Override
    public commandID getId() {return commandID.SKIP;}

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
