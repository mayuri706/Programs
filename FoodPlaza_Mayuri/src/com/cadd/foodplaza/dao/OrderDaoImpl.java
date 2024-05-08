package com.cadd.foodplaza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cadd.foodplaza.pojo.Food;
import com.cadd.foodplaza.pojo.Order;
import com.cadd.foodplaza.utility.DBUtility;

public class OrderDaoImpl  implements OrderDao
{
	Connection conn;
	PreparedStatement ps;
	String query;
	Order or=new Order();
	
	@Override
	public boolean placeOrder(String customerEmailid) {
		double totalBill=0;
		String orderDate=new Date().toString();
		
		try {
			Connection con;
			try {
				conn = DBUtility.establishConnection();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String foodNameQuery = "SELECT foodName FROM Cart WHERE customerEmailId = ?";

			//calculate totalBill
			  String queryTotalBill = "SELECT SUM(f.foodPrice * c.foodQty) AS totalBill " +
		                "FROM Food AS f INNER JOIN Cart AS c ON f.foodId = c.foodId " +
		                "WHERE customerEmailId = ?";

			ps=conn.prepareStatement(foodNameQuery);
			ps.setString(1, customerEmailid);
			ResultSet rs=ps.executeQuery();
			if (rs.next())
			{
				String foodName=rs.getString(1);
				
				try(PreparedStatement psTotalBill=conn.prepareStatement(queryTotalBill))
				{
					psTotalBill.setString(1, customerEmailid);
					try (ResultSet rsTotalBill=psTotalBill.executeQuery())
					{
						if(rsTotalBill.next())
						{
							totalBill=rsTotalBill.getDouble("totalBill");
						}
					}
						
					
				}
				//insert order
				  String queryInsertOrder = "INSERT INTO Orders(totalBill, customerEmailId, orderDate,foodName) VALUES (?,?, ?, ?)";

				try(PreparedStatement psInsertOrder=conn.prepareStatement(queryInsertOrder))
				{
					psInsertOrder.setDouble(1, totalBill);
					psInsertOrder.setString(2, customerEmailid);
					psInsertOrder.setString(3, orderDate);
					psInsertOrder.setString(4, foodName);
					
					int row=psInsertOrder.executeUpdate();
					return row>0;
				}
				catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
			return false;
		}catch(SQLException e1)
		{
			e1.printStackTrace();
		}
		return false;
		
		
	}
	@Override
	public List<Order> showOrders() {
		query="select * from orders ";
		ArrayList<Order>af=new ArrayList<Order>();
		try {
			conn=DBUtility.establishConnection();
			ps=conn.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				Order or=new Order();
				or.setOrderId(rs.getInt(1));
				or.setCustomerEmailid(rs.getString(2));
				or.setOrderDate(rs.getString(3));
				or.setFoodName(rs.getString(4));
				or.setTotalBill(rs.getDouble(5));
				
				af.add(or);
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return af;
	}

}
