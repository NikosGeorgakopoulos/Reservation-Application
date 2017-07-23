package test;
import org.junit.Assert;
import org.junit.Test;
import domain.Client;
import domain.Email;


public class ClientTest {

	@Test
	public void ClientCreationTest() {
		
		Client c1 = new Client();
		c1.setName("Giwrgos");
		c1.setSurname("Mazwnakis");
		
		Email mail = new Email("p3130035@dias.aueb.gr");
		c1.setMail(mail);
		
		Assert.assertEquals("Giwrgos", c1.getName());
		Assert.assertEquals("Mazwnakis", c1.getSurname());
		Assert.assertEquals(mail, c1.getMail());
	}

}
