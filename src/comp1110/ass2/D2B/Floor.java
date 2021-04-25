package comp1110.ass2.D2B;

public class Floor {


        public static final char HEAD = 'F';
        public String floorTilesString; // floor string in state1 without 'M'




        /**
         * Check whether floor for a certain player is well formed with
         *  a given certain player floor string in state1 without 'F'.
         *
         * @param floorTilesString floor string for a certain player in state1 without 'S'.
         * @return true/false. whether storage for a certain player is well formed.
         */
        public static boolean floorTilesWellFormed(String floorTilesString){

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


    }
