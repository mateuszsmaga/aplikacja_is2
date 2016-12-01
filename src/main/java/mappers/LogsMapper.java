package mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import beans.Logs;

public class LogsMapper implements RowMapper<Logs> {
	public Logs mapRow(ResultSet rs, int rowNum) throws SQLException{
		
		Logs logs = new Logs();
		
		logs.setIp_address(rs.getString("ip_address"));
		logs.setFunction_name(rs.getString("function_name"));
		logs.setBrowser(rs.getString("browser"));
		logs.setBrowser_version(rs.getString("browser_version"));
		logs.setSuccess(rs.getInt("success"));
		logs.setOperating_system(rs.getString("operating_system"));
		logs.setDate(rs.getString("date"));
		return logs;
	}

}
