package main;

import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import beans.Logs;
import beans.Result;

public class ResultPrinter {

	
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
	
	public static String printLogs(List<Logs> results){
		XStream xstream = new XStream(new StaxDriver());
		xstream.alias("logs", Logs.class);
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
