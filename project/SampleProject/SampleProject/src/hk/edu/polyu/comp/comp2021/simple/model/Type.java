package hk.edu.polyu.comp.comp2021.simple.model;

@SuppressWarnings("ALL")
public abstract class Type {
    private final TypeID ID;

    protected Type(TypeID id) {
        ID = id;
    }

    public static Type valueOf(String type) {
        switch(type) {
            case "int":
                return new IntType() ;
            case "bool":
                return new BooleanType();
        }

        throw new IllegalArgumentException();
    }

    public abstract Object getValue();

    public abstract void setValue(String s);

    public TypeID getID(){return ID;}

    public enum TypeID{
        INT("int"),BOOL("boolean");

        private final String id;

        TypeID(String id) {this.id = id;}

        public String getId(){return id;}
    }
}


