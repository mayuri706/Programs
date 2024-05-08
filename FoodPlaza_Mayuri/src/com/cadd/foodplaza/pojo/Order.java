package com.cadd.foodplaza.pojo;

public class Order {
private int orderId;
private String customerEmailid,orderDate,foodName;
private double totalBill;
public int getOrderId() {
	return orderId;
}
public void setOrderId(int orderId) {
	this.orderId = orderId;
}
public String getCustomerEmailid() {
	return customerEmailid;
}
public void setCustomerEmailid(String customerEmailid) {
	this.customerEmailid = customerEmailid;
}
public String getOrderDate() {
	return orderDate;
}
public void setOrderDate(String orderDate) {
	this.orderDate = orderDate;
}
public String getFoodName() {
	return foodName;
}
public void setFoodName(String foodName) {
	this.foodName = foodName;
}
public double getTotalBill() {
	return totalBill;
}
public void setTotalBill(double totalBill) {
	this.totalBill = totalBill;
}

}
