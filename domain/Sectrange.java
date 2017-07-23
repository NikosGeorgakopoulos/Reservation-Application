package domain;

public class Sectrange {

	private Seat From;
		
	private Seat To; 
	
	private int size;
	
	public Sectrange(Seat From,Seat To, int size){
		this.setFrom(From);
		this.setTo(To);
		this.setSize(size);
	}

	public Seat getFrom() {
		return From;
	}

	public void setFrom(Seat from) {
		From = from;
	}

	public Seat getTo() {
		return To;
	}

	public void setTo(Seat to) {
		To = to;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	
}
