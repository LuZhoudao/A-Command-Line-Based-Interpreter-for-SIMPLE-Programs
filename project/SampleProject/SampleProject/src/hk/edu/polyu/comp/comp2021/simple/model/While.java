package hk.edu.polyu.comp.comp2021.simple.model;

@SuppressWarnings("ALL")
public class While extends Command{
    private Label lab;
    private expName expRef;
    private Label statementLab1;
    protected While(String[] array,Simple simple) {
        super(commandID.WHILE);
        if(array.length != 4) throw new IllegalArgumentException("the number of the parameters of while is wrong");
        lab = new Label(array[1]);
        if(simple.getLabMap().containsKey(lab.getName())) throw new IllegalArgumentException("the name of the label in while command ablready existed");

        expRef = new expName(array[2]);
        statementLab1 = new Label(array[3]);
    }
    public void setExpRefAndStatementLab(Simple simple) {
        expRef = expName.setExpRef(expRef.getName(),simple);
        statementLab1 = Label.setStatementLab(statementLab1.getName(),simple);
    }
    public expName getCondition(){return expRef;}

    public Label getStatementLab1(){return statementLab1;}

    @Override
    public commandID getId() {
        return commandID.WHILE;
    }

    @Override
    public boolean haveLabel() {
        return true;
    }

    @Override
    public Label getLab() {
        return lab;
    }

    @Override
    public boolean haveExpName() {return false;}

    @Override
    public expName getExpName() {
        return null;
    }

    @Override
    public boolean haveVrName() {
        return false;
    }

    @Override
    public varName getVarName() {
        return null;
    }
}
