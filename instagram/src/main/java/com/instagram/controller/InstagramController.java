package com.instagram.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.instagram.entity.InstagramUser;
import com.instagram.service.InstagramService;
import com.instagram.service.InstagramServiceInterface;
import com.instagram.utility.InstagramException;
import com.instagram.utility.ServiceFactory;
import com.instagram.utility.SortBy_Address;
import com.instagram.utility.SortBy_Email;
import com.instagram.utility.SortBy_Name;

public class InstagramController implements InstagramControllerInterface {
	
	private InstagramServiceInterface is;
	
	public InstagramController() {
		
	//	is= new InstagramService();
		
	//	using factory method
		is=ServiceFactory.createObject("adminservice");
	}

	@Override
	public void createProfile() throws IOException{
		
		
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter your name ");
			String name = null;
			try {
				name = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("Enter your password ");
			String password = null;
			try {
				password = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("Enter your email ");
			String email = null;
			try {
				email = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("Enter your address ");
			String address = null;
			try {
				address = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			InstagramUser iu=new InstagramUser();
			iu.setName(name);
			iu.setPassword(password);
			iu.setEmail(email);
			iu.setAddress(address);
			
			
			int i=is.createProfileService(iu);//we should not transfer concrete data
			
			if(i>0) {
				System.out.println("profile created");
			}
			else {
				System.out.println("could not create profile");
			}
		}
		
	

	@Override
	public void editProfile(){
		
		try {
			viewProfile();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		//System.out.println("press 1 to edit name");
		System.out.println("press 1 to edit password");
		System.out.println("press 2 to edit email");
		System.out.println("press 3 to edit address");
		
		System.out.println("enter your choice ");
		int i = 0;
		try {
			i = Integer.parseInt(br.readLine());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//InstagramControllerInterface fi=new InstagramController();
		String name="Richa";
		
		switch(i) {
		
		case 1: try {
				editProfilebypassword(name);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 2:editProfilebyemail();
			break;
		case 3:editProfilebyaddress();
			break;
		
		
		default:System.out.println("wrong choice");
		
		}
		is.editProfileService();

	}

	private void editProfilebyaddress() {
		// TODO Auto-generated method stub
		
	}

	private void editProfilebyemail() {
		// TODO Auto-generated method stub
		
	}

	

	private void editProfilebypassword(String name){
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter new password : ");
		String password = null;
		try {
			password = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		InstagramUser iu=new InstagramUser(); //this object is used for transfering data from controller to service
		iu.setName(name);
		iu.setPassword(password);
		
		int i=is.editprofilebyname(iu);
		if(i>0) {
			System.out.println("profile edited");
		}
		

	}

	@Override
	public void deleteProfile(){
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter email to delete Profile");
		String email = null;
		try {
			email = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		InstagramUser iu=new InstagramUser();
		iu.setEmail(email);
		
		int x=is.deleteProfileService(iu);
		if(x>0) {
			System.out.println("Profile deleted");
		}
		else {
			System.out.println("No record found");
		}
	}

	@Override
	public void viewProfile(){
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter name to view Profile");
		String name = null;
		try {
			name = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		InstagramUser iu=new InstagramUser();
		iu.setName(name);
		
		InstagramUser uu=is.viewProfileService(iu);
		if(uu!=null) {
			System.out.println("User info is below");
			System.out.println("Name is "+uu.getName());
			System.out.println("Password is "+uu.getPassword());
			System.out.println("Email is "+uu.getEmail());
			System.out.println("Address is "+uu.getAddress());
		}
		else
		{
			System.out.println("User with name "+name+" does not exist");
		}
	}

	@Override
	public void searchProfile(){
		try {
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter Name to search profile : ");
			String name=null;;
			
				name = br.readLine();
				
				if(name.length()<3) {
				throw new InstagramException(name);
				}
			
			
			InstagramUser iu=new InstagramUser(); //this object is used for transfering data from controller to service
			iu.setName(name);
			
			List<InstagramUser> uu=is.searchProfileService(iu);
			
			System.out.println(uu.size()+"  users found");
			
			for(InstagramUser u:uu) {
				System.out.println("****************************************");
				System.out.println("Name is : "+u.getName());
				System.out.println("Password is : "+u.getPassword());
				System.out.println("Email is : "+u.getEmail());
				System.out.println("Address is : "+u.getAddress());
				System.out.println("****************************************");
			}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("custom exception occured "+e);
			}
			catch (InstagramException e) {
				// TODO Auto-generated catch block
				System.out.println("custom exception occured "+e.uu());
			}	


	}

	@Override
	public void viewAllProfile(){
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		List<InstagramUser> uu=is.viewallProfileService();
		System.out.println(uu.size()+"  users found");
		
		System.out.println("press 1 to sort by email");
		System.out.println("press 2 to sort by name");
		System.out.println("press 3 to sort by address");
		int i=0;
		System.out.println("Enter your choice");
		try {
			i=Integer.parseInt(br.readLine());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		switch(i) {
		case 1:
			Collections.sort(uu, new SortBy_Email());
			break;
		case 2: 
			Collections.sort(uu, new SortBy_Name());
			break;
		case 3:
			Collections.sort(uu, new SortBy_Address());
			break;
		default:
			System.out.println("without sorting the result is");
		}
				
		for(InstagramUser u:uu) {
			System.out.println("****************************************");
			System.out.println("Name is : "+u.getName());
			System.out.println("Password is : "+u.getPassword());
			System.out.println("Email is : "+u.getEmail());
			System.out.println("Address is : "+u.getAddress());
			System.out.println("****************************************");
		}

	}
	
	@Override
	
	public void userDetailWithHistory() {
		Map<String, List<InstagramUser>> uu=is.userDetailWithHistoryService();
		
		List<InstagramUser>  ll=uu.get("studentlist");
		
		for(InstagramUser u:ll) {
			System.out.println("****************************************");
			System.out.println("Name is : "+u.getName());
			System.out.println("Password is : "+u.getPassword());
			System.out.println("Email is : "+u.getEmail());
			System.out.println("Address is : "+u.getAddress());
			System.out.println("****************************************");
		}
		
		
      List<InstagramUser>  ll1=uu.get("proflist");
		
		for(InstagramUser u:ll) {
			System.out.println("****************************************");
			System.out.println("Name is : "+u.getName());
			System.out.println("Password is : "+u.getPassword());
			System.out.println("Email is : "+u.getEmail());
			System.out.println("Address is : "+u.getAddress());
			System.out.println("****************************************");
		}

	}

}
