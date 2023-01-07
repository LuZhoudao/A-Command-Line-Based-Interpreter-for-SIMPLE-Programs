package hk.edu.polyu.comp.comp2021.simple.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


@SuppressWarnings("ALL")
public class SimpleTest {
    Simple simple;
    Command quit;
    Command vardef;
    Command binexpr;
    Command binexpr2;
    Command binexpr3;
    Command binexpr4;
    Command unexpr;
    Command assign;
    Command print,print2;
    Command skip;
    Command block;
    Command block2;
    Command if1,if2;
    Command while1;
    Command program,program2;
    Command execute,execute2;
    Command list;
    Command store;
    Command load;
    Command debug;
    Command togglebreakpoint;
    Command inspect;

    Command instrument;

    @Before
    public void initalize() {
        simple = new Simple();
        quit = new quit();
        String vardefStirng = "vardef vardef1 int x 0";
        String[] vardefArr = vardefStirng.split(" ");
        vardef = new vardef(vardefArr,simple);
        simple.addInMap(vardef);

        String binexprString = "binexpr exp1 x % 2";
        String[] binexprArr = binexprString.split(" ");
        binexpr = new binexpr(binexprArr,simple);
        simple.addInMap(binexpr);


        String binexprString2 = "binexpr exp2 exp1 == 0";
        String[] binexprArr2 = binexprString2.split(" ");
        binexpr2 = new binexpr(binexprArr2,simple);
        simple.addInMap(binexpr2);

        String binexprString3 = "binexpr exp3 x + 1";
        String[] binexprArr3 = binexprString3.split(" ");
        binexpr3 = new binexpr(binexprArr3,simple);
        simple.addInMap(binexpr3);

        String binexprString4 = "binexpr exp4 x <= 10";
        String[] binexprArr4 = binexprString4.split(" ");
        binexpr4 = new binexpr(binexprArr4,simple);
        simple.addInMap(binexpr4);

        String unexprString = "unexpr exp5 ! false";
        String[] unexprArr = unexprString.split(" ");
        unexpr = new unexpr(unexprArr,simple);
        simple.addInMap(unexpr);

        String assignString = "assign assign1 x exp3";
        String[] assignArr = assignString.split(" ");
        assign = new assign(assignArr,simple);
        simple.addInMap(assign);

        String printString = "print print1 x";
        String[] printArr = printString.split(" ");
        print = new print(printArr,simple);
        simple.addInMap(print);
        String printString2 = "print print2 0";
        String[] printArr2 = printString2.split(" ");
        print2 = new print(printArr2,simple);
        simple.addInMap(print2);

        String skipString = "skip skip1";
        String[] skipArr = skipString.split(" ");
        skip = new skip(skipArr,simple);
        simple.addInMap(skip);

        String blockStirng = "block block1 if1 assign1";
        String[] blockArr = blockStirng.split(" ");
        block = new block(blockArr,simple);
        simple.addInMap(block);
        String blockStirng2 = "block block2 vardef1 while1";
        String[] blockArr2 = blockStirng2.split(" ");
        block2 = new block(blockArr2,simple);
        simple.addInMap(block2);

        String ifString = "if if1 exp2 print1 skip1";
        String[] ifArr = ifString.split(" ");
        if1 = new If(ifArr,simple);
        simple.addInMap(if1);

        String ifString2 = "if if2 exp5 print2 skip1";
        String[] ifArr2 = ifString2.split(" ");
        if2 = new If(ifArr2,simple);
        simple.addInMap(if2);

        String whileString = "while while1 exp4 block1";
        String[] whileArr = whileString.split(" ");
        while1 = new While(whileArr,simple);
        simple.addInMap(while1);

        String programString = "program printeven block2";
        String[] programArr = programString.split(" ");
        program = new program(programArr,simple);
        simple.getProMap().put(((hk.edu.polyu.comp.comp2021.simple.model.program)program).getPro().getName(),((hk.edu.polyu.comp.comp2021.simple.model.program)program).getStatementLab());
        String programString2 = "program printunexpr if2";
        String[] programArr2 = programString2.split(" ");
        program2 = new program(programArr2,simple);
        simple.getProMap().put(((hk.edu.polyu.comp.comp2021.simple.model.program)program2).getPro().getName(),((hk.edu.polyu.comp.comp2021.simple.model.program)program2).getStatementLab());



        String executeString = "execute printeven";
        String[] executeArr = executeString.split(" ");
        execute = new execute(executeArr,simple);
        String executeString2 = "execute printunexpr";
        String[] executeArr2 = executeString2.split(" ");
        execute2 = new execute(executeArr2,simple);

        String listString = "list printeven";
        String[] listArr = listString.split(" ");
        list = new list(listArr,simple);

        String storeString = "store printeven J:/printeven.simple";
        String[] storeArr = storeString.split(" ");
        store = new store(storeArr,simple);

        String loadString = "load J:/printeven.simple printeven";
        String[] loadArr = loadString.split(" ");
        load = new load(loadArr,simple);


        String debugString = "debug printeven";
        String[] debugArr = debugString.split(" ");
        debug = new debug(debugArr,simple);

        String togglebreakpointStirng = "togglebreakpoint printeven if1";
        String[] togglebreakpointArr = togglebreakpointStirng.split(" ");
        togglebreakpoint = new togglebreakpoint(togglebreakpointArr,simple);

        String inspectString = "inspect printeven x";
        String[] inspectArr = inspectString.split(" ");
        inspect = new inspect(inspectArr,simple);

        String instrumentString = "instrument printeven if1 after x";
        String[] instrumentArr = instrumentString.split(" ");
        instrument = new instrument(instrumentArr,simple);

    }



