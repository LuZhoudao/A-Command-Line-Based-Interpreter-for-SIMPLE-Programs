package hk.edu.polyu.comp.comp2021.simple.model;

@SuppressWarnings("ALL")
public class debug extends Command{
    private programName pro;
    protected debug(String[] array,Simple simple) {
        super(commandID.DEBUG);
        if(array.length != 2) throw new IllegalArgumentException("the number of the parameters of debug is wrong");
        if(simple.getProMap().containsKey(array[1])) {
            pro = new programName(array[1]);
        }
        else throw new IllegalArgumentException("the program name of the debug command is wrong");
    }

    protected debug(commandID id) {
        super(id);
    }




    public programName getPro(){return pro;}

    public void setPro(programName pro){this.pro = pro;}
    @Override
    public commandID getId() {return commandID.DEBUG;}

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

@SuppressWarnings("ALL")
class togglebreakpoint extends Command{
    private programName pro;
    protected togglebreakpoint(String[] array,Simple simple) {
        super(commandID.TOGGLEBREAKPOINT);
        if(array.length != 3) throw new IllegalArgumentException("the number of the parameters of togglebreakpoint is wrong");
        if(simple.getProMap().containsKey(array[1])) {
            pro = new programName(array[1]);
        }
        else throw new IllegalArgumentException("the program name of the togglebreakpoint command is wrong");
        if(simple.getLabMap().containsKey(array[2])){
            if (simple.getLabMap().get(array[2]).getBreakSet().contains(pro.getName())) {
                simple.getLabMap().get(array[2]).getBreakSet().remove(pro.getName());
            } else {
                simple.getLabMap().get(array[2]).getBreakSet().add(pro.getName());
            }
        }
        else throw new IllegalArgumentException("the label name of the togglebreakpoint is wrong or doesn't exist");
    }

    public programName getPro(){return pro;}

    @Override
    public commandID getId() {return commandID.TOGGLEBREAKPOINT;}

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

@SuppressWarnings("ALL")
class inspect extends debug{
    private programName pro;
    private varName var;
    protected inspect(String[] array,Simple simple) {
        super(commandID.INSPECT);
        if(array.length != 3) throw new IllegalArgumentException("the number of the parameters of inspect is wrong");
        if(simple.getProMap().containsKey(array[1])) pro = new programName(array[1]);
        else throw new IllegalArgumentException("the program name of the debug is wrong or doesn't exist ");
        if(simple.getVarMap().containsKey(array[2])) var = simple.getVarMap().get(array[2]);
        else throw new IllegalArgumentException("the name of the varName doesn't exist");
        System.out.println("<"+var.getType().getValue()+">");
    }
    public programName getPro(){return pro;}

    @Override
    public commandID getId() {return commandID.INSPECT;}

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
