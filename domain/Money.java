package domain;

public class Money {
	
	public String currency;
	public double amount;
	
	
	
	public String getCurrency(){
		return currency;
	}
	
	public void setCurrency(String currency){
		this.currency = currency;
	}
	
	public double getAmount(){
		return amount;
		
	}
	
	public void setAmount(double amount){
		this.amount = amount;
	}
}
