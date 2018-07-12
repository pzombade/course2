package com.firebase.webhooks.dominospizza;

public class Users{
	
	private String first;
	private String last;
	
	public Users(String f, String l) {
		this.first = f;
		this.last = l;
	}
	
	public Users() {}
	
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public String getLast() {
		return last;
	}
	public void setLast(String last) {
		this.last = last;
	}
	
	@Override
	public String toString() {
		return "first="+first+" ,last="+last;
	}
}