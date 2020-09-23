package com.instagram.utility;

import com.instagram.dao.InstagramDAO;
import com.instagram.dao.InstagramDAOInterface;

public class DAOFactory {

	private DAOFactory() {
		
	}
	public static InstagramDAOInterface createObject(String m) {
		InstagramDAOInterface is=null;
		if(m.equals("admindao")) {
			is=new InstagramDAO();
		}
		return is;
	}
}
