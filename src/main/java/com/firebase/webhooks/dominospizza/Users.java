package com.firebase.webhooks.dominospizza;

public class Users{
	
	private String first;
	private String last;
	private String id;
	
	public Users(String f, String l) {
		this.first = f;
		this.last = l;
	}
	
	public Users() {}
	
	public Users(String id, String first, String last) {
		this.id = id;
		this.first = first;
		this.last = last;
	}

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
		return "id="+id+" ,first="+first+" ,last="+last;
	}

	public String getId() {
		return id;
	}
	
	public String setId(String i) {
		return id=i;
	}
}