package org.ale.app;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Test;


public class TestMyDummyTest {

	private MyDummy dummy;
	
	@Before
	public void setUp() {
		dummy = new MyDummy();
	}
	
	@Test
	public void shouldReturnThree() {
		assertThat(dummy.returnThree(), is(equalTo(3)));
	}
}
