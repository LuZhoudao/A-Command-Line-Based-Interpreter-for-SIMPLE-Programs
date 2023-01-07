package hk.edu.polyu.comp.comp2021.simple.model;

@SuppressWarnings("ALL")
public class vardef extends Command {
    private Label lab;
    private Type typ;
    private varName var;


    public vardef(String[] array,Simple simple) {
        super(commandID.VARDEF);
        if(array.length != 5) throw new IllegalArgumentException("the number of the parameters of vardef is wrong");
        lab = new Label(array[1]);
        typ = Type.valueOf(array[2]);
        typ.setValue(array[4]);
        var = new varName(array[3]);
        if(simple.getVarMap().containsKey(var.getName())) throw new IllegalArgumentException("the name of the varName in vardef command already existed");
        if(simple.getLabMap().containsKey(lab.getName())) throw new IllegalArgumentException("the name of the label in vardef command ablready existed");
    }

    public void setVar(){
        var.setType(typ);
    }



    @Override
    public commandID getId() {return commandID.VARDEF;}

    @Override
    public boolean haveLabel() {return true;}

    @SuppressWarnings("override")
    public Label getLab(){return lab;}

    @Override
    public boolean haveExpName() {return false;}

    @Override
    public expName getExpName() {return null;}

    @Override
    public boolean haveVrName() {return true;}

    @Override
    public varName getVarName() {return var;}
}
