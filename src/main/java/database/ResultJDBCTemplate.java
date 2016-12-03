package database;

import java.util.List;
import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.InvalidResultSetAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import beans.AppHelper;
import beans.Logs;
import beans.Result;
import mappers.LogsMapper;
import mappers.ResultsMapper;

//Obslua bazy danych
public class ResultJDBCTemplate implements ResultDAO {

	private JdbcTemplate jdbcTemplateObject;
	private String SQL = "";
	
	public ResultJDBCTemplate(DataSource dataSource) {
	    this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void createLog(Logs logs) {
		SQL = "CALL insertLogs(\'"+logs.getIp_address()+"\',\'"+logs.getFunction_name()+"\',\'"+logs.getBrowser()
			+"\',\'"+logs.getBrowser_version()+"\',\'"+logs.getSuccess()+"\',\'"+logs.getOperating_system()
			+"\',\'"+logs.getDate()+"\')";
		AppHelper.setSQL(SQL);
		jdbcTemplateObject.update(SQL);
	}

	@Override
	public List<Result> getReviews(int number){
		SQL = "CALL reviewCount("+number+")";
		List <Result> results = jdbcTemplateObject.query(SQL, new ResultsMapper());
		AppHelper.setSQL(SQL);
	    return results;
	}
	@Override
	public List<Result> getResultsContainingName(String name){
		SQL = "CALL findGame('"+name+"')";
		List <Result> results = jdbcTemplateObject.query(SQL, new ResultsMapper());
		AppHelper.setSQL(SQL);
	    return results;
	}
	@Override
	public List<Result> getDecksContainingTerm(String name){
		SQL = "CALL findDeck('"+name+"')";
		List <Result> results = jdbcTemplateObject.query(SQL, new ResultsMapper());
		AppHelper.setSQL(SQL);
	    return results;
	}
	@Override
	public List<Result> getDecksGamesByPlatform(int pc, int arcade, int ps, int xbox){
		SQL = "call findByPlatforms("+pc+","+xbox+","+arcade+","+ps+");";
		List <Result> results = jdbcTemplateObject.query(SQL, new ResultsMapper());
		AppHelper.setSQL(SQL);
	    return results;
	}
	@Override
	public List<Result> getGamesByReleaseYear(String year){
		SQL = "call findReleaseYear("+year+");";
		List <Result> results = jdbcTemplateObject.query(SQL, new ResultsMapper());
		AppHelper.setSQL(SQL);
	    return results;
	}
	@Override
	public List<Result> getGamesByAddYear(String year){
		SQL = "call findAddYear("+year+");";
		List <Result> results = jdbcTemplateObject.query(SQL, new ResultsMapper());
		AppHelper.setSQL(SQL);
	    return results;
	}
	@Override
	public List<Result> getGamesFromPlatformPC(){
		SQL = "call onPC();";
		List <Result> results = jdbcTemplateObject.query(SQL, new ResultsMapper());
		AppHelper.setSQL(SQL);
	    return results;
	}
	@Override
	public List<Result> getGamesFromPlatformXBOX(){
		SQL = "call onXBOX();";
		List <Result> results = jdbcTemplateObject.query(SQL, new ResultsMapper());
		AppHelper.setSQL(SQL);
	    return results;
	}
	@Override
	public List<Result> getGamesFromPlatformPS(){
		SQL = "call onPS();";
		List <Result> results = jdbcTemplateObject.query(SQL, new ResultsMapper());
		AppHelper.setSQL(SQL);
	    return results;
	}
	@Override
	public List<Result> getGamesFromPlatformARCADE(){
		SQL = "call onARCADE();";
		List <Result> results = jdbcTemplateObject.query(SQL, new ResultsMapper());
		AppHelper.setSQL(SQL);
	    return results;
	}
	@Override
	public List<Logs> getLogs(){
		SQL = "call getLogs();";
		List <Logs> results = jdbcTemplateObject.query(SQL, new LogsMapper());
		AppHelper.setSQL(SQL);
	    return results;
	}

}
