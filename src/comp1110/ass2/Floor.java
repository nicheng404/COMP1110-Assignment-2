package comp1110.ass2;

import java.util.*;

/**
 * @author Ke Ning
 * <p>Each instance of this class consists of one part</p>
 * <p> The input tileString is a reprentation of tiles in floor
 */

public class Floor {
    public static final char HEADCHAR = 'F';
    public ArrayList<Tiles> tiles = new ArrayList<>();

    public Floor() {
    }

    public Floor(String floorString) {
            setFloorTiles(floorString);
    }

    /**
     * @author Ke Ning
     * Takes a string and splits it into all the tiles
     */
    public void setFloorTiles(String floorString) {
        for (int i = 1; i < floorString.length(); i++) {
            char c = floorString.charAt(i);
            Tiles t = Tiles.getTileByCharSymbol(c);
            tiles.add(t);
        }
    }

    /**
     * @author Ke Ning
     * Order the given tiles into alphabet order.
     */
    public String orderingString(String tileStr) {
        char[] arr = tileStr.toCharArray();
        Arrays.sort(arr);
        return Arrays.toString(arr);
    }

    /**
     * Check the number of 'f' in floor. If number >=2, return false.
     *
     * @return At most 1 'f' in floor return true, otherwise return false.
     */
    public boolean atMost1f() {
        int numberoff = 0;
        for (Tiles t : tiles) {
            if (t.symbol == 'f') {
                numberoff++;
            }
        }
        if (numberoff <= 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Set the validity of a given Floor
     */
    public boolean isValid() {
        boolean result = (this.tiles.size() <= 7 && atMost1f());
        return result;
    }

    public boolean floorIsFull() {
        return this.tiles.size() == 7;
    }

    /**
     * @return If empty return true, otherwise return false.
     * @author Ke Ning
     * Check whether the floor is empty by checking whether floor.tileStr == ""
     */

    public boolean floorIsEmpty() {
        return this.tiles.isEmpty();
    }


    /**
     * use the size of tiles Arraylist to get the lost marks.
     *
     * @return marks lost due to floor.
     */
    public int loseMarks() {
        int mark = 0;
        switch (this.tiles.size()) {
            case 0:
                mark = 0;
                break;
            case 1:
                mark = -1;
                break;
            case 2:
                mark = -2;
                break;
            case 3:
                mark = -4;
                break;
            case 4:
                mark = -6;
                break;
            case 5:
                mark = -8;
                break;
            case 6:
                mark = -11;
                break;
            default:
                mark = -14;
                break;
        }
        return mark;
    }

    /**
     * Empty the floor, move floor's tiles to discard.
     *
     * @return A map<tile,number of that tile in floor> to be moved to discard.
     */

    public Map<Tiles, Integer> emptyFloorToDiscard() {
        Map<Tiles, Integer> tilesFromFloor = new HashMap<>();
        for (Tiles t : Tiles.values()) {
            if (t.symbol != '*') {
                tilesFromFloor.put(t, 0);
            }
        }
        for (Tiles t : tiles) {
            int newnum = tilesFromFloor.get(t) + 1;
            tilesFromFloor.replace(t, newnum);
        }
        tilesFromFloor.remove(Tiles.FP);
        tiles.clear();
        return tilesFromFloor;
    }

    /**
     * if the floor has First player tile, return true.
     *
     * @return
     */
    public boolean firstPlayerIsInFloor() {
        for (Tiles t : this.tiles) {
            if (this.tiles.size() != 0 && t.symbol == 'f') {
                return true;
            }
        }
        return false;
    }


    /**
     * First let the floor accept the tiles (even >7), then trim
     * the overflowed tiles(which should be moved to the discard) into a hashmap.
     * *Swap the first player tile with the 7th tile in floor if Fp is in the overflowed part.
     *
     * @param tilesList given tiles in list.
     * @return A hashmap of tiles to be move into discard.
     */

    public Map<Tiles, Integer> acceptTilesAndSkim(List<Tiles> tilesList) {
        Map<Tiles, Integer> overflowTiles = new HashMap<>();
        this.tiles.addAll(tilesList);
        if (this.tiles.size() > 7) {
            for (int i = this.tiles.size() - 1; i >= 7; i--) {
                Tiles t = this.tiles.get(i);
                // check first player
                if (t == Tiles.FP) {
                    this.tiles.set(i, this.tiles.get(6));
                    this.tiles.set(6, Tiles.FP);
                    t = this.tiles.get(i);
                }
                // move overflowed tiles into Map
                if (overflowTiles.get(t) == null) {
                    overflowTiles.put(t, 1);
                } else {
                    overflowTiles.replace(t, overflowTiles.get(t) + 1);
                }
                this.tiles.remove(i);
            }
        }
        Collections.sort(this.tiles);
        return overflowTiles;
    }


//-------------------------------------------------------old------------------------------------------------------------------------------------------------------

    /**
     * @param singlePlayerState A PlayerState String for a single player.
     * @return player's floor string (without 'F'). If floor is empty, return "".
     * @author Ke Ning
     * Return a floor string(without 'F') for a single player based on a given singlePlayerState String.
     * If the floor is empty, return "".
     */
    public static String getFloorString(String singlePlayerState) {
        String output = "";

        if (!(Floor.floorIsEmpty(singlePlayerState))) {
            int indexF = singlePlayerState.indexOf("F");
            output = singlePlayerState.substring(indexF);
        }

        return output;
    }


    /**
     * Empty the floor and adjust the discard/center with following rules:
     * 1.'f' should be sent to the centre's tail.
     * 2. else tiles need to be sent to discard.
     *
     * @param floorTilesString A floor string of a certain player
     * @param originalDiscard  The common discard string.
     * @param originalCentre   The common centre string.
     * @return
     */
    public static String[] emptyFloor(String floorTilesString,
                                      String originalDiscard, String originalCentre) {

        String outputCentre = originalCentre;
        String outputDiscard;

        //string discard -> int
        int discardOfa = Integer.parseInt(originalDiscard.substring(0, 2));
        int discardOfb = Integer.parseInt(originalDiscard.substring(2, 4));
        int discardOfc = Integer.parseInt(originalDiscard.substring(4, 6));
        int discardOfd = Integer.parseInt(originalDiscard.substring(6, 8));
        int discardOfe = Integer.parseInt(originalDiscard.substring(8));
        //int tileInDiscard = discardOfa + discardOfb + discardOfc + discardOfd + discardOfe;

        // discard int-> discard int[]
        int[] numberOfTilesInDiscard = {discardOfa, discardOfb, discardOfc, discardOfd, discardOfe};

        //floor->discard/centre
        for (int i = 0; i < floorTilesString.length(); i++) {
            switch (floorTilesString.charAt(i)) {
                // put f into centre
                case 'f':
                    outputCentre = outputCentre + 'f';
                    break;
                //put else tiles into discard
                case 'a':
                    discardOfa++;
                    break;
                case 'b':
                    discardOfb++;
                    break;
                case 'c':
                    discardOfc++;
                    break;
                case 'd':
                    discardOfd++;
                    break;
                case 'e':
                    discardOfe++;
                    break;

            }
        }

        //discard int[]->string
        StringBuilder newDiscardStringDemo = new StringBuilder();
        for (int v : numberOfTilesInDiscard) {
            if (v < 10) {
                newDiscardStringDemo.append("0");
                newDiscardStringDemo.append(v);
            } else {
                newDiscardStringDemo.append(v);
            }
        }
        outputDiscard = newDiscardStringDemo.toString();

        //empty floor
        String outputFloor = "";

        String[] result = {outputFloor, outputDiscard, outputCentre};

        return result;
    }


    //----------------------------------------------------------old-----------------------------------------//

    //public String floorTilesString; // floor string in state0 without 'F'


    /**
     * Check whether floor for a certain player is well formed with
     * a given certain player floor string in state1 without 'F'.
     *
     * @param floorTilesString floor string for a certain player in state1 without 'S'.
     * @return true/false. whether storage for a certain player is well formed.
     */
    public static boolean floorTilesWellFormed(String floorTilesString) {

        //string -> char[]
        int floorLength = floorTilesString.length();
        char[] floorArray = new char[floorLength];
        floorArray = floorTilesString.toCharArray();

        // floor criteria:
        // 1.length<=7
        // 2.order
        // 3.a-f
        // 4.f <=1
        boolean floorOrderWell = true;
        boolean floorCharWell = true;
        int numberOff = 0;

        // storage criteria 3 :a-f
        for (int i = 0; i < floorLength; i++) {
            if (floorArray[i] == 'f') {
                numberOff++;
            }

            if (floorArray[i] == 'a' || floorArray[i] == 'b' || floorArray[i] == 'c'
                    || floorArray[i] == 'd' || floorArray[i] == 'e' || floorArray[i] == 'f') {
            } else {
                floorCharWell = false;
            }
        }

        //storage criteria 2 :order
        for (int i = 0; i + 1 < floorLength; i++) {
            if (floorArray[i] > floorArray[i + 1]) {
                floorOrderWell = false;
            }
        }

        //check criteria
        if (floorLength <= 7 && floorOrderWell && floorCharWell && numberOff <= 1) {
            return true;
        } else {
            return false;
        }
    }

    //

    /**
     * Check whether the floor is empty for this given player.
     *
     * @param singlePlayerState A PlayerState String for a single player.
     * @return result
     */
    public static boolean floorIsEmpty(String singlePlayerState) {
        boolean output = false;
        int indexF = singlePlayerState.indexOf("F");
        if (indexF == singlePlayerState.length() - 1) {
            output = true;
        }
        return output;
    }


    /**
     * Get how many marks player will lose due to the floor.
     * If the playerfloor is not well formed, 999 will be returned.
     *
     * @param givenFloorTilesString The floor string without 'F'.
     * @return the marks of floor, marks <=0
     */
    public static int getMarksFromFloor(String givenFloorTilesString) {
        int marks = 0;
        //floor 空？
        if (Floor.floorTilesWellFormed(givenFloorTilesString)) {
            int number = givenFloorTilesString.length();
            if (number >= 7) {
                marks = -14;
            } else {
                switch (number) {
                    case 1:
                        marks = -1;
                        break;
                    case 2:
                        marks = -2;
                        break;
                    case 3:
                        marks = -4;
                        break;
                    case 4:
                        marks = -6;
                        break;
                    case 5:
                        marks = -8;
                        break;
                    case 6:
                        marks = -11;
                        break;
                }
            }
        } else {// how to write an exception
            System.out.println("This Floor's tiles are not well formed, please check");
            marks = 999;
        }

        return marks;
    }


}
