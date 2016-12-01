package database;

import java.util.List;
import javax.sql.DataSource;

import beans.Logs;
import beans.Result;

public interface ResultDAO {

	public void create(Result result);
	public Result getResult(Integer id);
	public List<Result> listResult();
	public void delete(Integer id);
	public void update(int id, String name);
	void createLog(Logs logs);
	List<Result> getReviews(int number);
	List<Result> getResultsContainingName(String name);
	List<Result> getDecksContainingTerm(String name);
	List<Result> getDecksGamesByPlatform(int pc, int arcade, int ps, int xbox);
	List<Result> getGamesByReleaseYear(String year);
	List<Result> getGamesByAddYear(String year);
	List<Result> getGamesFromPlatformPC();
	List<Result> getGamesFromPlatformPS();
	List<Result> getGamesFromPlatformXBOX();
	List<Result> getGamesFromPlatformARCADE();
	List<Logs> getLogs();
}
