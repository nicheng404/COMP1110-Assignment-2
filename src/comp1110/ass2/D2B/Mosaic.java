package comp1110.ass2.D2B;

public class Mosaic {

    //------------------------------------------Ke Ning fields----------------------------------------------------//
    public static final char HEAD = 'M';
    public String mosaicTilesString; // mosaic string in state1 without 'M'
    //------------------------------------------Ke Ning fields----------------------------------------------------//



    //------------------------------------------Ke Ning methods----------------------------------------------------//

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


//------------------------------------------Ke Ning methods----------------------------------------------------//
}


