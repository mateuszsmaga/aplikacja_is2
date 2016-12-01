package mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import beans.Result;

public class ResultsMapper implements RowMapper<Result> {
	public Result mapRow(ResultSet rs, int rowNum) throws SQLException{
		Result results = new Result();
		
		results.setId(rs.getLong("id"));
		results.setName(rs.getString("name"));
		results.setAliases(rs.getString("aliases"));
		
		results.setNumber_of_user_reviews(rs.getInt("number_of_user_reviews"));
		results.setOriginal_release_date(rs.getString("original_release_date"));
		results.setSite_detail_url(rs.getString("site_detail_url"));
		
		results.setDate_added(rs.getString("date_added"));
		results.setDate_last_updated(rs.getString("date_last_updated"));
		results.setApi_detail_url(rs.getString("api_detail_url"));
		
		results.setDeck(rs.getString("deck"));
		results.setExpected_release_year(rs.getInt("expected_release_year"));
		results.setPlatform_arcade(rs.getInt("platform_arcade"));
		
		results.setPlatform_pc(rs.getInt("platform_pc"));
		results.setPlatform_playstation(rs.getInt("platform_playstation"));
		results.setPlatform_xbox(rs.getInt("platform_xbox"));
		
		return results;
	}

}
