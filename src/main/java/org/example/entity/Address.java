package org.example.entity;

import jakarta.persistence.*;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "address")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "address_id")
	private String id;
	@Column(name = "landmark")
	private String landmark;
	@Column(name = "city")
	private String city;
	@Column(name = "state")
	private String state;
	@Column(name = "pincode")
	private int pincode;

	public Address() {
	}

	public Address(String id, String landmark, String city, String state, int pincode) {
		this.id = id;
		this.landmark = landmark;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
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

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "Address{" +
				"id='" + id + '\'' +
				", landmark='" + landmark + '\'' +
				", city='" + city + '\'' +
				", state='" + state + '\'' +
				", pincode=" + pincode +
				'}';
	}
}

