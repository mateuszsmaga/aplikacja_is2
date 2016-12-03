package main;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import beans.Logs;
import beans.Result;

//Klasa pomocnicza zwracajaca odpowiedni header i format danych
public class FormatSwitcher {
	
	public static String getCorrectFormat(String data, List<Result> results){
	
		if("XML".equals(data)){
			return ResultPrinter.returnXML(results);
		}else if("YAML".equals(data)){
			return ResultPrinter.returnYAML(results);
		}else if("OGDL".equals(data)){
			return ResultPrinter.returnOGDL(results);
		}else if("JSON".equals(data)){
			return ResultPrinter.returnJSON(results);
		}
		return "";
	}
	
	public static HttpServletResponse getCorrectHeader(String data, HttpServletResponse response){
		
		if("XML".equals(data)){
			response.setHeader("Content-Disposition", "attachment; filename=wyniki.xml");  
		}else if("YAML".equals(data)){
			response.setHeader("Content-Disposition", "attachment; filename=wyniki.yml");  
		}else if("OGDL".equals(data)){
			response.setHeader("Content-Disposition", "attachment; filename=wyniki.ogdl");  
		}else if("JSON".equals(data)){
			response.setHeader("Content-Disposition", "attachment; filename=wyniki.json");  
		}
		return response;
	}
	
	
	public static String getCorrectFormatForLogs(String data, List<Logs> results){
		
		if("XML".equals(data)){
			return ResultPrinter.returnLogsXML(results);
		}else if("YAML".equals(data)){
			return ResultPrinter.returnLogsYAML(results);
		}else if("OGDL".equals(data)){
			return ResultPrinter.returnLogsOGDL(results);
		}else if("JSON".equals(data)){
			return ResultPrinter.returnLogsJSON(results);
		}
		return "";
	}
	
	public static HttpServletResponse getCorrectHeaderForLogs(String data, HttpServletResponse response){
		
		if("XML".equals(data)){
			response.setHeader("Content-Disposition", "attachment; filename=logi.xml");  
		}else if("YAML".equals(data)){
			response.setHeader("Content-Disposition", "attachment; filename=logi.yml"); 
		}else if("OGDL".equals(data)){
			response.setHeader("Content-Disposition", "attachment; filename=logi.ogdl");  
		}else if("JSON".equals(data)){
			response.setHeader("Content-Disposition", "attachment; filename=logi.json");  
		}
		return response;
	}
}
