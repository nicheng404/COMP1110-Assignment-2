package comp1110.ass2;

import java.util.ArrayList;
import java.util.Arrays;

public class Mosaic {
    public ArrayList<ArrayList<Tiles>> mosaic = new ArrayList<>();
    public boolean isValid;
    public String inString;

    Mosaic(String inString) {
        this.inString = inString;
        setMosaic();
    }

    public void setMosaic() {
        //initialise all the mosaics to "*" in the beginning
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                mosaic.get(i).add(j, Tiles.E);
            }
        }
        //Get the address of these tiles and check if they are valid by checking for their lengths
        ArrayList<Integer> tileAddr = new ArrayList<>();
        for (int i = 0; i < inString.length(); i++) {
            if (inString.charAt(i) >= 'a' && inString.charAt(i) <= 'd') {
                tileAddr.add(i);
            }
        }
        boolean[] checkVal = new boolean[tileAddr.size() - 1];
        for (int j = 0; j < tileAddr.size() - 1; j++) {
            if (tileAddr.get(j + 1) - tileAddr.get(j) == 3) {
                checkVal[j] = true;
            }
        }
        boolean[] trueArray = new boolean[checkVal.length];
        Arrays.fill(trueArray, true);
        isValid = Arrays.equals(trueArray, checkVal);
        int row, col;
        if (isValid) {
            for (int i = 0; i < tileAddr.size(); i++) {
                row = Integer.parseInt(inString.substring(tileAddr.get(i + 1), tileAddr.get(i + 2)));
                col = Integer.parseInt(inString.substring(tileAddr.get(i + 2), tileAddr.get(i + 3)));
                for (Tiles s : Tiles.values()) {
                    if (s.symbol == inString.charAt(tileAddr.get(i))) {
                        mosaic.get(row).add(col, s);
                    }
                }
            }
        }
    }

    public static final char HEAD = 'M';
    public String mosaicTilesString; // mosaic string in state1 without 'M'

    /**
     * @param mosaicTilesString mosaic string for a certain player in state1 without 'M'.
     * @return true/false. whether mosaic for a certain player is well formed.
     * @author Ke Ning
     * Check whether mosaic for a certain player is well formed with
     * a given certain player mosaic string in state1 without 'M'.
     */
    public static boolean mosaicTilesWellFormed(String mosaicTilesString) {

        // mosaic -> char[]
        int mosaicLength = mosaicTilesString.length();
        char[] mosaicArray = new char[mosaicLength];
        mosaicArray = mosaicTilesString.toCharArray();
        //criteria : lengthIs3, mosaicChar1Well, mosaicChar2Well, mosaicChar3Well, mosaicOrderWell
        boolean mosaiclengthIs3 = false;
        boolean mosaicChar1Well = true;
        boolean mosaicChar2Well = true;
        boolean mosaicChar3Well = true;
        boolean mosaicOrderWell = true;
        //mosaic criteria 1 : check length 是3的倍数
        if (mosaicLength % 3 == 0) {
            mosaiclengthIs3 = true;
            //mosaic criteria 2 :1st well
            for (int i = 0; i < mosaicLength; i = i + 3) {
                if (mosaicArray[i] == 'a' || mosaicArray[i] == 'b'
                        || mosaicArray[i] == 'c' || mosaicArray[i] == 'd' || mosaicArray[i] == 'e') {
                } else {
                    mosaicChar1Well = false;
                }
            }
            //mosaic criteria 3 : 2nd well
            for (int i = 1; i < mosaicLength; i = i + 3) {
                if (mosaicArray[i] == '0' || mosaicArray[i] == '1'
                        || mosaicArray[i] == '2' || mosaicArray[i] == '3' || mosaicArray[i] == '4') {
                } else {
                    mosaicChar2Well = false;
                }
            }
            //mosaic criteria 4 : 3rd well
            for (int i = 2; i < mosaicLength; i = i + 3) {
                if (mosaicArray[i] == '0' || mosaicArray[i] == '1'
                        || mosaicArray[i] == '2' || mosaicArray[i] == '3' || mosaicArray[i] == '4') {
                } else {
                    mosaicChar3Well = false;
                }
            }
            //mosaic criteria 5 : order well
            for (int i = 1; i + 3 < mosaicLength; i = i + 3) {
                if (mosaicArray[i] > mosaicArray[i + 3]) {
                    mosaicOrderWell = false;
                }
            }
        }
        if (mosaicLength <= 75 && mosaiclengthIs3
                && mosaicChar1Well && mosaicChar2Well && mosaicChar3Well && mosaicOrderWell) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * An entire playerState for 2 players might look like this:
     * "A20 Ma02a13b00e42 S2a13e44a1 Faabbe B30 Mc01b11d21 S0e12b2F"
     * If we split player A's string into its substrings, we get:
     * [A][20][Ma02a13b00e42][S2a13e44a1][Faabbe].
     *
     * @param playerState the player state string
     * @return True if the playerState is well-formed,
     * false if the playerState is not well-formed
     */

    // get the tiles in mosaic.
    public static String getTilesFromMosaic(String[] playerState) {
        String[] subStrings = new String[2];
        String plyst0 = playerState[0];
        String plyst1 = playerState[1];
        //get substrings
        int index0A = plyst0.indexOf("A", 1);
        int index0M = plyst0.indexOf("M", index0A);
        int index0S = plyst0.indexOf("S", index0M);
        int index0F = plyst0.indexOf("F", index0S);
        return plyst0.substring(index0M + 1, index0S);
    }

    // arrange tiles to place in the mosaic (incomplete function)
    public void arrangeMosaicTo2DArray(String[] tiles) {
        String[][] string_mosaic = new String[5][5];
        for (int j = 0; j < 5; j++) {
            for (int i = 0; i < 5; i++) {
                string_mosaic[j][i] = null;
            }
        }
    }
//[Ma02a13b00e42] -> rowNumber,color of tiles, number of tiles in the row.
// arrange tiles to place in the storage
//   public void arrangeStorageTo2DArray(String [] tiles){
//       String [][] string_storage = new String [5] [5];
//    }
//        for(int i=0; i< tiles.length;i++){
//            if(tiles)
// }
}
