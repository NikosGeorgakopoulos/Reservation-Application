package test;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import domain.Performance;
import domain.Lobby;
import domain.Seat;
import domain.Sectrange;
import domain.Client;
import domain.Payment;
import domain.PaymentType;
import domain.PerformanceType;
import domain.Play;
import domain.Money;
import domain.Email;


public class PerformanceTest {
	Performance p1 = new Performance();
	/**
	 * Create a Performance
	 * Check if the values are inserted correctly
	 */
	@Test
	public void PerfomanceCreationTest() {
		
		CreatePlays();
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy 'at' HH:mm");
		try {
			date = dateFormat.parse("31/05/2017 at 22:30");
		} catch (ParseException e) {
			System.out.println("Error");
		}
		
		p1.setDate(date);
		
		String[] actors = new String[10];
		actors[0] = "Mpezos";
		actors[1] = "Xaikalis";
		
		String [] directors = new String[10];
		directors[0] = "Georgakopoulos";
		
		
		
		
		
		Lobby l1 = new Lobby();
		l1.setCode(10);
		l1.setNumOfSeats(50);
		
		p1.setLobby(l1);
		
		
		Assert.assertEquals("Arxontoxwriatis",p1.getTitle());
		Assert.assertArrayEquals(actors,p1.getActors());
		Assert.assertArrayEquals(directors,p1.getDirectors());
		
		Assert.assertEquals(30,p1.getPrice().getAmount(),0);
		try {
			Assert.assertEquals(dateFormat.parse("31/05/2017 at 22:30"),p1.getDate());
		} catch (ParseException e) {
			System.out.println("Error");
		}
		
		Assert.assertEquals(10,p1.getLobby().getCode());
		Assert.assertEquals(50,p1.getLobby().getNumOfSeats());
		
		
	}
	
	/**
	 * Make a reservation for a performance
	 * Check if the Clients info was inserted correctly
	 * And if the Seat was reserved
	 */
	@Test
	public void MakeReservationTest(){
		Lobby l1 = CreateLobby();
		Payment payment = CreatePayment();
		Client c1 = CreateClient();
		p1.setLobby(l1);
		CreatePlays();
		p1.makeReservation(1, c1, payment);
		
		Assert.assertEquals("Arxontoxwriatis", p1.getReservation().getPerformance().getTitle());
		Assert.assertEquals(1, p1.getReservation().getCode());
		Assert.assertEquals("Mazwnakis",p1.getReservation().getClient().getSurname());
		Assert.assertEquals(PaymentType.Cash, p1.getReservation().getPayment().getWayOfPayment());
		Assert.assertEquals(false,p1.getLobby().RetrieveSeatState(1));
			
	}
	
	@Test
	/**
	 * Make a number of reservations for a performance
	 * Again check if the corresponding seats where reserved 
	 */
	public void MakeReservationsTest(){
		Lobby l1 = CreateLobby();
		Payment payment = CreatePayment();
		Client c1 = CreateClient();
		p1.setLobby(l1);
		CreatePlays();
		Sectrange S1 = new Sectrange(l1.getSeats().get(0),l1.getSeats().get(5),6);
		
		p1.makeReservations(S1, c1, payment);
		Assert.assertEquals(false,p1.getLobby().RetrieveSeatState(1));
		Assert.assertEquals(false,p1.getLobby().RetrieveSeatState(2));
		Assert.assertEquals(false,p1.getLobby().RetrieveSeatState(3));
		Assert.assertEquals(false,p1.getLobby().RetrieveSeatState(4));
		Assert.assertEquals(false,p1.getLobby().RetrieveSeatState(5));
	}
	
	private void CreatePlays() {
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
		p1.setPlay(play);
		
	}
	
	private Lobby CreateLobby(){
		
		Lobby l1 = new Lobby();
		l1.setCode(1);
		l1.setNumOfSeats(50);
		
		for(int j = 0; j<50; j+=10){
			for(int i=1;i<10;i++){
			Seat s1 = new Seat(i+j,true);
			
			l1.AddSeats(s1);
			}
		}
		
		return l1;
	}
	
	
	private Payment CreatePayment(){
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
		
		return p1;
	}
	
	
	private Client CreateClient(){
		Client c1 = new Client();
		c1.setName("Giwrgos");
		c1.setSurname("Mazwnakis");
		c1.setMail(new Email("p3130035@dias.aueb.gr"));
		
		return c1;
	}

}
