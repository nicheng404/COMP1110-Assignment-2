package comp1110.ass2;

import javafx.scene.paint.Color;

//Define a class Tiles that can be used by all the classes
public enum Tiles {
    B("Blue", "a", 'a'),
    G("Green", "b", 'b'),
    O("Orange", "c", 'c'),
    P("Purple", "d", 'd'),
    R("Red", "e", 'e'),
    FP("First Player", "f", 'f');

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
