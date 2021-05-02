package comp1110.ass2.KeNingTest;
import comp1110.ass2.Mosaic;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class MosaicTilesWellFormedTest {
    @Test
    public void testCorrectMosaic(){
        String input = "b00a02a13e42";
        assertTrue(Mosaic.mosaicTilesWellFormed(input)==true);
    }

    @Test
    public void test1stWell(){
        String input = "b00g02a13e42";
        assertTrue(Mosaic.mosaicTilesWellFormed(input)==false);
    }

    @Test
    public void test2ndWell(){
        String input = "b70a02a13e42";
        assertTrue(Mosaic.mosaicTilesWellFormed(input)==false);
    }

    @Test
    public void test3rdWell(){
        String input = "b00a08a13e42";
        assertTrue(Mosaic.mosaicTilesWellFormed(input)==false);
    }

    @Test
    public void testOrderWell(){
        String input = "b10a02a13e42";
        assertTrue(Mosaic.mosaicTilesWellFormed(input)==false);
    }

    @Test
    public void testLengthWell(){
        String input = "b10a02a13e42asdd";
        assertTrue(Mosaic.mosaicTilesWellFormed(input)==false);
    }


}
