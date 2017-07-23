package test;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import domain.Lobby;
import domain.Sectrange;
import domain.Seat;

public class LobbyTest {
	Lobby l1 = new Lobby();
	/**
	 * Creating a Lobby and checking if the values are inserted correctly
	 * Also Checking if we get the right amount of available Seats and Consecutive sectors
	 */
	@Test
	public void LobbyCreationTest() {
		
		l1.setCode(1);
		l1.setNumOfSeats(50);
		seatscreator(40,true);
		l1.FindSeats();
		l1.FindConsecutiveSeats();
		
		Assert.assertEquals(1,l1.getCode());
		Assert.assertEquals(50,l1.getNumOfSeats());
		Assert.assertEquals(36,l1.getSeats().size());
		Assert.assertEquals(36,l1.getAvailableSeats().size());
		Assert.assertEquals(32,l1.getConsecutiveSeats().size());
		
	}
	/**
	 * Lobby creation with more than the permitted amount of seats
	 * Check if the Number of Seats does not exceed boundaries
	 */
	@Test
	public void LobbyOverflowCreationTest() {
		l1.setNumOfSeats(50);
		l1.setCode(1);
		l1.setNumOfSeats(50);
		seatscreator(150,true);
		l1.FindSeats();
		l1.FindConsecutiveSeats();
		
		Assert.assertEquals(50,l1.getSeats().size());
		Assert.assertEquals(50,l1.getAvailableSeats().size());
		Assert.assertEquals(44,l1.getConsecutiveSeats().size());
		
	}
	
	/**
	 * Lobby with no Available Seats
	 * So the List of the Available Seats should have size 0
	 */
	
	@Test
	public void LobbyNoavailablesCreationTest() {
		l1.setNumOfSeats(50);
		l1.setCode(1);
		l1.setNumOfSeats(50);
		seatscreator(50,false);
		l1.FindSeats();
		
		
		Assert.assertEquals(45,l1.getSeats().size());
		Assert.assertEquals(0,l1.getAvailableSeats().size());
		
		
		
	}
	
	/**
	 * Lobby with no Consecutive Sectors
	 * The corresponding list should  have 0 size
	 */
	@Test
	public void LobbyNoConsecutivesCreationTest() {
		l1.setNumOfSeats(50);
		l1.setCode(1);
		l1.setNumOfSeats(50);
		specialseatscreator(60,true);
		l1.FindSeats();
		l1.FindConsecutiveSeats();
		
		Assert.assertEquals(50,l1.getSeats().size());
		Assert.assertEquals(22,l1.getAvailableSeats().size());
		Assert.assertEquals(0,l1.getConsecutiveSeats().size());
		
		
	}
	
	@Test
	/**
	 * Create Lobby with Available Seats and Consecutive Sectors
	 * Test if we can find our desire sectrange
	 */
	public void LobbyConsecutiveFinderTest() {
		ArrayList<Sectrange> S1 = new  ArrayList<Sectrange>();
		l1.setNumOfSeats(50);
		l1.setCode(1);
		l1.setNumOfSeats(50);
		seatscreator(60,true);
		l1.FindSeats();
		l1.FindConsecutiveSeats();
		S1 = l1.ConsecutiveSeatSelector(8);
		
		Assert.assertEquals(50,l1.getSeats().size());
		Assert.assertEquals(50,l1.getAvailableSeats().size());
		Assert.assertEquals(44,l1.getConsecutiveSeats().size());
		Assert.assertEquals(5,S1.size());
		
	}

	private void specialseatscreator(int x, boolean flag) {
		for(int j = 0; j<x; j+=10){
			for(int i=1;i<10;i++){
			Seat s1 = new Seat(i+j,flag);
			if((s1.getCode() & 1) == 1 ){
				s1.setAvailable(false);
			}
			
			l1.AddSeats(s1);
			}
		}
		
	}

	public void seatscreator(int x,boolean flag) {
		
		
		for(int j = 0; j<x; j+=10){
			for(int i=1;i<10;i++){
			Seat s1 = new Seat(i+j,flag);
			
			l1.AddSeats(s1);
			}
		}	
				
	}

	
	
	

}
