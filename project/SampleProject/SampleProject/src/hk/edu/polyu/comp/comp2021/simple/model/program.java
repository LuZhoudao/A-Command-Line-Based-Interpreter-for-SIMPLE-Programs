package hk.edu.polyu.comp.comp2021.simple.model;

@SuppressWarnings("ALL")
public class program extends Command{
    private programName pro;
    private Label statementLab;
    protected program(String[] array,Simple simple) {
        super(commandID.PROGRAM);
        if(array.length != 3) throw new IllegalArgumentException("the number of the parameters of program is wrong");
        pro = new programName(array[1]);
        statementLab = new Label(array[2]);
        setStatementLab(simple);
        simple.getProMap().put(getPro().getName(),getStatementLab());
    }
    public void setStatementLab(Simple simple){
        statementLab = Label.setStatementLab(statementLab.getName(),simple);
    }
    public static Label getStatementLab(String name,Simple simple){
        if(simple.getProMap().containsKey(name)){
            return simple.getProMap().get(name);
        }
        else throw new IllegalArgumentException("the name of the program which is wanted to execute or debug is wrong");
    }
    public programName getPro(){return pro;}
    public Label getStatementLab(){return statementLab;}
    @Override
    public commandID getId() {return commandID.PROGRAM;}
    @Override
    public boolean haveLabel() {return false;}

    @Override
    public Label getLab() {return null;}

    @Override
    public boolean haveExpName() {return false;}

    @Override
    public expName getExpName() {return null;}

    @Override
    public boolean haveVrName() {return false;}

    @Override
    public varName getVarName() {return null;}
}
