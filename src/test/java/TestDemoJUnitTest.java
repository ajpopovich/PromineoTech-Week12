import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.promineotech.TestDemo;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

public class TestDemoJUnitTest {

    private TestDemo testDemo;

    @BeforeEach
    public void setUp() {
        testDemo = new TestDemo();
    }

    @ParameterizedTest
    @MethodSource("argumentsForAddPositive")
    public void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
        if (!expectException) {
            assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
        } else {
            assertThatThrownBy(() ->
                    testDemo.addPositive(a, b))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    static Stream<Arguments> argumentsForAddPositive() {
        return Stream.of(
                arguments(2, 4, 6, false),
                arguments(2, 6, 8, true),
                arguments(0, 4, 4, true),
                arguments(-5, 2, 3, false),
                arguments(-10, 8, 2, true)
        );
    }
    @Test
    void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
    	assertThat(testDemo.addPositive(17, 11)).isEqualTo(28);
    	assertThat(testDemo.addPositive(100, 100)).isEqualTo(200);
    }
    @Test
    void testCalculateAreaOfRectangle() {
    	assertThat(TestDemo.calculateAreaOfRectangle(10.0, 5.5)).isEqualTo(55);
    	
    	//this test case uses the given length of 10.0 and width of 5.5 for an expected outcome of 55
    }

    @Test
    void assertThatNumberSquaredIsCorrect() {
    TestDemo testDemo = new TestDemo();
    TestDemo mockDemo = spy(testDemo);
    
    doReturn(5).when(mockDemo).getRandomInt();
    
    int fiveSquared = mockDemo.randomNumberSquared();
    
    assertThat(fiveSquared).isEqualTo(25);
    }
}


