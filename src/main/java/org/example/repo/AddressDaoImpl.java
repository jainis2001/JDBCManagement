package org.example.repo;


import org.example.entity.Address;
import org.example.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AddressDaoImpl implements AddressDao{

	@Override
	public String findByAddress(Address address) {
		String addressId=null;

		try(Connection con= DBConnection.getConnection()){
			PreparedStatement pstmt=con.prepareStatement(Queries.findByAddress);
			pstmt.setString(1,address.getLandmark());
			pstmt.setInt(2,address.getPincode());
			ResultSet result=pstmt.executeQuery();
			if(result.next()){
				addressId=result.getString(1);
			}
		}catch (Exception e){
		System.out.println(e.getMessage());
		e.printStackTrace();
		}
		return addressId;
	}

	@Override
	public boolean insertAddress(Address address) {
		boolean isInserted=false;

		try(Connection con= DBConnection.getConnection()){
			PreparedStatement pStmtAddress=con.prepareStatement(Queries.insertAddress);
			pStmtAddress.setString(1, address.getAddressId());
			pStmtAddress.setString(2, address.getLandmark());
			pStmtAddress.setString(3, address.getCity());
			pStmtAddress.setString(4, address.getState());
			pStmtAddress.setInt(5, address.getPincode());
			pStmtAddress.executeUpdate();
			isInserted=true;
		}
		catch(Exception e){
			System.out.println(e.getMessage());

		}
		return isInserted;

	}



	@Override
	public Address getByAddressId(String addressId) {
		Address address=null;
		try(Connection con= DBConnection.getConnection()) {
			PreparedStatement pstmt=con.prepareStatement(Queries.getByAddressId);
			pstmt.setString(1,addressId);
			ResultSet result=pstmt.executeQuery();
			if(result.next()){
				address=new Address(result.getString(1),result.getString(2),result.getString(3),result.getString(4),result.getInt(5));
			}

		}catch (Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return address;
	}

	@Override
	public List<Address> getAllAddressRecords() {
		List<Address> addressList=new ArrayList<>();
		try(Connection con= DBConnection.getConnection()) {
			Statement stmt=con.createStatement();
			ResultSet result=stmt.executeQuery(Queries.getAddresses);
			while(result.next()){
				Address address=new Address(result.getString(1),result.getString(2),result.getString(3),result.getString(4),result.getInt(5));
				addressList.add(address);
			}

		}catch (Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return addressList;
	}


}
