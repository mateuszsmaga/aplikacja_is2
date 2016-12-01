package beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Search {
	
	private String error;
    private List<Result> results;
    
    public Search() {
    }

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public List<Result> getResults() {
		return results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}
}
