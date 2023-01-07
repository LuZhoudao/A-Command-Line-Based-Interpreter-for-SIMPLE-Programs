package hk.edu.polyu.comp.comp2021.simple.model;

import java.util.ArrayList;
import java.util.Scanner;

@SuppressWarnings("ALL")
public class execute extends Command{
    private programName pro;
    private final Label proStatementLab;
    private ArrayList<Label> labelList = new ArrayList<>();
    protected execute(String[] array,Simple simple) {
        super(commandID.EXECUTE);
        if(array.length != 2) throw new IllegalArgumentException("the number of the parameters of execute is wrong");
        if(simple.getProMap().containsKey(array[1])) {
            pro = new programName(array[1]);
        }
        else throw new IllegalArgumentException("the program name of the execute command is wrong");
        proStatementLab = program.getStatementLab(array[1],simple);
        if(!block.isBlock(proStatementLab,simple)) labelList.add(proStatementLab);
        else{
            if((Command.findCommand(proStatementLab, simple)).getInstumentSet().contains(pro.getName())){
                (Command.findCommand(proStatementLab, simple)).updateInstrumentMap(simple);
                (Command.findCommand(proStatementLab, simple)).beforeInstrument();
            }
            labelList = ((block)Command.findCommand(proStatementLab,simple)).getLabList();
        }
        Execute(getLabelList(),simple,pro);
        if((Command.findCommand(proStatementLab, simple)).getInstumentSet().contains(pro.getName())){
            (Command.findCommand(proStatementLab, simple)).updateInstrumentMap(simple);
            (Command.findCommand(proStatementLab, simple)).afterInstrument();
        }
        System.out.println();
    }

    public void Execute(ArrayList<Label> labelList,Simple simple,programName pro) {
        for (Label label : labelList) {
            Command comm = Command.findCommand(label, simple);
            if(comm.getBreakSet().contains(pro.getName())){
               Command op;
               Scanner sc = new Scanner(System.in);
               do{
                   String input = sc.nextLine();
                   op = Command.decide(input,simple);
               }while (op.getId() != commandID.DEBUG);
            }
            if(comm.getInstumentSet().contains(pro.getName())){
                comm.updateInstrumentMap(simple);
                comm.beforeInstrument();
            }
            switch (comm.getId()) {
                case VARDEF -> ((vardef) comm).setVar();
                case ASSIGN -> {
                    ((assign) comm).setVarAndExpRef(simple);
                }
                case PRINT -> {
                    ((print) comm).setExpRef(simple);
                    System.out.print("[" + ((print) comm).printExp().getType().getValue() + "]");
                }
                case BLOCK -> {
                    ((block) comm).setLabList(simple);
                    Execute(((block) Command.findCommand(proStatementLab, simple)).getLabList(), simple,getPro());
                }
                case IF -> {
                    ((If) comm).setExpRefAndStatementLab(simple);
                    expName condition = ((If) comm).getCondition();
                    if(condition.getType().getValue() instanceof Boolean){
                        if ((Boolean) (condition.getType().getValue())) {
                            if(Command.findCommand(((If) comm).getStatementLab1(),simple).getInstumentSet().contains(pro.getName()) && block.isBlock(((If) comm).getStatementLab1(),simple)){
                                Command.findCommand(((If) comm).getStatementLab1(),simple).updateInstrumentMap(simple);
                                Command.findCommand(((If) comm).getStatementLab1(),simple).beforeInstrument();
                            }

                            ArrayList<Label> temp = block.reGetLabList(((If) comm).getStatementLab1(), simple);
                            Execute(temp, simple,getPro());
                            if(Command.findCommand(((If) comm).getStatementLab1(),simple).getInstumentSet().contains(pro.getName()) && block.isBlock(((If) comm).getStatementLab1(),simple)){
                                Command.findCommand(((If) comm).getStatementLab1(),simple).afterInstrument();
                                }
                        } else {
                            if(Command.findCommand(((If) comm).getStatementLab2(),simple).getInstumentSet().contains(pro.getName()) && block.isBlock(((If) comm).getStatementLab2(),simple)){
                                Command.findCommand(((If) comm).getStatementLab2(),simple).updateInstrumentMap(simple);
                                Command.findCommand(((If) comm).getStatementLab2(),simple).beforeInstrument();
                            }
                            ArrayList<Label> temp = block.reGetLabList(((If) comm).getStatementLab2(), simple);
                            Execute(temp, simple,getPro());
                            if(Command.findCommand(((If) comm).getStatementLab2(),simple).getInstumentSet().contains(pro.getName()) && block.isBlock(((If) comm).getStatementLab2(),simple)){
                                Command.findCommand(((If) comm).getStatementLab2(),simple).afterInstrument();
                            }
                        }
                    }
                    else throw new IllegalArgumentException("the condition of the if command isn't a boolean");

                }
                case WHILE -> {
                    ((While) comm).setExpRefAndStatementLab(simple);
                    expName condition2 = ((While) comm).getCondition();
                    if(condition2.getType().getValue() instanceof Boolean) {
                        while ((Boolean) (condition2.getType().getValue())) {
                            ((While) comm).setExpRefAndStatementLab(simple);
                            ArrayList<Label> temp = block.reGetLabList(((While) comm).getStatementLab1(), simple);
                            if(Command.findCommand(((While) comm).getStatementLab1(),simple).getInstumentSet().contains(pro.getName()) && block.isBlock(((While) comm).getStatementLab1(),simple)){
                                Command.findCommand(((While) comm).getStatementLab1(),simple).updateInstrumentMap(simple);
                                Command.findCommand(((While) comm).getStatementLab1(),simple).beforeInstrument();
                            }
                            Execute(temp, simple,getPro());
                            if(Command.findCommand(((While) comm).getStatementLab1(),simple).getInstumentSet().contains(pro.getName()) && block.isBlock(((While) comm).getStatementLab1(),simple)){
                                Command.findCommand(((While) comm).getStatementLab1(),simple).afterInstrument();
                            }
                        }
                    }
                    else throw new IllegalArgumentException("the condition of the while command isn't a boolean");

                }
            }
            if(comm.getInstumentSet().contains(pro.getName())){
                comm.afterInstrument();
            }
            simple.addInMap(comm);

        }

    }

    public programName getPro(){return pro;}
    public ArrayList<Label> getLabelList(){return labelList;}


    @Override
    public commandID getId() {return commandID.EXECUTE;}

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
