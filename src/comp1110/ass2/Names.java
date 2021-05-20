package comp1110.ass2;

/**
 * @author Mukund Balaji Srinivas & Ke Ning
 **/
public enum Names {
    A("A", 'A'),
    B("B", 'B'),
    C("C", 'C'),
    D("D", 'D');
    public String name;
    public char nameChar;

    Names(String name, char nameChar) {
        this.name = name;
        this.nameChar = nameChar;
    }

    public static Names getNamesByChar(char c) {

        Names n = null;
        switch (c) {
            case 'A':
                n = Names.A;
                break;
            case 'B':
                n = Names.B;
                break;
            case 'C':
                n = Names.C;
                break;
            case 'D':
                n = Names.D;
                break;
        }
        return n;
    }

    public static  Names getNamesByString(String s){
        Names n =null;
        char c = s.charAt(0);
        n=Names.getNamesByChar(c);
        return n;
    }


}
