package test;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;

import org.junit.Test;

import domain.Reservation;
import domain.Performance;
import domain.Play;
import domain.PerformanceType;
import domain.Money;
import domain.Lobby;

public class ReservationTest {

	Reservation r1 = new Reservation();
	
	
	
	@Test
	public void FindPerformanceTest(){
		Performance p1 = new Performance();
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy 'at' HH:mm");
		try {
			date = dateFormat.parse("31/05/2017 at 22:30");
		} catch (ParseException e) {
			System.out.println("Error");
		}
		
		p1.setDate(date);
		p1.setPlay(CreatePlay());
		
		Lobby l1 = new Lobby();
		l1.setCode(10);
		l1.setNumOfSeats(50);
		
		p1.setLobby(l1);
		
		r1.AddPerformance(p1);
		
		Assert.assertEquals(1,r1.getPerformances().size());
		
		Performance p2 = r1.findPerformance("Arxontoxwriatis");
		
		Assert.assertEquals("Arxontoxwriatis", p2.getTitle());

	}

	
	private Play CreatePlay() {
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
		return play;
		
	}

}
