package hk.edu.polyu.comp.comp2021.simple.model;

import java.util.HashMap;
import java.util.Scanner;

@SuppressWarnings("ALL")
public class Simple {
    private HashMap<String,Command> labMap;
    private HashMap<String,expName> expMap;
    private HashMap<String,varName> varMap;
    private HashMap<String,Label> proMap;
    private HashMap<String,String> toListMap;
    public boolean isDebug = false;
    public debug de;
    public Simple(){
        labMap = new HashMap<>();
        expMap = new HashMap<>();
        varMap = new HashMap<>();
        proMap = new HashMap<>();
        toListMap = new HashMap<>();
    }
    public void run(){
        Scanner sc = new Scanner(System.in);
        Command operation;
        do {
            String input = sc.nextLine();
            operation = Command.decide(input,this);
            Command.commandID id = operation.getId();
            if(id == Command.commandID.QUIT){
                break;
            }
            else if(id == Command.commandID.LIST){
                for(int i = 0;i < ((list)operation).getCommandList().size();i++)
                    System.out.println(((list) operation).getCommandList().get(i));
            }
            else if(id == Command.commandID.DEBUG){
                String[] executeArray = new String[]{"execute ",((debug)operation).getPro().getName()};
                execute exe = new execute(executeArray,this);
                isDebug = false;
            }
            addInMap(operation);
        } while(true);
    }
    public void setDe(debug de) {this.de = de;}
    public void addInMap(Command operation) {
        if (operation.haveLabel()) {
            if (isRight(operation.getLab().getName())) this.getLabMap().put(operation.getLab().getName(), operation);
            else throw new IllegalArgumentException("the format of the label is wrong");
        }
        if (operation.haveExpName()) {
            if (isRight(operation.getExpName().getName()))
                this.getExpMap().put(operation.getExpName().getName(), operation.getExpName());
            else throw new IllegalArgumentException("the format of the expName is wrong");
        }
        if (operation.haveVrName()) {
            if (isRight(operation.getVarName().getName()))
                this.getVarMap().put(operation.getVarName().getName(), operation.getVarName());
            else throw new IllegalArgumentException("the format of the varName is wrong");
        }
    }
    //for expRef,it can be true, false or a number, but a variable cannot. So this methos is to check a variable is in the right format
    private boolean isRight(String name){
        if(name.equals("true") || name.equals("false")|| !Character.isLetter(name.charAt(0))) return false;
        return true;
    }
    public HashMap<String, Command> getLabMap() { return labMap;}
    public HashMap<String, expName> getExpMap() { return expMap;}
    public HashMap<String, varName> getVarMap() { return varMap;}
    public HashMap<String,Label> getProMap() { return proMap;}
    public HashMap<String,String> getToListMap() { return toListMap;}


}
