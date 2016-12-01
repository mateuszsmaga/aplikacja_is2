package beans;

public class Searches {
    private String search;

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search.replaceAll("/\\*.*\\*/", "");;
	}

}
