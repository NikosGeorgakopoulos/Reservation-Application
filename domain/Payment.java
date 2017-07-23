package domain;

import java.util.Date;



public class Payment {

	
	
	private PaymentType WayofPayment;
	private double amount;
	private Date DateOfPayment;
	
	

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getDateOfPayment() {
		return DateOfPayment;
	}

	public void setDateOfPayment(Date dateOfPayment) {
		DateOfPayment = dateOfPayment;
	}
	
	public PaymentType getWayOfPayment(){
		return WayofPayment;
	}
	
	public void setWayOfPayment(PaymentType type){
		this.WayofPayment = type;
	}
}
