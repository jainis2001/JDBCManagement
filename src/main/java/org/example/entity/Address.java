package org.example.entity;

public class Address {
	private String addressId;
	private int pincode;
	private String landmark,city,state;

	public Address(String addressId, String landmark,  String city, String state,int pincode) {
		this.addressId = addressId;
		this.pincode = pincode;
		this.landmark = landmark;
		this.city = city;
		this.state = state;
	}

	public Address() {

	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
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

	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}


	@Override
	public String toString() {
		return "Address{" +
				"addressId='" + addressId + '\'' +
				", landmark='" + landmark + '\'' +
				", pincode=" + pincode +
				", city='" + city + '\'' +
				", state='" + state + '\'' +
				'}';
	}
}

