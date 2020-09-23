package com.instagram.utility;

import com.instagram.controller.InstagramController;
import com.instagram.controller.InstagramControllerInterface;

public class ControllerFactory {
private ControllerFactory() {
		
	}
	public static InstagramControllerInterface createObject(String m) {
		InstagramControllerInterface is=null;
		if(m.equals("adminController")) {
			is=new InstagramController();
		}
		return is;
	}
}
