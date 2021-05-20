package comp1110.ass2;

//Define a class Tiles that can be used by all the classes
/**
 * @author Mukund Balaji Srinivas & Ke Ning & Yanyan Liu
 **/
public enum Tiles {
    B("blue", "a", 'a'),
    G("green", "b", 'b'),
    O("orange", "c", 'c'),
    P("purple", "d", 'd'),
    R("red", "e", 'e'),
    FP("First Player", "f", 'f'),
    E("*","*",'*');
    public String longName;
    public String encode;
    public char symbol;

    Tiles(String longName, String encode, char symbol) {
        this.longName = longName;
        this.encode = encode;
        this.symbol = symbol;

    }


    public static Tiles getTileByCharSymbol(char symbol){
        Tiles output=null;
        switch (symbol) {
            case 'a': output=B; break;
            case 'b': output=G; break;
            case 'c': output=O; break;
            case 'd': output=P; break;
            case 'e': output=R; break;
            case 'f': output=FP; break;
        }
        return output;
    }

    @Override
    public String toString() {
        return "" + encode;
    }


}
