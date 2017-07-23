package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import Service.PerformancesEditing;




import domain.Lobby;
import domain.Money;
import domain.Performance;
import domain.Play;
import domain.Seat;
import domain.PerformanceType;

public class PerformancesEditingTest {
	PerformancesEditing editor = new PerformancesEditing();
	String Title = "Arxontoxwriatis";
	PerformanceType type = PerformanceType.COMEDY;
	String [] directors = new String[10];
	String[] actors = new String[10];
	Money price = new Money();
	Date date = new Date();
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy 'at' HH:mm");
	Lobby l1 = new Lobby();
	Performance p1 = new Performance();
	
	/**
	 * Create a Performance through the Performace Editor
	 * Check if it is saved Succesfully and with the appropriate values
	 */
	@Test
	public void CreatePerformanceTest() {
		
		actors[0] = "Mpezos";
		actors[1] = "Xaikalis";
								
		
		directors[0] = "Georgakopoulos";
		
		price.setAmount(30);
		price.setCurrency("EURO");
						
		
		try {
			date = dateFormat.parse("31/05/2017 at 22:30");
		} catch (ParseException e) {
			System.out.println("Error");
		}			
			
		l1.setCode(10);
		l1.setNumOfSeats(50);
						
		editor.CreatePerformance(Title, actors, directors, type, price, l1, date);
		
		Assert.assertEquals(1, editor.getPerformances().size());
		
		Assert.assertEquals("Arxontoxwriatis", editor.getPerformances().get(0).getTitle());
	}
	
	@Test
	/**
	 * Edit a Performance through the editor
	 * Check if the changes were successful
	 * 
	 * Also Make Changes with NULL values
	 * Check if the editor spots them and keeps the old values
	 */
	public void EditPerformanceTest(){

		
		actors[0] = "Mpezos";
		actors[1] = "Xaikalis";
								
		
		directors[0] = "Georgakopoulos";
		
		price.setAmount(30);
		price.setCurrency("EURO");
						
		
		try {
			date = dateFormat.parse("31/05/2017 at 22:30");
		} catch (ParseException e) {
			System.out.println("Error");
		}			
			
		l1.setCode(10);
		l1.setNumOfSeats(50);
		
		Play play = new Play(Title,actors,directors,type,price);
		p1.setPlay(play);
		
		p1.setDate(date);
		
		p1.setLobby(l1);
		
						
		editor.CreatePerformance(Title, actors, directors, type, price, l1, date);
		
//		Change Performance Values
		
		actors[0] = "Papadopoulos";
		actors[1] = "Mpoulas";
		
		directors[0] = "Thanou";
		
		type = PerformanceType.KIDS;
		
		price.setAmount(100);
		
		
		l1.setCode(7);
		
		try {
			date = dateFormat.parse("31/08/2016 at 22:30");
		} catch (ParseException e) {
			System.out.println("Error");
		}
		
//		Send new data to the editor
		
		editor.EditPerformance(p1, actors, price.getAmount(), date, l1);
		
		
		Assert.assertEquals(7,editor.getPerformances().get(0).getLobby().getCode());
		Assert.assertEquals(100,editor.getPerformances().get(0).getPrice().getAmount(),0);
		
		try {
			Assert.assertEquals(dateFormat.parse("31/08/2016 at 22:30"),editor.getPerformances().get(0).getDate());
		} catch (ParseException e) {
			System.out.println("Error");
		}
		
			
//		Test if editor finds null and doesn't change values
		
		editor.EditPerformance(p1, actors, 0, null, null);
		
		Assert.assertEquals(7,editor.getPerformances().get(0).getLobby().getCode());
		Assert.assertEquals(100,editor.getPerformances().get(0).getPrice().getAmount(),0);
		
		try {
			Assert.assertEquals(dateFormat.parse("31/08/2016 at 22:30"),editor.getPerformances().get(0).getDate());
		} catch (ParseException e) {
			System.out.println("Error");
		}
		
	}
	
	/**
	 * Delete a Performance from the editor
	 * Check if the deletion was completed
	 */
	@Test
	public void DeletePerformanceTest(){
//		Create the Performance
			
			actors[0] = "Mpezos";
			actors[1] = "Xaikalis";
									
			
			directors[0] = "Georgakopoulos";
			
			price.setAmount(30);
			price.setCurrency("EURO");
							
			
			try {
				date = dateFormat.parse("31/05/2017 at 22:30");
			} catch (ParseException e) {
				System.out.println("Error");
			}			
				
			l1.setCode(10);
			l1.setNumOfSeats(50);
			
			Play play = new Play(Title,actors,directors,type,price);
			p1.setPlay(play);
			
			p1.setDate(date);
			
			p1.setLobby(l1);
			
							
			editor.CreatePerformance(Title, actors, directors, type, price, l1, date);
			
//			Call the delete editor
			
			editor.DeletePerformance(p1);
			
			Assert.assertEquals(0, editor.getPerformances().size());
		
			}
	
	/**
	 * Get a Performance profits through the editor
	 * Check if the amount is correct
	 */
	public void getPerformanceprofitsTest(){
//		Create the Performance
			
			actors[0] = "Mpezos";
			actors[1] = "Xaikalis";
									
			
			directors[0] = "Georgakopoulos";
			
			price.setAmount(30);
			price.setCurrency("EURO");
							
			
			try {
				date = dateFormat.parse("31/05/2017 at 22:30");
			} catch (ParseException e) {
				System.out.println("Error");
			}			
				
			l1.setCode(10);
			l1.setNumOfSeats(50);
			
			Play play = new Play(Title,actors,directors,type,price);
			p1.setPlay(play);
			
			p1.setDate(date);
			
			
			
//		Seat Lobby's Seats
			
			Seat s1 = new Seat(1,false);
			Seat s2 = new Seat(2,false);
			
			l1.AddSeats(s1);
			l1.AddSeats(s2);
			
			p1.setLobby(l1);
							
			editor.CreatePerformance(Title, actors, directors, type, price, l1, date);
			
			double profits = editor.getPerformanceprofits(p1);
			
			Assert.assertEquals(60,profits,0);
			
			
		
	}
	
	/**
	 * Get a Performance's Reserved Seats through the editor
	 * Check if the amount is correct
	 */
	@Test
	public void getPerformanceReservedSeatsTest(){
		
//		Create the Performance
		
			actors[0] = "Mpezos";
			actors[1] = "Xaikalis";
									
			
			directors[0] = "Georgakopoulos";
			
			price.setAmount(30);
			price.setCurrency("EURO");
							
			
			try {
				date = dateFormat.parse("31/05/2017 at 22:30");
			} catch (ParseException e) {
				System.out.println("Error");
			}			
				
			l1.setCode(10);
			l1.setNumOfSeats(50);
			
			Play play = new Play(Title,actors,directors,type,price);
			p1.setPlay(play);
			
			p1.setDate(date);
			
			
			
//		Seat Lobby's Seats
			
			Seat s1 = new Seat(1,false);
			Seat s2 = new Seat(2,false);
			
			l1.AddSeats(s1);
			l1.AddSeats(s2);
			
			p1.setLobby(l1);
							
			editor.CreatePerformance(Title, actors, directors, type, price, l1, date);
			
			Assert.assertEquals(2,p1.getLobby().getReservedSeats());
	}

	
	
}
