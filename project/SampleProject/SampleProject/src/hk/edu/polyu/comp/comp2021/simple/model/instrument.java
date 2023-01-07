package hk.edu.polyu.comp.comp2021.simple.model;

@SuppressWarnings("MissingJavadoc")
public class instrument extends Command{
    @SuppressWarnings("MissingJavadoc")
    protected instrument(String[] array, Simple simple) {
        super(commandID.INSTRUMENT);
        if(array.length != 5) throw new IllegalArgumentException("the number of the parameters of instrument is wrong");
        if(simple.getProMap().containsKey(array[1])) {
            simple.getLabMap().get(array[2]).getInstumentSet().add(array[1]);
        }
        else throw new IllegalArgumentException("the program name of the instrument command is wrong");
        String pos = array[3];
        if(!(pos.equals("after") || pos.equals("before"))) throw new IllegalArgumentException("for instrument, the fourth parameter should be either 'after' or 'before'");
        expName expRef = new expName(array[4]);
        if(simple.getLabMap().containsKey(array[2])){
            simple.getLabMap().get(array[2]).getInstrumentMap().put(expRef, pos);
        }
        else throw new IllegalArgumentException("the name of statementLab of the instrument command isn't correct");

    }



    @Override
    public commandID getId() {return commandID.INSTRUMENT;}

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
