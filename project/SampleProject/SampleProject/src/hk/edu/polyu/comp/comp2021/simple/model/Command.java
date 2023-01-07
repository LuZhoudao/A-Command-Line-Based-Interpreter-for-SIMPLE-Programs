package hk.edu.polyu.comp.comp2021.simple.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

@SuppressWarnings("ALL")
public abstract class Command {
    private final Command.commandID id;
    HashSet<String> breakSet = new HashSet<>();
    HashSet<String> instumentSet = new HashSet<>();
    @SuppressWarnings("PackageVisibleField")
    HashMap<expName,String> instrumentMap = new HashMap<>();
    private static final ArrayList<String>  noStoreCommand = new ArrayList<>(Arrays.asList("execute","list","store","load","quit","togglebreakpoint","debug","inspect"));
    public static final ArrayList<String> commandList = new ArrayList<>(Arrays.asList("vardef","binexpr","unexpr","assign","print","skip","block","if","while","program","execute","list","store","load","quit","togglebreakpoint","debug","inspect"));

    protected Command(commandID id) {
        this.id = id;
    }
    public HashSet<String> getBreakSet(){return breakSet;}
    public HashSet<String> getInstumentSet(){return instumentSet;}
    public HashMap<expName, String> getInstrumentMap(){return instrumentMap;}
    public void updateInstrumentMap(Simple simple){
         HashMap<expName,String> newMap = new HashMap<>();
        for(expName exp : getInstrumentMap().keySet()){
            newMap.put(expName.setExpRef(exp.getName(),simple),getInstrumentMap().get(exp));
        }
        instrumentMap = newMap;
    }
    public void beforeInstrument(){
        for(expName exp : getInstrumentMap().keySet() ){
            if(exp.getType() != null && getInstrumentMap().get(exp).equals("before")) System.out.print("{"+exp.getType().getValue()+"}");
        }
    }
    public void afterInstrument(){
        for(expName exp : getInstrumentMap().keySet() ){
            if(exp.getType() != null && getInstrumentMap().get(exp).equals("after")) System.out.print("{"+exp.getType().getValue()+"}");
        }
    }
    public abstract commandID getId();
    public abstract boolean haveLabel();
    public abstract Label getLab();
    public abstract boolean haveExpName();
    public abstract expName getExpName();
    public abstract boolean haveVrName();
    public abstract varName getVarName();

    public static Command decide(String input,Simple simple){
        Command result = null;
        if(input.startsWith("quit")){
            if(!input.equals("quit")) throw new IllegalArgumentException("the number of the parameters of quit is wrong");
            result = new quit();
            return result;
        }
        String[] array = input.split(" ");
        if(array.length == 1) throw new IllegalArgumentException("the number of parameters of this command is wrong");
        String commandOrExp = array[0];
        if(!noStoreCommand.contains(commandOrExp)){
            simple.getToListMap().put(array[1],input);
        }
        if(commandOrExp.equals("debug")){
            if(!simple.isDebug){
                simple.isDebug = true;
                result = new debug(array,simple);
                //noinspection ClassReferencesSubclass
                simple.setDe((debug)result);
            }
            else{
                if(array[1].equals(simple.de.getPro().getName())) result = simple.de;
                else throw new IllegalArgumentException("you can not debug two programs at the same time");
            }
        }
        else if(simple.isDebug && result == null){
            if(commandOrExp.equals("inspect")){
                result = new inspect(array,simple);
                if(!((inspect)result).getPro().getName().equals(simple.de.getPro().getName())) throw new IllegalArgumentException("you can not debug two programs at the same time");
            }
            else if(commandOrExp.equals("togglebreakpoint")){
                result = new togglebreakpoint(array,simple);
            }
            else throw new IllegalArgumentException("this is the debug model, you can just use 'insepect', 'togglebreakpoint' and 'debug' in this model");
        }
        else{
            result = switch (commandOrExp) {
                case "vardef" -> new vardef(array,simple);
                case "binexpr" -> new binexpr(array,simple);
                case "unexpr" -> new unexpr(array,simple);
                case "assign" -> new assign(array,simple);
                case "print" -> new print(array,simple);
                case "skip" -> new skip(array,simple);
                case "block" -> new block(array,simple);
                case "if" -> new If(array,simple);
                case "while" -> new While(array,simple);
                case "program" -> new program(array,simple);
                case "execute" -> new execute(array,simple);
                case "list" -> new list(array,simple);
                case "store" -> new store(array,simple);
                case "load" -> new load(array,simple);
                case "togglebreakpoint" -> new togglebreakpoint(array,simple);
                case "instrument" -> new instrument(array,simple);
                default -> throw new IllegalStateException("Unexpected value: " + commandOrExp);
            };
        }
        return result;
    }

    public static Command findCommand(Label lab,Simple simple){
        Command result;
        if(simple.getLabMap().containsKey(lab.getName())){
            result = simple.getLabMap().get(lab.getName());
        }
        else throw new IllegalArgumentException("you haven't used this command before.");
        return result;
    }

    public enum commandID{
        VARDEF("vardef"),BINEXPR("binexpr"),UNEXPR("unexpr"),ASSIGN("assign"),PRINT("print"),SKIP("skip"),BLOCK("block"),IF("if"),WHILE("while"),PROGRAM("program"),EXECUTE("execute"),LIST("list"),STORE("store"),LOAD("load"),QUIT("quit"),DEBUG("debug"),TOGGLEBREAKPOINT("togglebreakpoint"),INSPECT("inspect"),INSTRUMENT("instrument");
        private String id;
        commandID(String id) {
            this.id = id;
        }
    }
}
