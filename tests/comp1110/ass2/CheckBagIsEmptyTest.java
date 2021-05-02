package comp1110.ass2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CheckBagIsEmptyTest {
    private static int BASE_ITERATIONS = 10000;
    @Test
    public void testTiles() {
        String[] sharedState = {"AFCB000000000000D0000000000", "A0MSFB0MSF"};
        for (int i = 0; i < BASE_ITERATIONS; i++) {
            boolean emptyBag = Bag.checkBagIsEmpty(sharedState);
            Assertions.assertTrue(emptyBag == false);
        }
    }
    @Test
    public void testTiles2() {
        String[] sharedState = {"AFCB000300000100D0000000000", "A0MSFB0MSF"};
        for (int i = 0; i < BASE_ITERATIONS; i++) {
            boolean emptyBag = Bag.checkBagIsEmpty(sharedState);
            Assertions.assertTrue(emptyBag == false);
        }
    }



}
