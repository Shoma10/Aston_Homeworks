import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

public class FactorialCalculatorTestng {

    @Test
    public void testFactorialZero() {
        assertEquals(FactorialCalculator.factorial(0), 1);
    }

    @Test
    public void testFactorialOne() {
        assertEquals(FactorialCalculator.factorial(1), 1);
    }

    @Test
    public void testFactorialFive() {
        assertEquals(FactorialCalculator.factorial(5), 120);
    }

    @Test
    public void testFactorialTen() {
        assertEquals(FactorialCalculator.factorial(10), 3628800);
    }

    @Test
    public void testFactorialNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
            FactorialCalculator.factorial(-5);
        });
    }
}
