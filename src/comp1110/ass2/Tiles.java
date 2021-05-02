package comp1110.ass2;
<<<<<<< HEAD:src/comp1110/ass2/Tiles.java
=======

import javafx.scene.paint.Color;
>>>>>>> origin/developmentbranchqw:src/comp1110/ass2/D2B/Tiles.java

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

    @Override
    public String toString() {
        return "" + encode;
    }
}
