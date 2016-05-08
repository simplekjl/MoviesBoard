package devdreamers.dev.moviesboard.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API response
 * Created by jlcs on 5/7/16.
 */

public class ResponseAPI {
    private Integer page;
    private List<Movie> Movies = new ArrayList<Movie>();
    private List<Video> mVideos = new ArrayList<Video>();
    private List<Review> mReviews = new ArrayList<Review>();
    private Integer total_movies;
    private Integer total_pages;
    private Integer total_results;


    public List<Review> getmReviews() {
        return mReviews;
    }

    public void setmReviews(List<Review> mReviews) {
        this.mReviews = mReviews;
    }

    public List<Video> getmVideos() {
        return mVideos;
    }

    public void setmVideos(List<Video> mVideos) {
        this.mVideos = mVideos;
    }

    /**
     *
     * @return
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    private Integer id;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The page
     */
    public Integer getPage() {
        return page;
    }

    /**
     *
     * @param page
     * The page
     */
    public void setPage(Integer page) {
        this.page = page;
    }

    /**
     *
     * @return
     * The Movies
     */
    public List<Movie> getMovies() {
        return Movies;
    }

    /**
     *
     * @param Movies
     * The Movies
     */
    public void setMovies(List<Movie> Movies) {
        this.Movies = Movies;
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

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}