package comp1110.ass2;
import java.util.ArrayList;

public class Mosaic {
    public ArrayList<ArrayList<Tiles>> mosaic2D = new ArrayList<>();
    public boolean isValid;
    public String inString;// b00a02a13e42 (without 'M')

    Mosaic(String inString) {
        this.inString = inString;
        setMosaic();
    }

    public boolean setValid(){
        // mosaic -> char[]
        int mosaicLength = this.inString.length();
        char[] mosaicArray = this.inString.toCharArray();

        //criteria : lengthIs3, mosaicChar1Well, mosaicChar2Well, mosaicChar3Well, mosaicOrderWell
        boolean mosaiclengthWell = false;
        boolean mosaicChar1Well = true;
        boolean mosaicChar2Well = true;
        boolean mosaicChar3Well = true;
        boolean mosaicRowOrderWell = true;
        boolean mosaicColumnOrderWell = true;

        //mosaic criteria 1 : check length
        if (mosaicLength % 3 == 0) {
            mosaiclengthWell = true;

            //mosaic criteria 2 :1st well
            for (int i = 0; i < mosaicLength; i = i + 3) {
                if (this.inString.charAt(i) >= 'a' && this.inString.charAt(i) <= 'e') {
                } else {
                    mosaicChar1Well = false;

                }
            }
            //mosaic criteria 3 : 2nd well
            for (int i = 1; i < mosaicLength; i = i + 3) {
                if (this.inString.charAt(i) >= '0' && this.inString.charAt(i) <= '4') {
                } else {
                    mosaicChar2Well = false;
                }
            }
            //mosaic criteria 4 : 3rd well
            for (int i = 2; i < mosaicLength; i = i + 3) {
                if (this.inString.charAt(i) >= '0' && this.inString.charAt(i) <= '4') {
                } else {
                    mosaicChar3Well = false;
                }
            }
            //mosaic criteria 5 : order well
            for (int i = 1; i + 3 < mosaicLength; i = i + 3) {
                if (this.inString.charAt(i) > this.inString.charAt(i+3)) {
                    mosaicRowOrderWell = false;
                }
                if (this.inString.charAt(i)==this.inString.charAt(i+3)){
                    if(this.inString.charAt(i+1)>this.inString.charAt(i+4)){
                        mosaicColumnOrderWell=false;
                    }
                }
            }
        }
        if (mosaicLength <= 75 && mosaiclengthWell && mosaicChar1Well && mosaicChar2Well
                && mosaicChar3Well && mosaicRowOrderWell && mosaicColumnOrderWell) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Check weather the given Mosaic is valid and set its validity.
     * <p>Set the tiles on the mosaic by reading the inString</p>
     * <p>Set the validity using the isValid field</p>
     * @author Ke Ning
     * @author Mukund Balaji Srinivas
     */
    public void setMosaic() {
        //initialise all the mosaics to "*" in the beginning
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                mosaic2D.get(i).add(j, Tiles.E);
            }
        }
        //Get the address of these tiles and check if they are valid by checking for their lengths

        isValid = setValid();
        int row, col;
        if (isValid) {
            for (int i = 0; i < this.inString.length(); i++) {

                if (this.inString.charAt(i)>='a' && this.inString.charAt(i)<='e'){
                    row=this.inString.charAt(i+1)-'0';
                    col=this.inString.charAt(i+2)-'0';
                    Tiles t = Tiles.getTileByCharSymbol(this.inString.charAt(i));
                    mosaic2D.get(row).set(col,t);
                }
            }

        }
    }

}
