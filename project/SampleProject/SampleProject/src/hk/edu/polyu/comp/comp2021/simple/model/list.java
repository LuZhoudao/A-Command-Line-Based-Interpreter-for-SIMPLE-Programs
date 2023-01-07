package hk.edu.polyu.comp.comp2021.simple.model;

import java.util.ArrayList;

@SuppressWarnings("MissingJavadoc")
public class list extends Command{
    private final programName pro;
    private final ArrayList<String> commandList = new ArrayList<>();

    @SuppressWarnings("MissingJavadoc")
    public list(String[] array, Simple simple) {
        super(commandID.LIST);
        if(array.length != 2) throw new IllegalArgumentException("the number of the parameters of list is wrong");
        if(simple.getProMap().containsKey(array[1])) {
            pro = new programName(array[1]);
        }
        else throw new IllegalArgumentException("the program name of the list command is wrong");
        String name = getPro().getName();
        setLabelList(this, name, simple);
    }
    @SuppressWarnings("MissingJavadoc")
    public programName getPro(){return pro;}
    @SuppressWarnings("MissingJavadoc")
    public ArrayList<String> getCommandList(){return commandList;}
    @SuppressWarnings("MissingJavadoc")
    public void setLabelList(list operation, String name, Simple simple){
        if(simple.getToListMap().containsKey(name)) {
            String temp = simple.getToListMap().get(name);
            String[] array = temp.split(" ");
            if (array.length > 2) {
                for (int i = 2; i < array.length; i++) {
                    setLabelList(operation, array[i], simple);
                }
            }
            operation.getCommandList().add(temp);
        }
    }
    @Override
    public commandID getId() {return commandID.LIST;}

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
