package comp1110.ass2;

import java.util.*;

/**
 * @author Ke Ning
 * <p>Each instance of this class consists of one part</p>
 * <p> The input tileString is a reprentation of tiles in storage
 */
public class Storage {

    public String storageTilesString; // storage string in state1 with 'M'
    public StorageTileWithNumber[] storageTiles;

    public static class StorageTileWithNumber {
        public Tiles tile;
        public int number;

        public StorageTileWithNumber(Tiles tile, int num) {
            this.tile = tile;
            this.number = num;
        }
    }

    public Storage() {
    }

    public Storage(String storageString) {
        if (storageTilesStringWellFormed(storageString)) {
            this.storageTilesString = storageString;
            storageTiles = new StorageTileWithNumber[5];
            //initialize the array
            for (int i = 0; i < 5; i++) {
                storageTiles[i] = new StorageTileWithNumber(Tiles.E, 0);
            }
            //set the StorageTile(t,num) into StorageTiles array.
            for (int i = 1; i < storageTilesString.length(); i++) {
                if (storageTilesString.charAt(i) >= 'a' && storageTilesString.charAt(i) <= 'e') {
                    int row = storageTilesString.charAt(i-1) - '0';
                    Tiles t = Tiles.getTileByCharSymbol(storageTilesString.charAt(i));
                    int num = storageTilesString.charAt(i + 1) - '0';

                    storageTiles[row] = new StorageTileWithNumber(t, num);
                }
            }
        }
    }


    /**
     * Check whether storage for a certain player is well formed with
     * a given certain player storage string in state1 with 'S'.
     *
     * @param storageTilesString storage string for a certain player in state1 with 'S'.
     * @return true/false. whether storage for a certain player is well formed.
     */
    public static boolean storageTilesStringWellFormed(String storageTilesString) {// isValid()
        // storage -> char[]
        int storageLengthWithS = storageTilesString.length();
        int storageLengthNoS = storageTilesString.length() - 1;
        //char[] storageArray= storageTilesString.toCharArray();

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
        if (storageLengthNoS % 3 == 0) {
            storagelengthIs3 = true;

            //storage criteria 4.中间2 a-e
            for (int i = 2; i < storageLengthWithS; i = i + 3) {
                if (storageTilesString.charAt(i) >= 'a' && storageTilesString.charAt(i) <= 'e') {
                } else {
                    storageChar2Well = false;
                }
            }

            //storage criteria 2.row顺序
            for (int i = 1; i + 3 < storageLengthWithS; i = i + 3) {
                if (storageTilesString.charAt(i) > storageTilesString.charAt(i + 3)) {
                    storageOrderWell = false;
                }
            }

            //storage criteria 3.char 3rd <=char 1st +1
            for (int i = 1; i < storageLengthWithS; i = i + 3) {
                if ((storageTilesString.charAt(i) >= '0' && storageTilesString.charAt(i) <= '4')
                        && (storageTilesString.charAt(i + 2) >= '0' && storageTilesString.charAt(i + 2) <= '5')
                        && (storageTilesString.charAt(i + 2) <= storageTilesString.charAt(i) + 1)) {
                } else {
                    storageChar13Well = false;
                }
            }
        }
        return storageLengthNoS <= 15 && storagelengthIs3
                && storageOrderWell && storageChar13Well && storageChar2Well;

    }


    /**
     * Accept the tile from factory and centre(using a hashmap) first, then check the destinationRow's capacity.
     * Then skim the overflowed
     *
     * @param tilesMapToMoveInStorage
     * @param row
     * @return
     */
    public List<Tiles> acceptTilesAndSkim(Map<Tiles, Integer> tilesMapToMoveInStorage, int row) {
        List<Tiles> result = new ArrayList<>();
        for (Tiles t : tilesMapToMoveInStorage.keySet()) {
            if (t == Tiles.FP) {
                result.add(t);
            } else {
                storageTiles[row].tile = t;
                storageTiles[row].number = storageTiles[row].number + tilesMapToMoveInStorage.get(t);
                int spareTileNumber = storageTiles[row].number - (row + 1);
                if (spareTileNumber > 0) {
                    storageTiles[row].number = row + 1;
                }
                for (int j = 0; j < spareTileNumber; j++) {
                    result.add(t);
                }
            }
        }
        if (result.size() > 1) {
            Collections.reverse(result);
        }
        return result;
    }

    /**
     * check if there exits full rows
     *
     * @return true if there exits full row.
     */
    public boolean hasFullRow() {
        for (int i = 0; i < storageTiles.length; i++) {
            if (storageTiles[i].tile != Tiles.E && storageTiles[i].number == i + 1) return true;
        }
        return false;
    }

    /**
     * get number of tiles in storage.
     * @return int[6]
     */
    public int[] getNumberOfTiles(){
        int[] result = new int[6];
        for (int i=0;i<storageTiles.length;i++){
            switch (storageTiles[i].tile.symbol) {
                case 'a':
                    result[0]+=storageTiles[i].number;
                    break;
                case 'b':
                    result[1]+=storageTiles[i].number;
                    break;
                case 'c':
                    result[2]+=storageTiles[i].number;
                    break;
                case 'd':
                    result[3]+=storageTiles[i].number;
                    break;
                case 'e':
                    result[4]+=storageTiles[i].number;
                    break;

            }
        }
        return result;
    }


    /**
     * The colour of tile stored in a row must not be the same as a colour
     * already found in the corresponding row of the mosaic.
     *
     * @param givenMosaic The given mosaic
     * @return true if no same color as mosaic in same row.
     */
    public boolean isValidComparedWithMosaic(Mosaic givenMosaic) {
        for (int i = 0; i < storageTiles.length; i++) {
            StorageTileWithNumber tN = storageTiles[i];
            for (Tiles t : givenMosaic.mosaic2D[i]) {
                if (t.symbol != '*' && t == tN.tile) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * check whether the destination row of this moving already contained a different color.
     *
     * @param row        destination row
     * @param tileSymbol
     * @return true if there is no different color in that row.
     */
    public boolean isMoveValid(int row, char tileSymbol) {
        if (storageTiles[row].tile != Tiles.E && storageTiles[row].tile.symbol != tileSymbol) {
            return false;
        }
        return true;
    }

    /**
     * clean the rest tiles of that row after moving the rightmost tile of that row into mosaic.
     *
     * @param row
     * @return a map with cleaned tile and its number.
     */

    public Map<Tiles, Integer> cleanRestTiles(int row) {
        Map<Tiles, Integer> map = new HashMap<>();
        StorageTileWithNumber tN = storageTiles[row];
        if (tN.tile != Tiles.E && tN.number > 1) {
            map.put(tN.tile, tN.number - 1);
        }
        storageTiles[row] = new StorageTileWithNumber(Tiles.E, 0);
        return map;
    }

    public static boolean storageTilesWellFormed(String storageTilesString) {
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

    @Override
    public String toString() {
        StringBuilder retString = new StringBuilder();
        retString.append("S");
        for (int i = 0; i < 5; i++) {
            if (storageTiles[i].tile != Tiles.E) {
                retString.append(i);
                retString.append(storageTiles[i].tile.encode);
                retString.append(storageTiles[i].number);
            }
        }
        return retString.toString();
    }

    public static void main(String[] args) {
        Storage s = new Storage("S0b11d23c24a5");
        System.out.println(s.toString());
    }
}