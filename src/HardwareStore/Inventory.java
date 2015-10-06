package HardwareStore;

import java.io.Serializable;

import javax.management.InvalidAttributeValueException;

import Exceptions.InvalidIdException;
import Exceptions.InvalidNameException;

public class Inventory implements Serializable{
	private int id;
	private String name;
	private int availability;
	private double price;

	public Inventory() {
		super();
	}

	public Inventory(int id, String name) {
		super();
		setId(id);
		setName(name);
		setAvailability(0);
		setPrice(0);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		if (id<0) {
			try {
				throw new InvalidIdException();
			} catch (InvalidIdException e) {
				// TODO Auto-generated catch block
				e.getMessage();
			}
		}
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name.isEmpty()|| name== null) {
			try {
				throw new InvalidNameException();
			} catch (InvalidNameException e) {
				// TODO Auto-generated catch block
				e.getMessage();
			}
		}
		this.name = name;
	}

	public int getAvailability() {
		return availability;
	}

	public void setAvailability(int availability) {
		if (availability <0) {
			try {
				throw new InvalidAttributeValueException("Value must be bigger than zero");
			} catch (InvalidAttributeValueException e) {
				// TODO Auto-generated catch block
				e.getMessage();
			}
		}
		this.availability = availability;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		if (price <0) {
			try {
				throw new InvalidAttributeValueException("Price must be bigger than zero");
			} catch (InvalidAttributeValueException e) {
				// TODO Auto-generated catch block
				e.getMessage();
			}
		}
		this.price = price;
	}

}
