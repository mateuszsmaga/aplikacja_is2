package database;

import java.util.List;
import javax.sql.DataSource;

import beans.Logs;
import beans.Result;

//interfejs definiujacy metody oblsugi bazy danych
public interface ResultDAO {

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
