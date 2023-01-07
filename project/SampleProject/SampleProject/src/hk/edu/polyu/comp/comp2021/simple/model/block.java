package hk.edu.polyu.comp.comp2021.simple.model;

import java.util.ArrayList;

@SuppressWarnings("ALL")
public class block extends Command{
    private Label lab;
    private ArrayList<Label> labList = new ArrayList<>();
    protected block(String[] array,Simple simple) {
        super(commandID.BLOCK);
        if(array.length < 3) throw new IllegalArgumentException("the number of the parameters of block is wrong");
        lab = new Label(array[1]);
        if(simple.getLabMap().containsKey(lab.getName())) throw new IllegalArgumentException("the name of the label in block command ablready existed");
        int len = array.length;
        for(int i = 2;i < len;i++){
            labList.add(new Label(array[i]));
        }
    }
    public void setLabList(Simple simple) {
        for(int i = 0;i < labList.size();i++){
            labList.set(i,Label.setStatementLab(labList.get(i).getName(),simple));
        }
    }

    public static boolean isBlock(Label lab, Simple simple){
        if(simple.getLabMap().containsKey(lab.getName())){
           if(simple.getLabMap().get(lab.getName()).getId() == commandID.BLOCK){
               return true;
           }
           else return false;
        }
        else if(lab == null) return false;
        else throw new IllegalArgumentException();
    }
    public static ArrayList<Label> reGetLabList(Label lab,Simple simple){
        ArrayList<Label> temp = new ArrayList<>();
        if(!block.isBlock(lab,simple)){
            temp.add(lab);
        }
        else{
            temp = ((block)Command.findCommand(lab,simple)).getLabList();
        }
        return temp;
    }

    public ArrayList<Label> getLabList(){return labList;}

    @Override
    public commandID getId() {return commandID.BLOCK;}

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
