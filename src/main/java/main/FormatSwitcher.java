package main;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import beans.Logs;
import beans.Result;

public class FormatSwitcher {
	
	public static String getCorrectFormat(String data, List<Result> results){
	
		if(data.equals("XML")){
			return ResultPrinter.returnXML(results);
		}else if(data.equals("YAML")){
			return ResultPrinter.returnYAML(results);
		}else if(data.equals("OGDL")){
			return ResultPrinter.returnOGDL(results);
		}else if(data.equals("JSON")){
			return ResultPrinter.returnJSON(results);
		}
		return "";
	}
	
	public static HttpServletResponse getCorrectHeader(String data, HttpServletResponse response){
		
		if(data.equals("XML")){
			response.setHeader("Content-Disposition", "attachment; filename=wyniki.xml");  
		}else if(data.equals("YAML")){
			response.setHeader("Content-Disposition", "attachment; filename=wyniki.yml");  
		}else if(data.equals("OGDL")){
			
		}else if(data.equals("JSON")){
			response.setHeader("Content-Disposition", "attachment; filename=wyniki.json");  
		}
		return response;
	}
	
	
	public static String getCorrectFormatForLogs(String data, List<Logs> results){
		
		if(data.equals("XML")){
			return ResultPrinter.returnLogsXML(results);
		}else if(data.equals("YAML")){
			return ResultPrinter.returnLogsYAML(results);
		}else if(data.equals("OGDL")){
			return ResultPrinter.returnLogsOGDL(results);
		}else if(data.equals("JSON")){
			return ResultPrinter.returnLogsJSON(results);
		}
		return "";
	}
	
	public static HttpServletResponse getCorrectHeaderForLogs(String data, HttpServletResponse response){
		
		if(data.equals("XML")){
			response.setHeader("Content-Disposition", "attachment; filename=logi.xml");  
		}else if(data.equals("YAML")){
			response.setHeader("Content-Disposition", "attachment; filename=logi.yml"); 
		}else if(data.equals("OGDL")){
			
		}else if(data.equals("JSON")){
			response.setHeader("Content-Disposition", "attachment; filename=logi.json");  
		}
		return response;
	}
}
