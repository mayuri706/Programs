package com.cadd.foodplaza.pojo;

public class Cart
{
	private String customerEmailid,foodName;
	private int foodId,cartId,foodQty;
	private double foodPrice;
	
	public String getCustomerEmailid() {
		return customerEmailid;
	}
	public void setCustomerEmailid(String customerEmailid) {
		this.customerEmailid = customerEmailid;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public int getFoodId() {
		return foodId;
	}
	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getFoodQty() {
		return foodQty;
	}
	public void setFoodQty(int foodQty) {
		this.foodQty = foodQty;
	}
	public double getFoodPrice() {
		return foodPrice;
	}
	public void setFoodPrice(double foodPrice) {
		this.foodPrice = foodPrice;
	}

	
}
//foodId=,customerEmailid,foodquantity,foodprice,cartId,foodName