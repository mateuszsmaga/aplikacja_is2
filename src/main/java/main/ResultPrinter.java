package main;

import java.util.List;

import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import beans.Logs;
import beans.Result;

//Klasa zwraca przetworzna liste wynikow w odpowiednim formacie
@Service("printer")
public class ResultPrinter {
	
	private ResultPrinter(){}

	public static String returnJSON(List<Result> results){
		Gson gson = new Gson();
		String jsonInString = gson.toJson(results);
		return jsonInString;
	}

	public static String returnXML(List<Result> results){
		XStream xstream = new XStream(new StaxDriver());
		xstream.alias("result", Result.class);
		String xml = xstream.toXML(results);
		return xml;
	}
	
	public static String returnYAML(List<Result> results){
	    DumperOptions options = new DumperOptions();
	    options.setExplicitStart(true);
	    Yaml yaml = new Yaml(options);
	    return yaml.dumpAll(results.iterator());
	}
	public static String returnOGDL(List<Result> results){
		String data = "";
		data+="list\n";
		for(int i = 0; i<results.size(); i++){
			data += "  result\n";
			data += "    id "+results.get(i).getId()+"\n";
			data += "    name \""+results.get(i).getName()+"\"\n";
			data += "    number_of_user_reviews "+results.get(i).getNumber_of_user_reviews()+"\n";
			data += "    deck \""+results.get(i).getDeck()+"\"\n";
			data += "    original_release_date \""+results.get(i).getOriginal_release_date()+"\"\n";
			data += "    site_detail_url "+results.get(i).getSite_detail_url()+"\n";
			data += "    date_added \""+results.get(i).getDate_added()+"\"\n";
			data += "    date_last_updated \""+results.get(i).getDate_last_updated()+"\"\n";
			data += "    api_detail_url "+results.get(i).getApi_detail_url()+"\n";
			data += "    expected_release_quarter "+results.get(i).getExpected_release_quarter()+"\n";
			data += "    expected_release_year "+results.get(i).getExpected_release_year()+"\n";
			data += "    platform_pc "+results.get(i).getPlatform_pc()+"\n";
			data += "    platform_playstation "+results.get(i).getPlatform_playstation()+"\n";
			data += "    platform_arcade "+results.get(i).getPlatform_arcade()+"\n";
			data += "    platform_xbox "+results.get(i).getPlatform_xbox()+"\n";
		}
		return data;
	}
	
	public static String returnLogsJSON(List<Logs> results){
		Gson gson = new Gson();
		String jsonInString = gson.toJson(results);
		return jsonInString;
	}
	
	public static String returnLogsXML(List<Logs> results){
		XStream xstream = new XStream(new StaxDriver());
		xstream.alias("logs", Logs.class);
		String xml = xstream.toXML(results);
		return xml;
	}
	
	public static String returnLogsYAML(List<Logs> results){
		XStream xstream = new XStream(new StaxDriver());
		xstream.alias("logs", Logs.class);
		String xml = xstream.toXML(results);
		return xml;
	}
	
	public static String returnLogsOGDL(List<Logs> results){
		String data = "";
		data+="list\n";
		for(int i = 0; i<results.size(); i++){
			data += "  result\n";
			data += "    ip_address "+results.get(i).getIp_address()+"\n";
			data += "    function_name \""+results.get(i).getFunction_name()+"\"\n";
			data += "    browser "+results.get(i).getBrowser()+"\n";
			data += "    browser_version "+results.get(i).getBrowser_version()+"\n";
			data += "    operating_system "+results.get(i).getOperating_system()+"\n";
			data += "    date \""+results.get(i).getDate()+"\"\n";
		}
		
		return data;
	}
	
	public static String byGameName(List<Result> results){
		XStream xstream = new XStream(new StaxDriver());
		xstream.alias("result", Result.class);
		xstream.omitField(Result.class, "number_of_user_reviews");
		xstream.omitField(Result.class, "expected_release_quarter");
		xstream.omitField(Result.class, "expected_release_year");
		xstream.omitField(Result.class, "date_last_updated");
		xstream.omitField(Result.class, "api_detail_url");
		String xml = xstream.toXML(results);
		return xml;
	}
	

	

	
	public static String returnError(){
		return "<error>"
				+"<msg>Mozesz pobierac jedynie 1 plik co 15 sekund. Odczekaj przed probraniem nastepnego wyniku</msg>"
				+"</error>";
	}
	public static String byGameNameWithReviews(List<Result> results){
		XStream xstream = new XStream(new StaxDriver());
		xstream.alias("result", Result.class);
		xstream.omitField(Result.class, "expected_release_quarter");
		xstream.omitField(Result.class, "expected_release_year");
		xstream.omitField(Result.class, "date_last_updated");
		xstream.omitField(Result.class, "api_detail_url");
		String xml = xstream.toXML(results);
		return xml;
	}

	public static int boolTo01(boolean value){
		if(value)
			return 1;
		else
			return 0;
	}

}
