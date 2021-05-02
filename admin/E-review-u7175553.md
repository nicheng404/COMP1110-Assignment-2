## Code Review

Reviewed by: Ke Ning, u7175553

Reviewing code written by: Mukund Balaji Srinivas, u7274095

    public class Factory {
        public ArrayList<Tiles> tiles = new ArrayList<>();
        public int Number;
        public boolean isValid;
        public String tileStr;

        Factory(String tileStr) {
            this.tileStr = tileStr;
            setIsValid();
        }

        /**
        * @author Mukund Balaji Srinivas
        * Set the address of each factory
        */
        public void setFacNumber() {
            String AddR = tileStr.substring(0, 1);
            this.Number = Integer.parseInt(AddR);
        }

        /**
        * @author Mukund Balaji Srinivas
        * Takes a string and splits it into all the tiles
        */
        public void setFacTiles() {
            for (int i = 0; i < tileStr.substring(1).length(); i++)
                for (Tiles Tile : Tiles.values())
                    if (tileStr.substring(1).charAt(i) == Tile.symbol)
                        tiles.add(Tile);
        }

        /**
        * Check if a substring is ordered
        * @return true if ordered , false otherwise
        * @author Mukund Balaji Srinivas
        */
        public boolean isOrdered() {
            char[] nString = tileStr.substring(1).toCharArray();
            Arrays.sort(nString);
            StringBuilder t = new StringBuilder();
            for (char c : nString)
                t.append(c);
            return tileStr.substring(1).compareTo(t.toString()) == 0;
        }

        /**
        * Set the validity of a given factory
        */
        public void setIsValid() {
            setFacTiles();
            setFacNumber();
            isValid = tiles.size() == 4 && Number <= 8 && isOrdered();
        }
    }>

### Comments

The above codes connects the object Factory with a given state String. 
The tile String was stored as a Field 'public String tileStr'. 
The best features of the above codes: 
An ArrayList of 'Tiles' is built to represent the tile information, instead of using pure String or Array. 
This simplifies the information assignment and manipulation. 
Also, it accelerates the program and optimize the memory allocation. 
What's more, by treated as an Object and Fields, many methods could be generated to optimize the whole program.
The class and method structure are also appropriate. A certain proper style is also well consistent throughout.
While it still has a potential error when the game is running: 
In the setFacNumber() method, the 'f' tile should not be assigned to factory's tiles. 
It does not have a check procedure for this condition, which might generated some errors about 'f' in game running.


