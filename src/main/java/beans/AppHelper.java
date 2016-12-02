package beans;

import org.springframework.stereotype.Service;

@Service("ah")
public class AppHelper {
	private static boolean youCanGrabData = false;
    private static String dataFormat = "XML";
    private static String sql = "";
    
    private AppHelper(){
    	
    }
    
	public static String getSQL() {
		return sql;
	}
	public static void setSQL(String sQL) {
		sql = sQL.replaceAll("\'","");
	}
	public static boolean isYouCanGrabData() {
		return youCanGrabData;
	}
	public static void setYouCanGrabData(boolean youCanGrabData) {
		AppHelper.youCanGrabData = youCanGrabData;
	}
	public static String getDataFormat() {
		return dataFormat;
	}
	public static void setDataFormat(String dataFormat) {
		AppHelper.dataFormat = dataFormat;
	}
	
    
}
