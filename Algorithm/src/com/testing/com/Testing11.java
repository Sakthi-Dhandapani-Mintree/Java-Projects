package com.testing.com;

import java.util.Optional;

class Person {
	private String name;
	private Optional<Address> address;
	private int phone;

	public Person(String name, Optional<Address> address, int phone) {
		if (name == null) {
			throw new IllegalArgumentException("Null value for name is not permitted");
		}
		this.name = name;
		this.address = address;
		this.phone = phone;
	}

	public String name() {
		return name;
	}

	public Optional<Address> address() {
		return address;
	}

	public int phone() {
		return phone;
	}

	@Override
	public String toString() {
		return "Person{" + "name=" + name + ", address=" + address + ", phone=" + phone + '}';
	}

}

class Address {

	public static final Address EMPTY_ADDRESS = new Address("", "", "", 0);
	private final String line1;
	private final String city;
	private final String country;
	private final int zipcode;

	public Address(String line1, String city, String country, int zipcode) {
		this.line1 = line1;
		this.city = city;
		this.country = country;
		this.zipcode = zipcode;
	}

	public String line1() {
		return line1;
	}

	public String city() {
		return city;
	}

	public String country() {
		return country;
	}

	public int zipcode() {
		return zipcode;
	}

	@Override
	public String toString() {
		return "Address{" + "line1=" + line1 + ", city=" + city + ", country=" + country + ", zipcode=" + zipcode + '}';
	}

}

public class Testing11 {

	public static void main(String[] args) {
		Optional<Address> adr = Optional.ofNullable(new Address("185A", "Chennai", "IND", 600128));
		Optional<Person> person = Optional.ofNullable(new Person("Sakhti", adr, 999438135));
		Optional<Address> ass = person.get().address();
		
		ass.filter(ad -> "Chennai".equals(ad.city())).ifPresent(a -> System.out.println("Live in Chennai"+a));
	}

}
