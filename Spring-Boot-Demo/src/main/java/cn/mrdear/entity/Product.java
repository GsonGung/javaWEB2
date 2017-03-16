package cn.mrdear.entity;

import java.io.Serializable;

public class Product  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 703975773688420879L;

	private int id;
	
	private String name;
	
	private float price;
	
	private boolean inStock;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public boolean isInStock() {
		return inStock;
	}

	public void setInStock(boolean inStock) {
		this.inStock = inStock;
	}
	
	

}
