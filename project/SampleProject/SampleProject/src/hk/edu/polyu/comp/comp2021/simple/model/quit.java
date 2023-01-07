package hk.edu.polyu.comp.comp2021.simple.model;

@SuppressWarnings("ALL")
public class quit extends Command{

    protected quit() {
        super(commandID.QUIT);
    }

    @Override
    public commandID getId() {return commandID.QUIT;}

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
