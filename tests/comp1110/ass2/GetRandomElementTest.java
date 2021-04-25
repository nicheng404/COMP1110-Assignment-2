package comp1110.ass2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class GetRandomElementTest {

    private static int BASE_ITERATIONS = 10000;

    @Test
    public void testDrawRandomElement() {
        char element = Bag.getRandomElement();
        assertFalse(element < 'a' || element > 'e', "Expected a char between 'a' and 'e', but you drew: " + element);

    }

}

