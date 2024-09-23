import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class FactorialCalculatorTest {

    @Test
    public void testFactorialZero() {
        assertEquals(1, FactorialCalculator.factorial(0));
    }

    @Test
    public void testFactorialOne() {
        assertEquals(1, FactorialCalculator.factorial(1));
    }

    @Test
    public void testFactorialFive() {
        assertEquals(120, FactorialCalculator.factorial(5));
    }

    @Test
    public void testFactorialTen() {
        assertEquals(3628800, FactorialCalculator.factorial(10));
    }

    @Test
    public void testFactorialNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
            FactorialCalculator.factorial(-5);
        });
    }
}
