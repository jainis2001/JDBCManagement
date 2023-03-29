package org.example.util;

import java.util.UUID;
import java.util.regex.Pattern;

public class Util {

	public String createId(){
		return String.valueOf(UUID.randomUUID());

	}

	public static boolean verifyMobile(Long mobile) {
		String strMobile=String.valueOf(mobile);
		return strMobile.length() == 10;
	}

	public static boolean verifyEmail(String email) {
		return !Pattern.compile("^(.+)@(\\S+)$")
				.matcher(email)
				.matches();

	}



}
