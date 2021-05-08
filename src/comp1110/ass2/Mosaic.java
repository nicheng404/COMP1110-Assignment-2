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

}
