package test;
import domain.Payment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import domain.PaymentType;


public class PaymentTest {
	
	
	@Test
	public void PaymentCreationTest() {
		Payment p1 = new Payment();
		
		p1.setAmount(37.5);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy 'at' HH:mm");
		Date date = new Date();
		try {
			date = dateFormat.parse("31/05/2017 at 22:30");
		} catch (ParseException e) {
			System.out.println("Error");
		}
		
		p1.setWayOfPayment(PaymentType.Cash);
		p1.setDateOfPayment(date);
		
		
		Assert.assertEquals(37.5,p1.getAmount(),0);
		
		try {
			Assert.assertEquals(dateFormat.parse("31/05/2017 at 22:30"),p1.getDateOfPayment());
		} catch (ParseException e) {
			System.out.println("Error");
		}
		
		Assert.assertEquals(PaymentType.Cash,p1.getWayOfPayment());
	}

}
