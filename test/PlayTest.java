package test;
import org.junit.Assert;

import org.junit.Test;
import domain.PerformanceType;
import domain.Money;
import domain.Play;

public class PlayTest {

	@Test
	public void CreatePlayTest() {
		String Title = "Arxontoxwriatis";
		PerformanceType type = PerformanceType.COMEDY;
		
		String[] actors = new String[10];
		actors[0] = "Mpezos";
		actors[1] = "Xaikalis";
								
		String [] directors = new String[10];
		directors[0] = "Georgakopoulos";
		
		Money price = new Money();
		price.setAmount(30);
		price.setCurrency("EURO");
		
		Play play = new Play (Title, actors, directors, type , price);
		
		Assert.assertEquals("Arxontoxwriatis",play.getTitle());
		Assert.assertEquals(PerformanceType.COMEDY,play.getType());
		Assert.assertArrayEquals(actors,play.getActors());
		Assert.assertArrayEquals(directors,play.getDirectors());
		Assert.assertEquals(30,play.getPrice().getAmount(),0);
		Assert.assertEquals("EURO",play.getPrice().getCurrency());
		
	}

}
