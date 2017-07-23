package domain;


public class Play {
	
	
	
		
	private String title;
	private String[] actors;
	private String[] directors;
	private PerformanceType type;
	private Money price;
	

	public Play(String title,String[] actors,String[] directors,PerformanceType type,Money price){
		this.setTitle(title);
		this.setActors(actors);
		this.setDirectors(directors);
		this.setType(type);
		this.setPrice(price);
		
	}

	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String[] getActors() {
		return actors;
	}

	public void setActors(String[] actors) {
		this.actors = actors;
	}

	public String[] getDirectors() {
		return directors;
	}

	public void setDirectors(String[] directors) {
		this.directors = directors;
	}

	public PerformanceType getType() {
		return type;
	}

	public void setType(PerformanceType type) {
		this.type = type;
	}

	public Money getPrice() {
		return price;
	}

	public void setPrice(Money price) {
		this.price = price;
	}

	

	
	
	

	
	

}



