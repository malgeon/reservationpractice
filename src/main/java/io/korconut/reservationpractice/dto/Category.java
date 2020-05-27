package io.korconut.reservationpractice.dto;

public class Category {
	private int count;
	private int id;
	private String Name;
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
	@Override
	public String toString() {
		return "Category [count=" + count + ", id=" + id + ", Name=" + Name + "]";
	}
}
