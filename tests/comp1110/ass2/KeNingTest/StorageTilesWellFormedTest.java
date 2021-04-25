package comp1110.ass2.KeNingTest;
import comp1110.ass2.D2B.Mosaic;
import comp1110.ass2.D2B.Player;
import comp1110.ass2.D2B.Storage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class StorageTilesWellFormedTest {
    @Test
    public void testCorrectStorage(){
        String input = "2a13e44a1";
        assertTrue(Storage.storageTilesWellFormed(input)==true);
    }

    @Test
    public void testLength(){
        String input = "2a13e44a1asas";
        assertTrue(Storage.storageTilesWellFormed(input)==false);
    }

    @Test
    public void test2ndWell(){
        String input = "2g13e44a1";
        assertTrue(Storage.storageTilesWellFormed(input)==false);
    }

    @Test
    public void testOrderWell(){
        String input = "5a13e44a1";
        assertTrue(Storage.storageTilesWellFormed(input)==false);
    }

    @Test
    public void test1stWell(){
        String input = "2a19e44a1";
        assertTrue(Storage.storageTilesWellFormed(input)==false);
    }

    @Test
    public void test3rdWell(){
        String input = "2a13e84a1";
        assertTrue(Storage.storageTilesWellFormed(input)==false);
    }




}
