package devdreamers.dev.moviesboard.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * API response
 * Created by jlcs on 5/7/16.
 */

public class ResponseAPI {
    private Integer page;
    private List<Movie> results = new ArrayList<>();
    private Integer total_movies;
    private Integer total_pages;
    private Integer total_results;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public List<Movie> getResults() {
        return results;
    }

    public void setResults(List<Movie> results) {
        this.results = results;
    }

    public Integer getTotal_movies() {
        return total_movies;
    }

    public void setTotal_movies(Integer total_movies) {
        this.total_movies = total_movies;
    }

    public Integer getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(Integer total_pages) {
        this.total_pages = total_pages;
    }

    public Integer getTotal_results() {
        return total_results;
    }

    public void setTotal_results(Integer total_results) {
        this.total_results = total_results;
    }

    @Override
    public String toString() {
        return "ResponseAPI{" +
                "page=" + page +
                ", total_movies=" + total_movies +
                ", total_pages=" + total_pages +
                ", total_results=" + total_results +
                '}';
    }

}