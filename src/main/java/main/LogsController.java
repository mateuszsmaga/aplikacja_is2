package main;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import beans.AppHelper;
import beans.Logs;
import database.ResultDAO;
import eu.bitwalker.useragentutils.UserAgent;
import eu.bitwalker.useragentutils.Version;

//Obsluga,pobieranie danych o operacjach uzytkownikow i zapis do bazy danych
public class LogsController {
	
	private LogsController(){}

	public static void createNewLog(ResultDAO template, HttpServletRequest request){
		
		Logs logs = new Logs();
		
		String user = request.getHeader("User-Agent");
		UserAgent userAgent = UserAgent.parseUserAgentString(user);
		Version browserVersion = userAgent.getBrowserVersion();
		String browserName = userAgent.getBrowser().toString();
		String operatingSystem = userAgent.getOperatingSystem().toString();
		
		String ipAddress = request.getHeader("X-FORWARDED-FOR");
		if (ipAddress == null) {
			   ipAddress = request.getRemoteAddr();
		}
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String dateValue = dateFormat.format(date);
		
		logs.setDate(dateValue);
		logs.setBrowser_version(browserVersion.getMajorVersion());
		logs.setIp_address(ipAddress);
		logs.setBrowser(browserName);
		logs.setOperating_system(operatingSystem);
		logs.setFunction_name(AppHelper.getSQL());
		
		template.createLog(logs);
		
	}
	
	
	

}
