package comp1110.ass2;


import comp1110.ass2.D2B.Mosaic;
import comp1110.ass2.D2B.Score;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class GetTilesFromMosaicTest {
    private static int BASE_ITERATIONS = 10000;

    @Test
    public void testReturnTilesInMosaic() {
        String[] sharedState = {"A07Me01a11d20b30b41S0a11b22c13c44d1Fee","AMSF"};
        for (int i = 0; i < BASE_ITERATIONS; i++) {
            String tiles = Mosaic.getTilesFromMosaic(sharedState);
            Assertions.assertEquals("e01a11d20b30b41", tiles);
        }
    }
}
