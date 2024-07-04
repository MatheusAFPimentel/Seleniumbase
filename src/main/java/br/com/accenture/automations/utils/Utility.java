package br.com.accenture.automations.utils;

import java.sql.Timestamp;

public class Utility {
	public static  String getTimeMilliseconds(){
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		return Long.toString(timestamp.getTime());
	}

	// arquivo properties => ioutils
	//
}
