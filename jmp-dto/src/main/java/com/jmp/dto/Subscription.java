package com.jmp.dto;

import java.time.LocalDate;

public class Subscription {
	String bankcardNumber;
	LocalDate startDate;
	
	public String getBankcardNumber() {
		return bankcardNumber;
	}
	public void setBankcardNumber(String bankcardNumber) {
		this.bankcardNumber = bankcardNumber;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	
	@Override
	public String toString() {
		return "Subscription [bankcardNumber=" + bankcardNumber + ", startDate=" + startDate + "]";
	}
	public Subscription(String bankcardNumber, LocalDate startDate) {
		super();
		this.bankcardNumber = bankcardNumber;
		this.startDate = startDate;
	}
	public Subscription() {
		super();
		
	}
	
}
