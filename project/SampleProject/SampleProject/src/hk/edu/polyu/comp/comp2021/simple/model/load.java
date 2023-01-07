package hk.edu.polyu.comp.comp2021.simple.model;

import java.io.*;

@SuppressWarnings("ALL")
public class load extends Command{
    @SuppressWarnings("PackageVisibleField")
    String path;
    @SuppressWarnings("PackageVisibleField")
    programName pro;
    protected load(String[] array,Simple simple) {
        super(commandID.LOAD);
        if(array.length != 3) throw new IllegalArgumentException("the number of the parameters of load is wrong");
        path = array[1];
        pro = new programName(array[2]);
        String path = getPath() + ".txt";
        File filename = new File(path);
        InputStreamReader reader;
        try {
            reader = new InputStreamReader(new FileInputStream(filename));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        BufferedReader br = new BufferedReader(reader);
        String line;
        do {
            try {
                line = br.readLine();
                if (line == null) break;
                if(line.substring(0,7).equals("program")){
                    int firstSpace = line.indexOf(" ");
                    int lastSpace = line.lastIndexOf(" ");
                    line = line.substring(0,firstSpace+1)+array[2]+line.substring(lastSpace);
                }
                Command com = Command.decide(line, simple);
                if(com.getId() == commandID.PROGRAM){
                    ((program)com).setStatementLab(simple);
                    simple.getProMap().put(getPro().getName(),((program)com).getStatementLab());
                }
                simple.addInMap(com);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } while (true);
    }

    public String getPath(){return path;}

    public programName getPro(){return pro;}

    @Override
    public commandID getId() {return commandID.LOAD;}

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
