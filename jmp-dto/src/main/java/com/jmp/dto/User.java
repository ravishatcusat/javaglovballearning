package com.jmp.dto;

import java.time.LocalDate;

public class User {
	String name;
	String surname;
	LocalDate birthday;
	
	
	public User(String name, String surname, LocalDate birthday) {
		super();
		this.name = name;
		this.surname = surname;
		this.birthday = birthday;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public LocalDate getBirthday() {
		return birthday;
	}
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	
	@Override
	public String toString() {
		return "User [name=" + name + ", surname=" + surname + ", birthday=" + birthday + "]";
	}
}
