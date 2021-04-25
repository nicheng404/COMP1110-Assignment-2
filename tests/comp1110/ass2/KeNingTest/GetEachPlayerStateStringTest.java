package comp1110.ass2.KeNingTest;
import comp1110.ass2.D2B.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class GetEachPlayerStateStringTest {
    @Test
    public void test2Players(){
        String input = "A0Me04b11S2c13a34a1FB1Mc02d33S1b12e1F";
        String[] expectedOutput = {"A0Me04b11S2c13a34a1F","B1Mc02d33S1b12e1F"};
        String[] realOutput = Player.getEachPlayerStateString(input);
        assertArrayEquals(realOutput,realOutput);
    }

    @Test
    public void test1Players(){
        String input = "A0Me04b11S2c13a34a1F";
        String[] expectedOutput = {"A0Me04b11S2c13a34a1F"};
        String[] realOutput = Player.getEachPlayerStateString(input);
        assertArrayEquals(realOutput,realOutput);
    }




}
