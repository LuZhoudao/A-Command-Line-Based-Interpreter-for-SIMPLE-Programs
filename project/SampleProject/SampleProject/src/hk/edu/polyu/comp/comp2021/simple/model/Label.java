package hk.edu.polyu.comp.comp2021.simple.model;

@SuppressWarnings("ALL")
public class Label extends Variable{
    public Label(String name) {
        super(name,varID.LABEL);
    }

    public static Label setStatementLab(String name,Simple simple){
        Label StatementLab;
        if(simple.getLabMap().containsKey(name)){
            StatementLab = simple.getLabMap().get(name).getLab();
        }
        else throw new IllegalArgumentException("the statementLab is missed");
        return StatementLab;
    }

}
