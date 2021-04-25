package comp1110.ass2.KeNingTest;
import comp1110.ass2.D2B.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GetNUmberOfPlayerTest {

    @Test
    public void test2Players(){
        String totalPlayerState = "A0Me04b11S2c13a34a1FB1Mc02d33S1b12e1F";
        int numberOfPlayer = 2;
        assertTrue(numberOfPlayer== Player.getNUmberOfPlayer(totalPlayerState));
    }

    @Test
    public void test1Players(){
        String totalPlayerState = "A0Me04b11S2c13a34a1F";
        int numberOfPlayer = 1;
        assertTrue(numberOfPlayer== Player.getNUmberOfPlayer(totalPlayerState));
    }

    @Test
    public void test0Players(){
        String totalPlayerState = "";
        int numberOfPlayer = 0;
        assertTrue(numberOfPlayer== Player.getNUmberOfPlayer(totalPlayerState));
    }

    @Test
    public void testExtraPlayers(){
        String totalPlayerState = "A0Me04b11S2c13a34a1FB1Mc02d33S1b12e1FC0Me04b11S2c13a34a1FD1Mc02d33S1b12e1FE1Mc02d33S1b12e1F";
        int numberOfPlayer = 999;
        assertTrue(numberOfPlayer== Player.getNUmberOfPlayer(totalPlayerState));
    }




}
