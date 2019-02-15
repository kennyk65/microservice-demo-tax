package com.example;

import java.math.BigDecimal;


public class Item {

	private String code;
	private BigDecimal price;
	private Long quantity;
	private BigDecimal tax;
	

	public Item() {
		super();
	}

	
	public Item(String code, Long price, Long quantity) {
		this(code,new BigDecimal(price),quantity);
	}

	public Item(String code, Integer price, Long quantity) {
		this(code,new Long(price),quantity);
	}

	public Item(String code, BigDecimal price, Long quantity) {
		this();
		this.code = code;
		this.price = price;
		this.quantity = quantity;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public BigDecimal getPrice() {
		return price;
	}


	public void setPrice(BigDecimal price) {
		this.price = price;
	}


	public Long getQuantity() {
		return quantity;
	}


	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}


	public BigDecimal getTax() {
		return tax;
	}


	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}



	
}
