package com.instagram.dao;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.instagram.entity.InstagramUser;
import com.instagram.utility.InstagramException;

public interface InstagramDAOInterface {

	int createProfileDAO(InstagramUser iu) throws IOException;

	public void editProfileDAO();

	int deleteProfileDAO(InstagramUser iu);

	InstagramUser viewProfileDAO(InstagramUser iu);

	public List<InstagramUser> searchProfileDAO(InstagramUser iu) throws InstagramException;
	
	public List<InstagramUser> viewallProfileDAO();
	
	int editprofilebynamedao(InstagramUser iu);

	Map<String, List<InstagramUser>> userDetailWithHistoryDAO();

}
