package com.instagram.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.instagram.entity.InstagramUser;
import com.instagram.utility.InstagramException;

public class InstagramDAO implements InstagramDAOInterface{

	@Override
	public int createProfileDAO(InstagramUser iu) throws IOException{
		/* inserting data in database
		 
		int i=0;
		Connection con=null;
		try {
		//step 1 load driver
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		
		//Class.forName("oracle.jdbc.driver.OracleDriver");
		//Class.forName("com.mysql.jdbc.Driver");
		
		//step 2 create connection with database
		con=DriverManager.getConnection("jdbc:derby:c:/firstdb1;create=true","richa","priya");
		
		
		//step 3 create query
		PreparedStatement ps=con.prepareStatement("insert into INSTATABLE values(?,?,?,?)");
		ps.setString(1, iu.getName());
		ps.setString(2, iu.getPassword());
		ps.setString(3, iu.getEmail());
		ps.setString(4, iu.getAddress());
		
		//step 4 executeQuery
		i=ps.executeUpdate();
		}
		
		catch(ClassNotFoundException|SQLException e1) {
			e1.printStackTrace();
		}
		
		finally {
			try {
				con.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		*/
		
		// inserting data into file
		/*
		int i=1,j;
		File f=new File("c:/hsbc_file/dao1.txt");
		FileOutputStream out=new FileOutputStream(f,true);
		String name=iu.getName();
		for(j=0;j<name.length();j++)
		{
			out.write(name.charAt(j));
		}
		out.write(32);
		String password=iu.getPassword();
		for(j=0;j<password.length();j++)
		{
			out.write(password.charAt(j));
		}
		out.write(32);
		String email=iu.getEmail();
		for(j=0;j<email.length();j++)
		{
			out.write(email.charAt(j));
		}
		out.write(32);
		String address=iu.getAddress();
		for(j=0;j<address.length();j++)
		{
			out.write(address.charAt(j));
		}
		out.write(32);
		out.close();
		return i;
		*/
		
		
		
		//using writeObject 
		int i=0;
		File f=new File("c:/hsbc_file/readwrite.txt");
		FileOutputStream out=new FileOutputStream(f);
		ObjectOutputStream oo=new ObjectOutputStream(out);
		InstagramUser u=new InstagramUser();
		u.setName(iu.getName());
		u.setPassword(iu.getPassword());
		u.setEmail(iu.getEmail());
		u.setAddress(iu.getAddress());
		oo.writeObject(u);
		i=1;
		oo.close();
		out.close();
		System.out.println("Writing Complete");
		return i;
	}

	@Override
	public void editProfileDAO(){
		
		

	}

	@Override
	public int deleteProfileDAO(InstagramUser iu) {
		
		int res=0;
		Connection con=null;
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			con=DriverManager.getConnection("jdbc:derby:c:/firstdb1;create=true","richa","priya");
			PreparedStatement ps=con.prepareStatement("delete from INSTATABLE where email=?");
			ps.setString(1, iu.getEmail());
			
			res=ps.executeUpdate();
		
		}
		catch(ClassNotFoundException|SQLException e1) {
			e1.printStackTrace();
		}
		
		finally {
			try {
				con.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return res;
	}

	

	@Override
	public List<InstagramUser> searchProfileDAO(InstagramUser iu) throws InstagramException{
		
		List<InstagramUser> ll=new ArrayList<InstagramUser>();
		Connection con=null;
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			con=DriverManager.getConnection("jdbc:derby:c:/firstdb1;create=true","richa","priya");
			PreparedStatement ps=con.prepareStatement("select * from INSTATABLE where name=?");
			ps.setString(1, iu.getName());
			
			ResultSet res=ps.executeQuery();
			
			
			
			while(res.next()) {
				InstagramUser uu=new InstagramUser();
				uu.setName(res.getString(1));
				uu.setPassword(res.getString(2));
				uu.setEmail(res.getString(3));
				uu.setAddress(res.getString(4));
				
				ll.add(uu);
			}
		
		
		if(ll.size()==0) {
			throw new InstagramException("");
		}
		}
		catch(ClassNotFoundException|SQLException e1) {
			e1.printStackTrace();
		}
		/* finally {
			try {
			con.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		}	*/
		return ll;

	}

	@Override
	public InstagramUser viewProfileDAO(InstagramUser iu){
		// TODO Auto-generated method stub
		
		//using database
		/*
		InstagramUser uu=null;
		Connection con=null;
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			con=DriverManager.getConnection("jdbc:derby:c:/firstdb1;create=true","richa","priya");
			PreparedStatement ps=con.prepareStatement("select * from INSTATABLE where name=?");
			ps.setString(1, iu.getName());
			
			ResultSet res=ps.executeQuery();
			//how to verify resultset is having result or not
			//via next() method, if next() method will return true then resultset have some result otherwise no result
			
			
			
			if(res.next()) {
				uu=new InstagramUser();
				uu.setName(res.getString(1));
				uu.setPassword(res.getString(2));
				uu.setEmail(res.getString(3));
				uu.setAddress(res.getString(4));
			}
		}
		catch(ClassNotFoundException|SQLException e1) {
			e1.printStackTrace();
		}
		finally {
			try {
			con.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		}
		*/
		
		//using readObject
		//InstagramUser uu=null;
		try {
		File f=new File("c:/hsbc_file/readwrite.txt");
		FileInputStream out=new FileInputStream(f);
		ObjectInputStream oo=new ObjectInputStream(out);
		
		InstagramUser u=(InstagramUser)oo.readObject();
		System.out.println(u.getName()+" "+u.getPassword()+" "+u.getEmail()+" "+u.getAddress());
		//uu=iu;
		oo.close();
		out.close();
		System.out.println("reading Complete");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		InstagramUser uu=null;
		return uu;
	}

	@Override
	public List<InstagramUser> viewallProfileDAO(){
	
		List<InstagramUser> ll=new ArrayList<InstagramUser>();
		Connection con=null;
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			con=DriverManager.getConnection("jdbc:derby:c:/firstdb1;create=true","richa","priya");
			PreparedStatement ps=con.prepareStatement("select * from INSTATABLE");
					
			ResultSet res=ps.executeQuery();
			
			
			
			while(res.next()) {
				InstagramUser uu=new InstagramUser();
				uu.setName(res.getString(1));
				uu.setPassword(res.getString(2));
				uu.setEmail(res.getString(3));
				uu.setAddress(res.getString(4));
				
				ll.add(uu);
			}
		}
		
		catch(ClassNotFoundException|SQLException e1) {
			e1.printStackTrace();
		}
		finally {
			try {
			con.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		}

		return ll;
		
	}

	public int editprofilebynamedao(InstagramUser iu){
		Connection con=null;
		PreparedStatement ps=null;
		int i=0;
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			con=DriverManager.getConnection("jdbc:derby:c:/firstdb1;create=true","richa","priya");
			ps=con.prepareStatement("update INSTATABLE set password=? where name=?");
			ps.setString(1, iu.getPassword());
			ps.setString(2, iu.getName());
			i=ps.executeUpdate();
		}
		catch(ClassNotFoundException|SQLException e1) {
			e1.printStackTrace();
		}
		finally {
			try {
			con.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		}
		return i;
	}
	
	public Map<String, List<InstagramUser>> userDetailWithHistoryDAO(){
		Map<String, List<InstagramUser>> m=new HashMap<String, List<InstagramUser>>();
		
		List<InstagramUser> l1=viewallProfileDAO();
		List<InstagramUser> l2=viewallProfileDAO();
		
		m.put("studentlist", l1);
		m.put("proflist", l2);
		
		return m;
	}
}
