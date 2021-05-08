package comp1110.ass2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GetTilesFromBagTest {
    private static int BASE_ITERATIONS = 10000;

    @Test
    public void testBagEmpty() {
        String[] sharedState = {"AFCB000000000000D0000000000", "A0MSFB0MSF"};
        for (int i = 0; i < BASE_ITERATIONS; i++) {
            String tiles = Bag.getTilesFromBag(sharedState);
            Assertions.assertEquals("000000000000", tiles);
        }
    }

    @Test
    public void testBagNotEmpty() {
        String[] sharedState = {"AFCB004000070010D0000000000", "A0MSFB0MSF"};
        for (int i = 0; i < BASE_ITERATIONS; i++) {
            String tiles = Bag.getTilesFromBag(sharedState);
            Assertions.assertEquals("004000070010", tiles);
        }
    }
}