    @Test
    public void testgetId(){
        Assert.assertTrue(quit.getId() == Command.commandID.QUIT);
        Assert.assertTrue(vardef.getId() == Command.commandID.VARDEF);
        Assert.assertTrue(binexpr.getId() == Command.commandID.BINEXPR);
        Assert.assertTrue(unexpr.getId() == Command.commandID.UNEXPR);
        Assert.assertTrue(assign.getId() == Command.commandID.ASSIGN);
        Assert.assertTrue(print.getId() == Command.commandID.PRINT);
        Assert.assertTrue(skip.getId() == Command.commandID.SKIP);
        Assert.assertTrue(block.getId() == Command.commandID.BLOCK);
        Assert.assertTrue(if1.getId() == Command.commandID.IF);
        Assert.assertTrue(while1.getId() == Command.commandID.WHILE);
        Assert.assertTrue(program.getId() == Command.commandID.PROGRAM);
        Assert.assertTrue(execute.getId() == Command.commandID.EXECUTE);
        Assert.assertTrue(list.getId() == Command.commandID.LIST);
        Assert.assertTrue(store.getId() == Command.commandID.STORE);
        Assert.assertTrue(load.getId() == Command.commandID.LOAD);
        Assert.assertTrue(debug.getId() == Command.commandID.DEBUG);
        Assert.assertTrue(togglebreakpoint.getId() == Command.commandID.TOGGLEBREAKPOINT);
        Assert.assertTrue(inspect.getId() == Command.commandID.INSPECT);
        Assert.assertTrue(instrument.getId() == Command.commandID.INSTRUMENT);
    }

    @Test
    public void testVarName(){
        Assert.assertFalse(quit.haveVrName());
        Assert.assertNull(quit.getVarName());
        Assert.assertTrue(vardef.haveVrName());
        Assert.assertNotNull(vardef.getVarName());
        Assert.assertFalse(binexpr.haveVrName());
        Assert.assertNull(binexpr.getVarName());
        Assert.assertFalse(unexpr.haveVrName());
        Assert.assertNull(unexpr.getVarName());
        Assert.assertFalse(assign.haveVrName());
        Assert.assertNull(assign.getVarName());
        Assert.assertFalse(print.haveVrName());
        Assert.assertNull(print.getVarName());
        Assert.assertFalse(skip.haveVrName());
        Assert.assertNull(skip.getVarName());
        Assert.assertFalse(block.haveVrName());
        Assert.assertNull(block.getVarName());
        Assert.assertFalse(if1.haveVrName());
        Assert.assertNull(if1.getVarName());
        Assert.assertFalse(while1.haveVrName());
        Assert.assertNull(while1.getVarName());
        Assert.assertFalse(program.haveVrName());
        Assert.assertNull(program.getVarName());
        Assert.assertFalse(execute.haveVrName());
        Assert.assertNull(execute.getVarName());
        Assert.assertFalse(list.haveVrName());
        Assert.assertNull(list.getVarName());
        Assert.assertFalse(store.haveVrName());
        Assert.assertNull(store.getVarName());
        Assert.assertFalse(load.haveVrName());
        Assert.assertNull(load.getVarName());
        Assert.assertFalse(debug.haveVrName());
        Assert.assertNull(debug.getVarName());
        Assert.assertFalse(togglebreakpoint.haveVrName());
        Assert.assertNull(togglebreakpoint.getVarName());
        Assert.assertFalse(inspect.haveVrName());
        Assert.assertNull(inspect.getVarName());
        Assert.assertFalse(instrument.haveVrName());
        Assert.assertNull(instrument.getVarName());
    }

