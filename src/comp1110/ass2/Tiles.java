package comp1110.ass2;

//Define a class Tiles that can be used by all the classes
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

    @Override
    public String toString() {
        return "" + encode;
    }


}
