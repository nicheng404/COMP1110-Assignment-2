package comp1110.ass2;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Ke Ning
 * <p>Each instance of this class consists of one part</p>
 * <p> The input tileString is a reprentation of tiles in floor
 */

public class Floor {
    public static final char HEAD = 'F';
    public ArrayList<Tiles> tiles = new ArrayList<>();
    public boolean isValid;
    public String tileStr;
    public boolean isEmpty;

    Floor(String tileString) {
        //check whether the floor is empty
        if (tileString.equals("")) {
            this.isEmpty = true;
            this.tileStr = "";
            this.isValid = true;
        } else {
            //order the given string first.
            this.tileStr = orderingString(tileString);
            setIsValid();
            this.isEmpty = false;
        }


    }

    /**
     * @author Ke Ning
     * Takes a string and splits it into all the tiles
     */
    public void setFloorTiles() {
        for (int i = 0; i < tileStr.length(); i++)
            for (Tiles t : Tiles.values())
                if (tileStr.charAt(i) == t.symbol)
                    tiles.add(t);
    }

    /**
     * @return true if ordered , false otherwise
     * @author Ke Ning
     * Check if a floor is ordered
     */
    public boolean isOrdered() {
        char[] arr = tileStr.toCharArray();
        Arrays.sort(arr);
        StringBuilder t = new StringBuilder();
        for (char c : arr)
            t.append(c);
        return tileStr.compareTo(t.toString()) == 0;
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
    public void setIsValid() {
        setFloorTiles();
        isValid = (tiles.size() == 7 && isOrdered() && atMost1f());
    }

    /**
     * @return If == "" return true, otherwise return false.
     * @author Ke Ning
     * Check whether the floor is empty by checking whether floor.tileStr == ""
     */

    public boolean floorIsEmpty() {
        boolean output = false;
        if (this.tileStr.equals("")) {
            output = true;
        }
        return output;
    }


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
     * @return the marks of floor, marks <=0
     * @author Ke Ning
     * Get how many marks player will lose due to the floor.
     * If the playerfloor is not well formed, 999 will be returned.
     */
    public int getMarksFromFloor() {
        int marks = 0;

        try {
            if (this.isValid) {// check validity
                if (this.isEmpty) { //floor 空？
                } else {
                    int number = this.tiles.size();
                    if (number >= 7) {// check size
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
                }
            }
            return marks;
        } catch (Exception e) {// how to write an exception
            System.out.println("The floor can not be scored , please check.");
            System.out.println("0 is returned as scored mark from floor.");
            return 0;
        }
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
