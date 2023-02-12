import java.util.*;
import com.google.common.annotations.VisibleForTesting;


public class TestDemo {

	
	public int addPositive(int a, int b) {
		
		if( a < 1 || b < 1) {																// test a and b for zero or negative values
			throw new IllegalArgumentException("Both parameters musst be positive!");		// throw Illegal Argument Exception if a or b is zero or negative
		} else {
			return a + b;																	// add a + b if both are greater than zero
		}
		
	}
	
	
	public int randomNumberSquared() {
		
		int result = getRandomInt();					// call getRandomInt for a random integer (1-10)
		return result * result;							// multiply random int by itself and return value
	}
	
	
	@VisibleForTesting
	int getRandomInt() {

		Random random = new Random();
		return random.nextInt(10) + 1;					// generates random int between 0 and value (exclusive) specified as parameter, +1 makes it non-zero

	}
	
}
