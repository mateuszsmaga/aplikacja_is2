package main;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import beans.AppHelper;
import beans.Logs;
import beans.PlatformsSearch;
import beans.Result;
import beans.Searches;
import database.ResultDAO;

//Kontroler - obsluga formularzy
@Controller
public class MainController {
    
    @Autowired
    private ResultDAO resultJDBCTemplate;

    @GetMapping("app")
    public String getMapping(Model model) {
        model.addAttribute("gameName", new Searches());
        model.addAttribute("gameDeck", new Searches());
        model.addAttribute("reviewsNumber", new Searches());
        model.addAttribute("releaseYear", new Searches());
        model.addAttribute("addYear", new Searches());
        model.addAttribute("downloadFormat", new Searches());
        model.addAttribute("platforms", new PlatformsSearch());
        return "app";
    }

    @GetMapping("errorMsg")
    public void errorMsg(HttpServletResponse response) throws IOException {
    	response.sendRedirect("app");
    }
    
    @RequestMapping(value = "/downloadFormat", method = RequestMethod.POST)
    public void downloadFormatResults(@ModelAttribute("downloadFormat") Searches search, HttpServletResponse response) throws IOException {
    	AppHelper.setDataFormat(search.getSearch());
    	response.sendRedirect("app");
    }
   
    @RequestMapping(value = "/gameName", method = RequestMethod.POST)
    @ResponseBody
    public String gameNameSearchResults(@ModelAttribute("gameName") Searches search, HttpServletResponse response, HttpServletRequest request) throws IOException {
		if(AppHelper.isYouCanGrabData()){
			AppHelper.setYouCanGrabData(false);
	    	List<Result> results = resultJDBCTemplate.getResultsContainingName(search.getSearch());
	    	LogsController.createNewLog(resultJDBCTemplate, request);
	    	FormatSwitcher.getCorrectHeader(AppHelper.getDataFormat(), response);
	    	return FormatSwitcher.getCorrectFormat(AppHelper.getDataFormat(), results);
		}else{
			response.sendRedirect("app");;
			return "app";
		}

    }

