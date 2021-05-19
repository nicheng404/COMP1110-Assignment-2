package comp1110.ass2;

import java.util.ArrayList;

public class Mosaic {
    public Tiles[][] mosaic2D;
    public boolean isValid;
    public String inString;// Mb00a02a13e42

    Mosaic(String inString) {
        this.inString = inString;
        setMosaic();
    }


    /**
     * check whether the inString is valid.
     * @return
     */
    public boolean checkIsValid() {
        // mosaic -> char[]
        int mosaicLength = this.inString.length() - 1;

        //criteria : lengthIs3, mosaicChar1Well, mosaicChar2Well,
        //          mosaicChar3Well, mosaicOrderWell,mosaicOverlapping, mosaicColorWell.
        boolean mosaiclengthWell = false;
        boolean mosaicChar1Well = true;
        boolean mosaicChar2Well = true;
        boolean mosaicChar3Well = true;
        boolean mosaicRowOrderWell = true;
        boolean mosaicColumnOrderWell = true;
        boolean mosaicOverlappingWell = true;
        boolean mosaicColorWell = true;

        //mosaic criteria 1 : check length
        if (mosaicLength % 3 == 0) {
            mosaiclengthWell = true;

            //mosaic criteria 2 :1st well
            for (int i = 1; i < mosaicLength + 1; i = i + 3) {
                if (this.inString.charAt(i) >= 'a' && this.inString.charAt(i) <= 'e') {
                } else {
                    mosaicChar1Well = false;

                }
            }
            //mosaic criteria 3 : 2nd well
            for (int i = 2; i < mosaicLength + 1; i = i + 3) {
                if (this.inString.charAt(i) >= '0' && this.inString.charAt(i) <= '4') {
                } else {
                    mosaicChar2Well = false;
                }
            }
            //mosaic criteria 4 : 3rd well
            for (int i = 3; i < mosaicLength + 1; i = i + 3) {
                if (this.inString.charAt(i) >= '0' && this.inString.charAt(i) <= '4') {
                } else {
                    mosaicChar3Well = false;
                }
            }
            //mosaic criteria 5 : order well
            for (int i = 2; i + 3 < mosaicLength + 1; i = i + 3) {
                if (this.inString.charAt(i) > this.inString.charAt(i + 3)) {
                    mosaicRowOrderWell = false;
                }
                if (this.inString.charAt(i) == this.inString.charAt(i + 3)) {
                    if (this.inString.charAt(i + 1) > this.inString.charAt(i + 4)) {
                        mosaicColumnOrderWell = false;
                    }
                }
            }
            //mosaic criteria 6 : no overlapping
            Tiles[][] t2DArray = new Tiles[5][5];
            for (int i = 1; i < this.inString.length(); i += 3) {
                char tileSymbol = this.inString.charAt(i);
                int row = this.inString.charAt(i + 1) - '0';
                int column = this.inString.charAt(i + 2) - '0';
                if (t2DArray[row][column] != null) {
                    mosaicOverlappingWell = false;
                }
                t2DArray[row][column] = Tiles.getTileByCharSymbol(tileSymbol);
            }
            //mosaic criteria 7 : only 1 of each color on each row/column
            int[][] rowColor = new int[5][5];
            int[][] colColor = new int[5][5];
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    Tiles tile = t2DArray[i][j];
                    if (tile == null) {
                        break;
                    }
                    if (rowColor[i][tile.ordinal()] == 1 || colColor[tile.ordinal()][j] == 1) {
                        mosaicColorWell = false;
                    }
                    rowColor[i][tile.ordinal()]++;
                    colColor[tile.ordinal()][j]++;
                }
            }


        }
        return mosaicLength <= 75 && mosaiclengthWell && mosaicChar1Well && mosaicChar2Well
                && mosaicChar3Well && mosaicRowOrderWell && mosaicColumnOrderWell
                && mosaicOverlappingWell && mosaicColorWell ;
    }

    /**
     * Check weather the given Mosaic is valid and set its validity.
     * <p>Set the tiles on the mosaic by reading the inString</p>
     * <p>Set the validity using the isValid field</p>
     *
     * @author Ke Ning
     * @author Mukund Balaji Srinivas
     */
    public void setMosaic() {
        //initialise all the mosaics to "*" in the beginning
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                mosaic2D[i][j] = Tiles.E;
            }
        }
        //Get the address of these tiles and check if they are valid by checking for their lengths

        this.isValid = checkIsValid();
        int row, col;
        if (isValid) {
            for (int i = 0; i < this.inString.length(); i++) {

                if (this.inString.charAt(i) >= 'a' && this.inString.charAt(i) <= 'e') {
                    row = this.inString.charAt(i + 1) - '0';
                    col = this.inString.charAt(i + 2) - '0';
                    Tiles t = Tiles.getTileByCharSymbol(this.inString.charAt(i));
                    mosaic2D[row][col] = t;
                }
            }

        }
    }

    /**
     * check whether this move with a tile to current mosaic is valid
     * @param destinationRow
     * @param destinationColumn
     * @param tileSymbol a tile to be moved into current mosaic
     * @return
     */
    public boolean moveIsValid (int destinationRow, int destinationColumn, char tileSymbol){
        boolean result=true;
        //check whether the destination cube is empty
        if (this.mosaic2D[destinationRow][destinationColumn] != Tiles.E){
            result = false;
        }
        //check the row color condition
        for (int i=0;i<5;i++){
            if (mosaic2D[destinationRow][i]!=Tiles.E && mosaic2D[destinationRow][i].symbol==tileSymbol){
                result= false;
            }
        }
        //check the column color condition
        for(int j=0;j<5;j++){
            if(mosaic2D[j][destinationColumn]!= Tiles.E && mosaic2D[j][destinationColumn].symbol==tileSymbol){
                result = false;
            }
        }
        return result;
    }


    /**
     * After moving a tile into mosaic, score points immediately.(with the moved tile's current location)
     * @param row the moved tile's current row (0-4)
     * @param column the moved tile's current column (0-4)
     * @return The marks after this movement.
     */
    public int scoringFromMosaic(int row, int column){
        int mark = 0;
        int number = 1;
        // check for column tiles
        for (int i= row-1;i>=0;i--){
            if (this.mosaic2D[i][column].symbol=='*'){
                break;
            }
            number++;
        }
        for (int i=row+1;i<5;i++){
            if (this.mosaic2D[i][column].symbol=='*'){
                break;
            }
            number++;
        }
        if (number>1){
            mark=mark+number;
        }

        //check for row tiles.
        number =1;
        for (int j= column-1;j>=0;j--){
            if (this.mosaic2D[row][j].symbol=='*'){
                break;
            }
            number++;
        }
        for (int j= column+1;j<5;j++){
            if (this.mosaic2D[row][j].symbol=='*'){
                break;
            }
            number++;
        }
        if (number>1){
            mark=mark+number;
        }

        if (mark>0){
            return mark;
        } else {
            return 1;
        }
    }

}
