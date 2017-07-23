package domain;

public class Seat {
	private int code;
	private boolean available;
	private Lobby lobby;
	public Seat(int code,boolean available){
		this.setCode(code);
		this.setAvailable(available);
				
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	public Lobby getLobby(){
		return lobby;
	}
	
	public void setLobby(Lobby lobby){
		this.lobby = lobby;
	}
	
	
	
}


