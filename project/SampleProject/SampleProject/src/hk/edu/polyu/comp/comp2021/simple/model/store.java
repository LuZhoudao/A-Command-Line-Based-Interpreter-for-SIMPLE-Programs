package hk.edu.polyu.comp.comp2021.simple.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@SuppressWarnings("ALL")
public class store extends Command{
    private programName pro;
    private String path;
    protected store(String[] array,Simple simple) {
        super(commandID.STORE);
        if(array.length != 3) throw new IllegalArgumentException("the number of the parameters of store is wrong");
        if(simple.getProMap().containsKey(array[1])) {
            pro = new programName(array[1]);
        }
        else throw new IllegalArgumentException("the program name of the store command is wrong");
        path = array[2];
        String name = getPro().getName();
        String[] arr = new String[]{"list", name};
        list listCommand = new list(arr,simple);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < listCommand.getCommandList().size(); i++)
            sb.append((listCommand.getCommandList().get(i))).append("\n");
        File file = new File(getPath() + ".txt");
        // if file doesn't exist, then create it
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        FileWriter fw = null;
        try {
            fw = new FileWriter(file.getAbsoluteFile());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        BufferedWriter bw = new BufferedWriter(fw);
        try {
            bw.write(sb.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public programName getPro(){return pro;}

    public String getPath(){return path;}

    @Override
    public commandID getId() {return commandID.STORE;}

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
