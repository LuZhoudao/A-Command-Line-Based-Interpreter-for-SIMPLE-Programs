package hk.edu.polyu.comp.comp2021.simple.model;

@SuppressWarnings("ALL")
public class expName extends Variable{
    private Type type;

    public expName(String name) {
        super(name,varID.EXPNAME);
    }
    public void setTypeValue(String s){
        if(type.getID() == Type.TypeID.INT){
            IntType type1 = new IntType();
            type1.setValue(s);
            type = type1;
        }
        else{
            BooleanType type2 = new BooleanType();
            type2.setValue(s);
            type = type2;
        }
    }

    public void setType(Type type){ this.type = type;}

    public Type getType() {return type;}



    public static boolean isNumber(String s){
        for(int i = 0;i < s.length();i++){
            if(!Character.isDigit(s.charAt(i))) return false;
        }
        return true;
    }

    public static boolean isBool(String s){
        if((s.equals("true")) || (s.equals("false"))) return true;
        return false;
    }

    @SuppressWarnings({"ClassReferencesSubclass", "AccessingNonPublicFieldOfAnotherObject"})
    public static expName setExpRef(String name, Simple simple){
        expName expRef = new expName(name);
        if(expName.isNumber(name)|| (name.charAt(0)  == '-' && expName.isNumber(name.substring(1)))){
            expRef.setType(Type.valueOf("int"));
            expRef.setTypeValue(name);
        }
        else if(expName.isBool(name)){
            expRef.setType(Type.valueOf("bool"));
            expRef.setTypeValue(name);
        }
        else{
            expRef.setType(new IntType());
            String name1 = expRef.getName();
            if(simple.getExpMap().containsKey(name1)){
                if(simple.getExpMap().get(name1).getId() == Variable.varID.BINEXPNAME){
                    binexpr.setExpAndExpRef((BinExpName) simple.getExpMap().get(name1),simple);
                }
                else if(simple.getExpMap().get(name1).getId() == Variable.varID.UNEXPNAME){
                    unexpr.setExpAndExpRef((UnExpName)simple.getExpMap().get(name1),simple);
                }
                expRef = simple.getExpMap().get(name1);
            }
            else if(simple.getVarMap().containsKey(name1)){
                expRef.setType(simple.getVarMap().get(name1).getType());
                if(expRef.getType() == null) throw new IllegalStateException("this expRef hasn't been defined");
            }
            else throw new IllegalArgumentException("the input of expRef is wrong");
        }
        return expRef;
    }





}