    @RequestMapping(value = "/gameDeck", method = RequestMethod.POST, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    @ResponseBody
    public String gameDeckSearchResults(@ModelAttribute("gameDeck") Searches search, HttpServletResponse response, HttpServletRequest request) throws IOException {
    	if(AppHelper.isYouCanGrabData()){
			AppHelper.setYouCanGrabData(false);
	    	List<Result> results = resultJDBCTemplate.getDecksContainingTerm(search.getSearch());
	    	LogsController.createNewLog(resultJDBCTemplate, request);
	    	FormatSwitcher.getCorrectHeader(AppHelper.getDataFormat(), response);
	    	return FormatSwitcher.getCorrectFormat(AppHelper.getDataFormat(), results);
		}else{
			response.sendRedirect("app");;
			return "app";
		}

    }

    @RequestMapping(value = "/platforms", method = RequestMethod.POST, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    @ResponseBody
    public String gamePlatformsSearchResults(@ModelAttribute("platforms") PlatformsSearch platform, HttpServletResponse response, HttpServletRequest request) throws IOException {
    	if(AppHelper.isYouCanGrabData()){
			AppHelper.setYouCanGrabData(false);
			int pc, ps, arcade, xbox;
	    	pc=ResultPrinter.boolTo01(platform.isPc());
	    	arcade=ResultPrinter.boolTo01(platform.isArcade());
	    	xbox=ResultPrinter.boolTo01(platform.isXbox());
	    	ps=ResultPrinter.boolTo01(platform.isPlaystation());
	    	  	
	    	List<Result> results = resultJDBCTemplate.getDecksGamesByPlatform(pc, arcade, ps, xbox);
	    	LogsController.createNewLog(resultJDBCTemplate, request);
	    	FormatSwitcher.getCorrectHeader(AppHelper.getDataFormat(), response);
	    	return FormatSwitcher.getCorrectFormat(AppHelper.getDataFormat(), results);
		}else{
			response.sendRedirect("app");;
			return "app";
		}	
    }
    
    @RequestMapping(value = "/platformPC", method = RequestMethod.POST, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    @ResponseBody
    public String platformPC(HttpServletResponse response, HttpServletRequest request) throws IOException {
    	if(AppHelper.isYouCanGrabData()){
			AppHelper.setYouCanGrabData(false);
	    	List<Result> results = resultJDBCTemplate.getGamesFromPlatformPC();
	    	LogsController.createNewLog(resultJDBCTemplate, request);
	    	FormatSwitcher.getCorrectHeader(AppHelper.getDataFormat(), response);
	    	return FormatSwitcher.getCorrectFormat(AppHelper.getDataFormat(), results);
		}else{
			response.sendRedirect("app");;
			return "app";
		}
    	
    	
    }
    
    @RequestMapping(value = "/platformPS", method = RequestMethod.POST, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    @ResponseBody
    public String platformPS(HttpServletResponse response, HttpServletRequest request) throws IOException {
    	if(AppHelper.isYouCanGrabData()){
			AppHelper.setYouCanGrabData(false);
	    	List<Result> results = resultJDBCTemplate.getGamesFromPlatformPS();
	    	LogsController.createNewLog(resultJDBCTemplate, request);
	    	FormatSwitcher.getCorrectHeader(AppHelper.getDataFormat(), response);
	    	return FormatSwitcher.getCorrectFormat(AppHelper.getDataFormat(), results);
		}else{
			response.sendRedirect("app");;
			return "app";
		}
    	
    	
    }
    
    @RequestMapping(value = "/platformXBOX", method = RequestMethod.POST, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    @ResponseBody
    public String platformXBOX(HttpServletResponse response, HttpServletRequest request) throws IOException {
    	if(AppHelper.isYouCanGrabData()){
			AppHelper.setYouCanGrabData(false);	
			
	    	List<Result> results = resultJDBCTemplate.getGamesFromPlatformXBOX();
	    	LogsController.createNewLog(resultJDBCTemplate, request);
	    	FormatSwitcher.getCorrectHeader(AppHelper.getDataFormat(), response);
	    	return FormatSwitcher.getCorrectFormat(AppHelper.getDataFormat(), results);
		}else{
			response.sendRedirect("app");;
			return "app";
		}
    	
    	
    }
    
    @RequestMapping(value = "/platformARCADE", method = RequestMethod.POST, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    @ResponseBody
    public String platformARCADE(HttpServletResponse response, HttpServletRequest request) throws IOException {
    	if(AppHelper.isYouCanGrabData()){
			AppHelper.setYouCanGrabData(false);
	    	List<Result> results = resultJDBCTemplate.getGamesFromPlatformARCADE();
	    	LogsController.createNewLog(resultJDBCTemplate, request);
	    	FormatSwitcher.getCorrectHeader(AppHelper.getDataFormat(), response);
	    	return FormatSwitcher.getCorrectFormat(AppHelper.getDataFormat(), results);
		}else{
			response.sendRedirect("app");;
			return "app";
		}
    	
    	
    }
    
    @RequestMapping(value = "/reviewsNumber", method = RequestMethod.POST, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    @ResponseBody
    public String findByReviewsNumber(@ModelAttribute("reviewsNumber") Searches search, HttpServletResponse response, HttpServletRequest request) throws IOException {
    	if(AppHelper.isYouCanGrabData()){
			AppHelper.setYouCanGrabData(false);
	    	int reviewNumber = Integer.parseInt(search.getSearch());
	    	List<Result> results = resultJDBCTemplate.getReviews(reviewNumber);
	    	LogsController.createNewLog(resultJDBCTemplate, request);
	    	FormatSwitcher.getCorrectHeader(AppHelper.getDataFormat(), response);
	    	return FormatSwitcher.getCorrectFormat(AppHelper.getDataFormat(), results);
		}else{
			response.sendRedirect("app");;
			return "app";
		}

    }
    
    @RequestMapping(value = "/releaseYear", method = RequestMethod.POST, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    @ResponseBody
    public String findByReleaseYear(@ModelAttribute("releaseYear") Searches search, HttpServletResponse response, HttpServletRequest request) throws IOException {
    	if(AppHelper.isYouCanGrabData()){
    		
			AppHelper.setYouCanGrabData(false);
	    	List<Result> results = resultJDBCTemplate.getGamesByReleaseYear(search.getSearch());
	    	LogsController.createNewLog(resultJDBCTemplate, request);
	    	FormatSwitcher.getCorrectHeader(AppHelper.getDataFormat(), response);
	    	return FormatSwitcher.getCorrectFormat(AppHelper.getDataFormat(), results);
		}else{
			response.sendRedirect("app");;
			return "app";
		}
    	
    }
    
    @RequestMapping(value = "/addYear", method = RequestMethod.POST, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    @ResponseBody
    public String findByUpdateYear(@ModelAttribute("addYear") Searches search, HttpServletResponse response, HttpServletRequest request) throws IOException {
    	if(AppHelper.isYouCanGrabData()){
			AppHelper.setYouCanGrabData(false);
	    	List<Result> results = resultJDBCTemplate.getGamesByAddYear(search.getSearch());
	    	LogsController.createNewLog(resultJDBCTemplate, request);
	    	FormatSwitcher.getCorrectHeader(AppHelper.getDataFormat(), response);
	    	return FormatSwitcher.getCorrectFormat(AppHelper.getDataFormat(), results);
		}else{
			response.sendRedirect("app");;
			return "app";
		}
    	
    }
    
    @RequestMapping(value = "/logs", method = RequestMethod.POST, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    @ResponseBody
    public String findByUpdateYear( HttpServletResponse response, HttpServletRequest request) throws IOException {
    	if(AppHelper.isYouCanGrabData()){
			AppHelper.setYouCanGrabData(false);
			response.setHeader("Content-Disposition", "attachment; filename=logi.xml");
	    	List<Logs> results = resultJDBCTemplate.getLogs();
	    	LogsController.createNewLog(resultJDBCTemplate, request);
	    	FormatSwitcher.getCorrectHeaderForLogs(AppHelper.getDataFormat(), response);
	    	return FormatSwitcher.getCorrectFormatForLogs(AppHelper.getDataFormat(), results);
		}else{
			response.sendRedirect("app");;
			return "app";
		}
    	
    }
    

}