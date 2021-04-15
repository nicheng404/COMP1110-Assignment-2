package comp1110.ass2.D2B;

//Define a class Tiles that can be used by all the classes
public enum Tiles  {
    B("Blue","a"),
    G("Green","b"),
    O("Orange","c"),
    P("Purple","d"),
    R("Red","e"),
    FP("First Player","f")
        ;
    public String longName;
    public String encode;
    Tiles(String longName,String encode) {
        this.longName=longName;
        this.encode=encode;

    }
}
