package dao;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import domain.*;





public abstract class Initializer  {
        
    
    protected abstract void eraseData();
    
    
  
    
    public void prepareData() {
        
        eraseData();
        Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy 'at' HH:mm");
		
		
		
        Lobby l1 = new Lobby ();
    	Lobby l2 = new Lobby ();
    	Lobby lux = new Lobby ();
    	
    	l1.setCode(1);
    	l1.setNumOfSeats(100);
    	
    	l2.setCode(3);
    	l2.setNumOfSeats(100);
    	
    	lux.setCode(3);
    	lux.setNumOfSeats(30);
    		
    	Seat s1 = new Seat (1, true);
    	Seat s2 = new Seat (2, true);
    	Seat s3 = new Seat (3, true);
    	Seat s4 = new Seat (4, false);
    	Seat s5 = new Seat (10, true);
    	Seat s6 = new Seat (11, true);
    	
    	l1.AddSeats(s1);
    	l1.AddSeats(s2);
    	l1.AddSeats(s3);
    	l1.AddSeats(s4);
    	l1.AddSeats(s5);
    	l1.AddSeats(s6);
    	
    	l2.AddSeats(s1);
    	l2.AddSeats(s2);
    	l2.AddSeats(s3);
    	l2.AddSeats(s4);
    	l2.AddSeats(s5);
    	l2.AddSeats(s6);
    	
    	lux.AddSeats(s1);
    	lux.AddSeats(s2);
    	lux.AddSeats(s3);
    	lux.AddSeats(s4);
    	lux.AddSeats(s5);
    	lux.AddSeats(s6);
    	
    	
//		Arxontoxwriatis
    	
    	Money price1 = new Money();
		price1.setAmount(30);
		price1.setCurrency("EURO");
		
		String[] actors_1 ={"Mpezos","Xaikalis"};
										
		String [] directors_1 = {"Georgakopoulos"};
		   		
    	Play Arxontoxwriatis = new Play ("Arxontoxwriatis", actors_1, directors_1, PerformanceType.COMEDY , price1); 
    	
//    	Ornithes
    	
    	
    	String[] actors_2 ={"Ntanos","Xaralampopoulos"};
		
		String [] directors_2 = {"Aristofanis"};
    	
    	
    	Money price2 = new Money();
		price2.setAmount(15);
		price2.setCurrency("EURO");
    	
    	Play Ornithes = new Play ("Ornithes", actors_2, directors_2, PerformanceType.SATIRE , price2);
    	
//    	Mama Mia	
    	
    	String[] actors_3 ={ "Meryl Streep","Spaliaras"};
		
		String [] directors_3 = {"M.Night.Shaymalan"};
    	    	
    	Money price3 = new Money();
		price3.setAmount(50);
		price3.setCurrency("EURO");
    	

    	
    	Play Mama_mia = new Play ("Mama Mia", actors_3, directors_3, PerformanceType.MUSICAL , price3);
    	
//    	Antigoni
    	
    	
    	String[] actors_4 ={ "Antigoni","Kraiontas"};
		
		String [] directors_4 = {"Sofoklis"};
    	
    	Money price4 = new Money();
		price4.setAmount(65);
		price4.setCurrency("EURO");
    	
    	Play Antigoni = new Play ("Antigoni", actors_4, directors_4, PerformanceType.DRAMA , price4);
    	
//    	Interstellar
    	
    	
    	String[] actors_5 ={"Matthew Mcconaughey","Anne Hathaway"};
		
		String [] directors_5 = {"Christopher Nolan"};
    	
    	Money price5 = new Money();
    	price5.setAmount(70);
		price5.setCurrency("EURO");
    	
    	
    	Play Interstellar = new Play ("Interstellar", actors_5, directors_5, PerformanceType.KIDS , price5);
    	
/*-------------------------------------------------------------------------------------------------------------*/
    	
    	
//    	Performance p1
    	
    	Performance p1 = new Performance();
    	
    	p1.setPlay(Interstellar);
    	
    	try {
			date = dateFormat.parse("31/05/2017 at 22:30");
		} catch (ParseException e) {
			System.out.println("Error");
		}
    	
    	p1.setDate(date);
    	
    	p1.setLobby(l1);
    	
    	
//    	Performance p2
    	
    	Performance p2 = new Performance();
    	
    	p2.setPlay(Interstellar);
    	
    	Date date_2 = new Date();
    	try {
			date_2 = dateFormat.parse("24/05/2017 at 22:30");
		} catch (ParseException e) {
			System.out.println("Error");
		}
    	
    	p2.setDate(date_2);
    	
    	p2.setLobby(l1);
    	
    	
    	    	
//    	Performance p3
    	
    	Performance p3 = new Performance();
    	
    	p3.setPlay(Antigoni);
    	
    	Date date_3 = new Date();
    	try {
    		date_3 = dateFormat.parse("20/05/2017 at 22:00");
		} catch (ParseException e) {
			System.out.println("Error");
		}
    	
    	p3.setDate(date_3);
    	
    	p3.setLobby(l1);
    	
    	
    	
    	
//    	Performance p4
    	
    	Performance p4 = new Performance();
    	
    	p4.setPlay(Antigoni);
    	
    	Date date_4 = new Date();
    	try {
			date_4 = dateFormat.parse("22/05/2017 at 22:00");
		} catch (ParseException e) {
			System.out.println("Error");
		}
    	
    	p4.setDate(date_4);
    	
    	p4.setLobby(l1);
    	
    	
//    	Performance p5
    	
    	Performance p5 = new Performance();
    	
    	p5.setPlay(Mama_mia);
    	
    	Date date_5 = new Date();
    	try {
			date_5 = dateFormat.parse("20/06/2017 at 21:00");
		} catch (ParseException e) {
			System.out.println("Error");
		}
    	
    	p5.setDate(date_5);
    	
    	p5.setLobby(l2);
    	
    	
//    	Performance p6
    	
    	Performance p6 = new Performance();
    	
    	p6.setPlay(Mama_mia);
    	
    	Date date_6 = new Date();
    	try {
			date_6 = dateFormat.parse("20/07/2017 at 21:00");
		} catch (ParseException e) {
			System.out.println("Error");
		}
    	
    	p6.setDate(date_6);
    	
    	p6.setLobby(l2);
    	
    	
//    	Performance p7
    	
    	Performance p7 = new Performance();
    	
    	p7.setPlay(Ornithes);
    	
    	Date date_7 = new Date();
    	try {
			date_7 = dateFormat.parse("18/06/2017 at 18:00");
		} catch (ParseException e) {
			System.out.println("Error");
		}
    	
    	p7.setDate(date_7);
    	
    	p7.setLobby(l2);
    	
    	
//    	Performance p8
    	
    	Performance p8 = new Performance();
    	
    	p8.setPlay(Ornithes);
    	
    	Date date_8 = new Date();
    	try {
			date_8 = dateFormat.parse("05/06/2017 at 18:00");
		} catch (ParseException e) {
			System.out.println("Error");
		}
    	
    	p8.setDate(date_8);
    	
    	p8.setLobby(l2);
    	
    	
//    	Performance p9
    	
    	Performance p9 = new Performance();
    	
    	p9.setPlay(Arxontoxwriatis);
    	
    	Date date_9 = new Date();
    	try {
			date_9 = dateFormat.parse("11/09/2017 at 21:35");
		} catch (ParseException e) {
			System.out.println("Error");
		}
    	
    	p9.setDate(date_9);
    	
    	p9.setLobby(lux);
    	
    	
//    	Performance p10
    	
    	Performance p10 = new Performance();
    	
    	p10.setPlay(Arxontoxwriatis);
    	
    	Date date_10 = new Date();
    	try {
			date_10 = dateFormat.parse("20/09/2017 at 21:35");
		} catch (ParseException e) {
			System.out.println("Error");
		}
    	
    	p10.setDate(date_10);
    	
    	p10.setLobby(lux);
    	
    	getPerformanceDAO().save(p1);
    	getPerformanceDAO().save(p2);
    	getPerformanceDAO().save(p3);
    	getPerformanceDAO().save(p4);
    	getPerformanceDAO().save(p5);
    	getPerformanceDAO().save(p6);
    	getPerformanceDAO().save(p7);
    	getPerformanceDAO().save(p8);
    	getPerformanceDAO().save(p9);
    	getPerformanceDAO().save(p10);
    	
    	
/*-------------------------------------------------------------------------------------------------------------*/
    	
    	
    	
//    	Client c1
    	
    	Client c1 = new Client ();
    	
    	c1.setMail(new Email("p3130035@dias.aueb.gr"));
    	c1.setName("Giwrgos");
    	c1.setSurname("Mazwnakis");
    	
//    	Client c2
    	
    	Client c2 = new Client ();
    	
    	c2.setMail(new Email("p3130180@dias.aueb.gr"));
    	c2.setName("Argiris");
    	c2.setSurname("Roustemis");
    	
//    	Client c3
    	    	
    	Client c3= new Client ();
    	c3.setMail(new Email("p3130067@dias.aueb.gr"));
    	c3.setName("Xristina");
    	c3.setSurname("Thanou");
    	
    	
    	getClientDAO().save(c1);
    	getClientDAO().save(c2);
    	getClientDAO().save(c3);
        
    	
    	try {
			date = dateFormat.parse("20/05/2017 at 8:00");
		} catch (ParseException e) {
			System.out.println("Error");
		}
    	
//    	Payment 1
    	
    	Payment payment1 = new Payment();
    	payment1.setAmount(p1.getPrice().getAmount());
    	payment1.setDateOfPayment(date);
    	payment1.setWayOfPayment(PaymentType.Card);
    	
//    	Payment 2
    	
    	Payment payment2 = new Payment();
    	payment2.setAmount(p3.getPrice().getAmount());
    	payment2.setDateOfPayment(date);
    	payment2.setWayOfPayment(PaymentType.Card);
    	
//    	Payment 3
    	
    	Payment payment3 = new Payment();
    	payment3.setAmount(p8.getPrice().getAmount());
    	payment3.setDateOfPayment(date);
    	payment3.setWayOfPayment(PaymentType.Card);
    	
//    	Payment 4
    	
    	Payment payment4 = new Payment();
    	payment4.setAmount(0);
    	payment4.setDateOfPayment(date);
    	payment4.setWayOfPayment(PaymentType.Cash);
    	
    	
//    	Reservation r1
    	
    	Reservation r1 = new Reservation();
    	r1.setClient(c1);
    	r1.setCode(1);
    	r1.setPerformance(p1);
    	r1.setPayment(payment1);
    	
//    	Reservation r2
    	
    	Reservation r2 = new Reservation();
    	r2.setClient(c1);
    	r2.setCode(2);
    	r2.setPerformance(p1);
    	r2.setPayment(payment1);
    	
//    	Reservation r3
    	
    	Reservation r3 = new Reservation();
    	r3.setClient(c2);
    	r3.setCode(1);
    	r3.setPerformance(p3);
    	r3.setPayment(payment2);
    	
//    	Reservation r4
    	
    	Reservation r4 = new Reservation();
    	r4.setClient(c3);
    	r4.setCode(5);
    	r4.setPerformance(p8);
    	r4.setPayment(payment3);
    	
    	c1.addReservation(r1);
    	c1.addReservation(r2);
    	
    	c2.addReservation(r3);
    	
    	c3.addReservation(r4);
    	
    }    
    
    
    protected abstract PerformanceDAO getPerformanceDAO();
    protected abstract ClientDAO getClientDAO();
    
    
}
