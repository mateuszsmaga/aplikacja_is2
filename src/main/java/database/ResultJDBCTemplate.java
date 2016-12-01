package database;

import java.util.List;
import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.InvalidResultSetAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import beans.Logs;
import beans.Result;
import mappers.LogsMapper;
import mappers.ResultsMapper;

public class ResultJDBCTemplate implements ResultDAO {

	private JdbcTemplate jdbcTemplateObject;
	public static String SQL;
	
	public ResultJDBCTemplate(DataSource dataSource) {
	    this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public void create(Result result) {
		/*
		try{
			SQL = "insert into game (id, name, aliases, number_of_user_reviews, original_release_date, site_detail_url, date_added, date_last_updated, "
					+ "api_detail_url, deck, expected_release_year, platform_arcade, platform_pc, platform_playstation, platform_xbox) "
					+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		    jdbcTemplateObject.update( SQL, result.getId(), result.getName(), result.getAliases(), result.getNumber_of_user_reviews(), result.getOriginal_release_date(), 
		    		result.getSite_detail_url(), result.getDate_added(), result.getDate_last_updated(), result.getApi_detail_url(), 
		    		result.getDeck(), result.getExpected_release_year(), result.getPlatform_arcade(), result.getPlatform_pc(), 
		    		result.getPlatform_playstation(), result.getPlatform_xbox());
		}catch (InvalidResultSetAccessException e) {
	        throw new RuntimeException(e);
	    } catch (DataAccessException e){
	        throw new RuntimeException(e);
	    }
	    */	
	}
	
	@Override
	public void createLog(Logs logs) {
		try{
			SQL = "insert into logs (ip_address, function_name, browser, browser_version, success, operating_system, date) "
					+ "values (?, ?, ?, ?, ?, ?, ?)";
		    jdbcTemplateObject.update( SQL, logs.getIp_address(), logs.getFunction_name(),  logs.getBrowser(),logs.getBrowser_version(), logs.getSuccess(), logs.getOperating_system(), logs.getDate());
		}catch (InvalidResultSetAccessException e) {
	        throw new RuntimeException(e);
	    } catch (DataAccessException e){
	        throw new RuntimeException(e);
	    }
	    return;
		
	}

	@Override
	public Result getResult(Integer id) {
		SQL = "select * from game where id = ?";
	    Result result = jdbcTemplateObject.queryForObject(SQL, 
	                        new Object[]{id}, new ResultsMapper());
	    return result;
	}

	@Override
	public List<Result> listResult() {
		SQL = "select * from game";
	      List <Result> results = jdbcTemplateObject.query(SQL, 
	                                new ResultsMapper());
	      return results;
	}

	@Override
	public void delete(Integer id) {
		SQL = "delete from game where id = ?";
		jdbcTemplateObject.update(SQL, id);
		System.out.println("Deleted Record with ID = " + id );
     	return;
	}

	@Override
	public void update(int id, String name) {
		SQL = "update game set name = ? where id = ?";
	    jdbcTemplateObject.update(SQL, id, name);
	    System.out.println("Updated Record with ID = " + id );
	    return;
		
	}
	@Override
	public List<Result> getReviews(int number){
		SQL = "CALL reviewCount("+number+")";
		List <Result> results = jdbcTemplateObject.query(SQL, new ResultsMapper());
	    return results;
	}
	@Override
	public List<Result> getResultsContainingName(String name){
		SQL = "CALL findGame('"+name+"')";
		List <Result> results = jdbcTemplateObject.query(SQL, new ResultsMapper());
	    return results;
	}
	@Override
	public List<Result> getDecksContainingTerm(String name){
		SQL = "CALL findDeck('"+name+"')";
		List <Result> results = jdbcTemplateObject.query(SQL, new ResultsMapper());
	    return results;
	}
	@Override
	public List<Result> getDecksGamesByPlatform(int pc, int arcade, int ps, int xbox){
		SQL = "call findByPlatforms("+pc+","+xbox+","+arcade+","+ps+");";
		List <Result> results = jdbcTemplateObject.query(SQL, new ResultsMapper());
	    return results;
	}
	@Override
	public List<Result> getGamesByReleaseYear(String year){
		SQL = "call findReleaseYear("+year+");";
		List <Result> results = jdbcTemplateObject.query(SQL, new ResultsMapper());
	    return results;
	}
	@Override
	public List<Result> getGamesByAddYear(String year){
		SQL = "call findAddYear("+year+");";
		List <Result> results = jdbcTemplateObject.query(SQL, new ResultsMapper());
	    return results;
	}
	@Override
	public List<Result> getGamesFromPlatformPC(){
		SQL = "call onPC();";
		List <Result> results = jdbcTemplateObject.query(SQL, new ResultsMapper());
	    return results;
	}
	@Override
	public List<Result> getGamesFromPlatformXBOX(){
		SQL = "call onXBOX();";
		List <Result> results = jdbcTemplateObject.query(SQL, new ResultsMapper());
	    return results;
	}
	@Override
	public List<Result> getGamesFromPlatformPS(){
		SQL = "call onPS();";
		List <Result> results = jdbcTemplateObject.query(SQL, new ResultsMapper());
	    return results;
	}
	@Override
	public List<Result> getGamesFromPlatformARCADE(){
		SQL = "call onARCADE();";
		List <Result> results = jdbcTemplateObject.query(SQL, new ResultsMapper());
	    return results;
	}
	@Override
	public List<Logs> getLogs(){
		SQL = "call getLogs();";
		List <Logs> results = jdbcTemplateObject.query(SQL, new LogsMapper());
	    return results;
	}

}
