package comp1110.ass2.D2B;

public class Storage {


    public static final char HEAD = 'S';
    public String storageTilesString; // storage string in state1 without 'M'


    /**
     * Check whether storage for a certain player is well formed with
     *  a given certain player storage string in state1 without 'S'.
     *
     * @param storageTilesString storage string for a certain player in state1 without 'S'.
     * @return true/false. whether storage for a certain player is well formed.
     */
    public static boolean storageTilesWellFormed(String storageTilesString){
        // storage -> char[]
        int storageLength = storageTilesString.length();
        char[] storageArray = new char[storageLength];
        storageArray = storageTilesString.toCharArray();

        // [storage] criteria:
        // 1.length 是3的倍数，0<=length <=15
        // 2.row顺序
        // 3.char 3rd 最大=char 1st +1
        // 4.中间2 a-e

        boolean storagelengthIs3 = false;
        boolean storageOrderWell = true;
        boolean storageChar13Well = true;
        boolean storageChar2Well = true;

        //storage criteria 1 : check length 是3的倍数
        if (storageLength % 3 == 0) {
            storagelengthIs3 = true;

            //storage criteria 4.中间2 a-e
            for (int i = 1; i < storageLength; i = i + 3) {
                if (storageArray[i] == 'a' || storageArray[i] == 'b' || storageArray[i] == 'c'
                        || storageArray[i] == 'd' || storageArray[i] == 'e') {
                } else {
                    storageChar2Well = false;
                }
            }

            //storage criteria 2.row顺序
            for (int i = 0; i + 3 < storageLength; i = i + 3) {
                if (storageArray[i] > storageArray[i + 3]) {
                    storageOrderWell = false;
                }
            }

            //storage criteria 3.char 3rd 最大=char 1st +1
            for (int i = 0; i < storageLength; i = i + 3) {
                if ((storageArray[i] == '0' || storageArray[i] == '1' || storageArray[i] == '2'
                        || storageArray[i] == '3' || storageArray[i] == '4')
                        && (storageArray[i + 2] == '0' || storageArray[i + 2] == '1' || storageArray[i + 2] == '2'
                        || storageArray[i + 2] == '3' || storageArray[i + 2] == '4' || storageArray[i + 2] == '5')
                        && (storageArray[i + 2] <= storageArray[i] + 1)) {
                } else {
                    storageChar13Well = false;
                }
            }
    }
        if (storageLength <= 15 && storagelengthIs3
                && storageOrderWell && storageChar13Well && storageChar2Well) {
            return true;
        } else {
            return false;
        }
}


}
