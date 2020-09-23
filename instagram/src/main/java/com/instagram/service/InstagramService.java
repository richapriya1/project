package com.instagram.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.instagram.dao.InstagramDAO;
import com.instagram.dao.InstagramDAOInterface;
import com.instagram.entity.InstagramUser;
import com.instagram.utility.DAOFactory;
import com.instagram.utility.InstagramException;

public class InstagramService implements InstagramServiceInterface {
	
	private InstagramDAOInterface id;
	
	public InstagramService() {
		
		//id=new InstagramDAO();
		// using factory method
		
		id=DAOFactory.createObject("admindao");
	}

	@Override
	public int createProfileService(InstagramUser iu) throws IOException{
		
		int i=id.createProfileDAO(iu);
		return i;
	}

	@Override
	public void editProfileService(){
		id.editProfileDAO();
		//int p=id.editProfileDAO(iu);
		//return p;
	}

	@Override
	public int deleteProfileService(InstagramUser iu){
		int p=id.deleteProfileDAO(iu);
		return p;
	}

	@Override
	public InstagramUser viewProfileService(InstagramUser iu){
		InstagramUser uu=id.viewProfileDAO(iu);
		return uu;

	}

	@Override
	public List<InstagramUser> searchProfileService(InstagramUser iu) throws InstagramException{
		return id.searchProfileDAO(iu);
	}
	
	@Override
	public List<InstagramUser> viewallProfileService(){
		return id.viewallProfileDAO();
	}

	public int editprofilebyname(InstagramUser iu){
		return id.editprofilebynamedao(iu);
	}

	@Override
	public Map<String, List<InstagramUser>> userDetailWithHistoryService(){
		return id.userDetailWithHistoryDAO();
	}
}
