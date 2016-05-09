package devdreamers.dev.moviesboard.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * API response
 * Created by jlcs on 5/7/16.
 */

public class ResponseAPI {
    private String page;
    private List<Movie> results = new ArrayList<>();
    private String total_movies;
    private String total_pages;
    private String total_results;
    private String status_code;
    private String status_message;

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public List<Movie> getResults() {
        return results;
    }

    public void setResults(List<Movie> results) {
        this.results = results;
    }

    public String getTotal_movies() {
        return total_movies;
    }

    public void setTotal_movies(String total_movies) {
        this.total_movies = total_movies;
    }

    public String getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(String total_pages) {
        this.total_pages = total_pages;
    }

    public String getTotal_results() {
        return total_results;
    }

    public void setTotal_results(String total_results) {
        this.total_results = total_results;
    }

    public String getStatus_code() {
        return status_code;
    }

    public void setStatus_code(String status_code) {
        this.status_code = status_code;
    }

    public String getStatus_message() {
        return status_message;
    }

    public void setStatus_message(String status_message) {
        this.status_message = status_message;
    }

    @Override
    public String toString() {
        return "ResponseAPI{" +
                "page='" + page + '\'' +
                ", results=" + results +
                ", total_movies='" + total_movies + '\'' +
                ", total_pages='" + total_pages + '\'' +
                ", total_results='" + total_results + '\'' +
                ", status_code='" + status_code + '\'' +
                ", status_message='" + status_message + '\'' +
                '}';
    }
}