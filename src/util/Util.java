package util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {

	
	public static Timestamp stringATimestamp(String fecha) {
		
		 Timestamp fechaTimestamp;
		try {
		    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
		    Date parsedDate = dateFormat.parse(fecha);
		    fechaTimestamp = new java.sql.Timestamp(parsedDate.getTime());
		} catch(Exception e) {
			e.printStackTrace();
			fechaTimestamp = null;
		}
		
		return fechaTimestamp;
	}
}
