package br.com.vigjoaopaulo.application.model;

public class Cliente {

	private int customer_id;
	private String name;
	private String last_name;
	private String phone_number;
	private boolean is_whatsapp;
	
	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public Cliente(int customer_id, String name, String last_name, String phone_number, boolean is_whatsapp) {
		super();
		this.customer_id = customer_id;
		this.name = name;
		this.last_name = last_name;
		this.phone_number = phone_number;
		this.is_whatsapp = is_whatsapp;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public boolean isIs_whatsapp() {
		return is_whatsapp;
	}

	public void setIs_whatsapp(boolean is_whatsapp) {
		this.is_whatsapp = is_whatsapp;
	}

	@Override
	public String toString() {
		return "customer_id=" + customer_id +
				"\nname=" + name + 
				"\nlast_name=" + last_name + 
				"\nphone_number="
				+ phone_number +
				"\nis_whatsapp=" + is_whatsapp;
	}
}
