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
			PreparedStatement pstmt=con.prepareStatement("select addressid from address where landmark=? and pincode=?");
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
			PreparedStatement pStmtAddress=con.prepareStatement("insert into address(addressid,landmark,city,state,pincode) values(?,?,?,?,?)");
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
	public boolean updateAddress(Address address) {
		boolean hasUpdated=false;
		try(Connection con= DBConnection.getConnection()) {
			String query="update address set landmark=?,pincode=?,city=?,state=? where addressid=?";
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setString(1,address.getLandmark());
			pstmt.setInt(2,address.getPincode());
			pstmt.setString(3,address.getCity());
			pstmt.setString(4,address.getState());
			pstmt.setString(5,address.getAddressId());
			int result=pstmt.executeUpdate();
			if(result==1){
				hasUpdated=true;
			}

		}catch (Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return hasUpdated;
	}

	@Override
	public Address getByAddressId(String addressId) {
		Address address=null;
		try(Connection con= DBConnection.getConnection()) {
			String query="select addressid,landmark,city,state,pincode from address where addressid=?";
			PreparedStatement pstmt=con.prepareStatement(query);
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
			String query="select addressid,landmark,city,state,pincode from address";
			Statement stmt=con.createStatement();
			ResultSet result=stmt.executeQuery(query);
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
