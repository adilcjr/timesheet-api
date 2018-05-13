package com.edea.timesheet.api.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtils {
	
	private static final Logger log = LoggerFactory.getLogger(PasswordUtils.class);
	
	public PasswordUtils() {
	}

	public static String generateBCrypt(String aPassword) {
		
		if (aPassword == null) {
			log.warn("Hash generation failed. A password cannot be null.");
			return null;
		}
		
		log.info("Generating hash with Bcrypt.");
		BCryptPasswordEncoder bCryptEncoder = new BCryptPasswordEncoder();
		return bCryptEncoder.encode(aPassword);
	}
}
