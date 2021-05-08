package comp1110.ass2;

import java.util.ArrayList;
import java.util.Arrays;

public class Mosaic {
    public ArrayList<ArrayList<Tiles>> mosaic = new ArrayList<>();
    public boolean isValid;
    public String inString;
    Mosaic(String inString){
        this.inString=inString;
        setMosaic();
    }

    public void setMosaic() {
        //Get the address of these tiles and check if they are valid by checking for their lengths
        ArrayList<Integer> tileAddr = new ArrayList<>();
        for (int i = 0; i < inString.length(); i++) {
            if (inString.charAt(i) >= 'a' && inString.charAt(i) <= 'd') {
                tileAddr.add(i);



    public static final char HEAD = 'M';
    public String mosaicTilesString; // mosaic string in state1 without 'M'








    /**
     * Check whether mosaic for a certain player is well formed with
     *  a given certain player mosaic string in state1 without 'M'.
     *
     * @param mosaicTilesString mosaic string for a certain player in state1 without 'M'.
     * @return true/false. whether mosaic for a certain player is well formed.
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
        int row , col ;
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


