package hk.edu.polyu.comp.comp2021.simple.model;


@SuppressWarnings("ALL")
public class If extends Command{
    private Label lab;
    private expName expRef;
    private Label statementLab1;
    private Label statementLab2;
    protected If(String[] array,Simple simple) {
        super(commandID.IF);
        if(array.length != 5) throw new IllegalArgumentException("the number of the parameters of if is wrong");
        lab = new Label(array[1]);
        if(simple.getLabMap().containsKey(lab.getName())) throw new IllegalArgumentException("the name of the label in if command ablready existed");
        expRef = new expName(array[2]);
        statementLab1 = new Label(array[3]);
        statementLab2 = new Label(array[4]);
    }
    public void setExpRefAndStatementLab(Simple simple){
        expRef = expName.setExpRef(expRef.getName(),simple);
        statementLab1 = Label.setStatementLab(statementLab1.getName(),simple);
        statementLab2 = Label.setStatementLab(statementLab2.getName(),simple);
    }
    public expName getCondition(){return expRef;}

    public Label getStatementLab1(){return statementLab1;}

    public Label getStatementLab2(){return statementLab2;}

    @Override
    public commandID getId() {return commandID.IF;}

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
