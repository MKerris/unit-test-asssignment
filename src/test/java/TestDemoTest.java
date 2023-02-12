import static org.assertj.core.api.Assertions.*;
import java.util.stream.Stream;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

class TestDemoTest {

	private TestDemo testDemo = new TestDemo();
	
	@BeforeEach
	void setUp() throws Exception {
		
		testDemo = new TestDemo();					// creates new object each time test is run
	}

	@ParameterizedTest															
	@MethodSource("TestDemoTest#argumentsForAddPositive")						// points method to argumentsForAddPositive for testing
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, Boolean expectException) {

		// Given: Two integers a and b, both non-zero and not negative
		// When: addPositive is evaluated
		// Then: Adding a + b should equal expected
		if(!expectException) {													// if expectException is false, test a + b = expected
			assertThat(testDemo.addPositive(a,b)).isEqualTo(expected);
		} else {																// if expectException is true, check to see if IllegalArgumentException is thrown

			// When: addPositive is evaluated
			// Then: Throw exception if a and/or b are zero or negative
			assertThatThrownBy(() -> testDemo.addPositive(a,b)).isInstanceOf(IllegalArgumentException.class);

		}
	}

	// Specify test values for assertThatTwoPositiveNumbersAreAddedCorrectly
	static Stream<Arguments> argumentsForAddPositive() {

		// @formatter:off
		return Stream.of(
				arguments(0,4,4,true),				// 0 value for a, should throw exception
				arguments(2,0,2,true),				// 0 value for b, should throw exception
				arguments(0,0,0,true),				// 0 values for a and b, should throw exception
				arguments(-2,-4,-6,true),			// negative values for a and b, should throw exception
				arguments(-2,4,2,true),				// negative value for a, should throw exception
				arguments(2,-4,-2,true),			// negative value for b, should throw exception
				arguments(2,4,6,false)				// valid values for a and b, should succeed without exception
				);
		// @formatter:on
		
	}
	
	
	@Test
	void assertThatNumberSquaredIsCorrect() {
		
		TestDemo mockDemo = spy(testDemo);								// Create mocked instance of testDemo

		// Given: An int of 5
		doReturn(5).when(mockDemo).getRandomInt();						// Return a value of 5 when getRandomInt is called

		// When: getRandomInt is called
		int fiveSquared = mockDemo.randomNumberSquared();				// Run 5 through randomNumberSquared to test for a known value

		// Then: Verify randomNumberSquared returns 25
		assertThat(fiveSquared).isEqualTo(25);							// Test that method properly calculated 5*5
		
	}
}
