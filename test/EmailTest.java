package test;
import domain.Email;

import org.junit.Assert;
import org.junit.Test;

public class EmailTest {

	@Test
	public void test() {
		Email mail = new Email("p3130035@dias.aueb.gr");
		String expected_full = "p3130035@dias.aueb.gr";
		String expected_address = "p3130035";
		String expected_domain = "dias.aueb.gr";
		
		Assert.assertEquals(expected_full,mail.getFullMail());
		Assert.assertEquals(expected_address,mail.getAddress());
		Assert.assertEquals(expected_domain,mail.getDomain());
	}

}