    @Test
    public void testExpName(){
        Assert.assertFalse(quit.haveExpName());
        Assert.assertNull(quit.getExpName());
        Assert.assertFalse(vardef.haveExpName());
        Assert.assertNull(vardef.getExpName());
        Assert.assertTrue(binexpr.haveExpName());
        Assert.assertNotNull(binexpr.getExpName());
        Assert.assertTrue(unexpr.haveExpName());
        Assert.assertNotNull(unexpr.getExpName());
        Assert.assertFalse(assign.haveExpName());
        Assert.assertNull(assign.getExpName());
        Assert.assertFalse(print.haveExpName());
        Assert.assertNull(print.getExpName());
        Assert.assertFalse(skip.haveExpName());
        Assert.assertNull(skip.getExpName());
        Assert.assertFalse(block.haveExpName());
        Assert.assertNull(block.getExpName());
        Assert.assertFalse(if1.haveExpName());
        Assert.assertNull(if1.getExpName());
        Assert.assertFalse(while1.haveExpName());
        Assert.assertNull(while1.getExpName());
        Assert.assertFalse(program.haveExpName());
        Assert.assertNull(program.getExpName());
        Assert.assertFalse(execute.haveExpName());
        Assert.assertNull(execute.getExpName());
        Assert.assertFalse(list.haveExpName());
        Assert.assertNull(list.getExpName());
        Assert.assertFalse(store.haveExpName());
        Assert.assertNull(store.getExpName());
        Assert.assertFalse(load.haveExpName());
        Assert.assertNull(load.getExpName());
        Assert.assertFalse(debug.haveExpName());
        Assert.assertNull(debug.getExpName());
        Assert.assertFalse(togglebreakpoint.haveExpName());
        Assert.assertNull(togglebreakpoint.getExpName());
        Assert.assertFalse(inspect.haveExpName());
        Assert.assertNull(inspect.getExpName());
        Assert.assertFalse(instrument.haveExpName());
        Assert.assertNull(instrument.getExpName());
    }

    @Test
    public void testLabName(){
        Assert.assertFalse(quit.haveLabel());
        Assert.assertNull(quit.getLab());
        Assert.assertTrue(vardef.haveLabel());
        Assert.assertNotNull(vardef.getLab());
        Assert.assertFalse(binexpr.haveLabel());
        Assert.assertNull(binexpr.getLab());
        Assert.assertFalse(unexpr.haveLabel());
        Assert.assertNull(unexpr.getLab());
        Assert.assertTrue(assign.haveLabel());
        Assert.assertNotNull(assign.getLab());
        Assert.assertTrue(print.haveLabel());
        Assert.assertNotNull(print.getLab());
        Assert.assertTrue(skip.haveLabel());
        Assert.assertNotNull(skip.getLab());
        Assert.assertTrue(block.haveLabel());
        Assert.assertNotNull(block.getLab());
        Assert.assertTrue(if1.haveLabel());
        Assert.assertNotNull(if1.getLab());
        Assert.assertTrue(while1.haveLabel());
        Assert.assertNotNull(while1.getLab());
        Assert.assertFalse(program.haveLabel());
        Assert.assertNull(program.getLab());
        Assert.assertFalse(execute.haveLabel());
        Assert.assertNull(execute.getLab());
        Assert.assertFalse(list.haveLabel());
        Assert.assertNull(list.getLab());
        Assert.assertFalse(store.haveLabel());
        Assert.assertNull(store.getLab());
        Assert.assertFalse(load.haveLabel());
        Assert.assertNull(load.getLab());
        Assert.assertFalse(debug.haveLabel());
        Assert.assertNull(debug.getLab());
        Assert.assertFalse(togglebreakpoint.haveLabel());
        Assert.assertNull(togglebreakpoint.getLab());
        Assert.assertFalse(inspect.haveLabel());
        Assert.assertNull(inspect.getLab());
        Assert.assertFalse(instrument.haveLabel());
        Assert.assertNull(instrument.getLab());
    }

}