package com.cadd.foodplaza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cadd.foodplaza.pojo.Customer;
import com.cadd.foodplaza.pojo.Food;
import com.cadd.foodplaza.utility.DBUtility;

public class CustomerDaoImpl implements CustomerDao{
	Connection conn;
	PreparedStatement ps;
	String query;
	Customer c=new Customer();

	@Override
	public boolean addCustomer(Customer c) {
		query="insert into Customer(customerName,customerAddress,customerContact,customerEmailid,customerPassword)values(?,?,?,?,?)";
		 try {
			 conn=DBUtility.establishConnection();
			ps=conn.prepareStatement(query);
			ps.setString(1, c.getCustomerName());
			ps.setString(2, c.getCustomerAddress());
			ps.setLong(3, c.getCustomerContact());
			ps.setString(4, c.getCustomerEmailid());
			ps.setString(5, c.getCustomerPassword());
			int success=ps.executeUpdate();
			
			if(success>0)
			{
				return true;
			}
			else
			{
				return false;
			}
			
		} catch (SQLException | ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		return true;
	}
		

	@Override
	public boolean updateCustomer(Customer c) {
		
	query="update Customer set customerName=?,customerAddress=?,customerContact=?,customerEmailid=?,customerPassword=? where customerId=?";
		try {
			conn=DBUtility.establishConnection();
			ps=conn.prepareStatement(query);
			ps.setString(1, c.getCustomerName());
			ps.setString(2, c.getCustomerAddress());
			ps.setLong(3, c.getCustomerContact());
			ps.setString(4, c.getCustomerEmailid());
			ps.setString(5, c.getCustomerPassword());
			ps.setInt(6, c.getCustomerId());
			int success=ps.executeUpdate();
			
			if(success>0)
			{
				return true;
			}
			else
			{
				return false;
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
				return false;
	}

	@Override
	public boolean deleteCustomer(int id) {
		query="delete from Customer where customerId=?";
		try {
			conn=DBUtility.establishConnection();
			ps=conn.prepareStatement(query);
//			
			ps.setInt(1, id);
			int success=ps.executeUpdate();
			if(success>0)
			{
				return true;
			}
			else
			{
				return false;
			}
		
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
				return false;
	}

	@Override
	public Customer displayCustomerById(int id) {
		query="select * from Customer where customerId=?";
		try {
			conn=DBUtility.establishConnection();
			
			ps=conn.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				c.setCustomerName(rs.getString(2));
				c.setCustomerAddress(rs.getString(3));
				c.setCustomerContact(rs.getLong(4));
				c.setCustomerEmailid(rs.getString(5));
				c.setCustomerPassword(rs.getString(6));
			}
		}catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}
		
		return c;
	}

	

	@Override
	public ArrayList<Customer> displayAllCustomer() {
		query="select * from Customer ";
		ArrayList<Customer>af=new ArrayList<Customer>();
		try {
			conn=DBUtility.establishConnection();
			ps=conn.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Customer c=new Customer();
				c.setCustomerId(rs.getInt(1));
				c.setCustomerName(rs.getString(2));
				c.setCustomerAddress(rs.getString(3));
				c.setCustomerContact(rs.getLong(4));
				c.setCustomerEmailid(rs.getString(5));
				c.setCustomerPassword(rs.getString(6));
				
				af.add(c);
			}
			
		} catch (ClassNotFoundException |SQLException e) {
			
			e.printStackTrace();
		}
		
		return af;
	}
	
}