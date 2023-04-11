package org.example.dto;


import org.springframework.stereotype.Component;

@Component
public class AddressDTO {
	private String id;
	private String landmark;
	private String city;
	private String state;
	private int pinCode;

	public AddressDTO() {
	}

	public AddressDTO(String landmark, String city, String state, int pinCode) {
		this.landmark = landmark;
		this.city = city;
		this.state = state;
		this.pinCode = pinCode;
	}

	public AddressDTO(String id, String landmark, String city, String state, int pinCode) {
		this.id = id;
		this.landmark = landmark;
		this.city = city;
		this.state = state;
		this.pinCode = pinCode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}
}
