package com.instagram.controller;

import java.io.IOException;

public interface InstagramControllerInterface {

	void createProfile() throws IOException;

	void editProfile();

	void deleteProfile();

	void viewProfile();

	void searchProfile();

	void viewAllProfile();

	void userDetailWithHistory();

}
