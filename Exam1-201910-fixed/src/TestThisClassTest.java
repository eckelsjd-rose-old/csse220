import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestThisClassTest {

	@Test
	public void test() {
		assertEquals(2, TestThisClass.intersectionSize(1, 3, 2, 4));
		assertEquals(4, TestThisClass.intersectionSize(5, 10, 7, 50));
		assertEquals(5, TestThisClass.intersectionSize(0, 4, 0, 4));
		assertEquals(0, TestThisClass.intersectionSize(1, 10, 11, 20));
	}

}
