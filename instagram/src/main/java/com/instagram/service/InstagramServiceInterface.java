package com.instagram.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.instagram.entity.InstagramUser;
import com.instagram.utility.InstagramException;

public interface InstagramServiceInterface {

	int createProfileService(InstagramUser iu) throws IOException;

	void editProfileService();

	int deleteProfileService(InstagramUser iu);

/// from void to InstagramUser
	InstagramUser viewProfileService(InstagramUser iu);

	List<InstagramUser> searchProfileService(InstagramUser iu) throws InstagramException;
	
	List<InstagramUser> viewallProfileService();

	//List<InstagramUser> searchprofileService(InstagramUser iu);

	int editprofilebyname(InstagramUser iu);

	Map<String, List<InstagramUser>> userDetailWithHistoryService();
}
