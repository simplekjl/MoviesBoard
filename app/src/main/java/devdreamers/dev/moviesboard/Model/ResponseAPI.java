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
    private Integer totalMovies;
    private Integer totalPages;
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

    /**
     *
     * @return
     * The totalMovies
     */
    public Integer getTotalMovies() {
        return totalMovies;
    }

    /**
     *
     * @param totalMovies
     * The total_Movies
     */
    public void setTotalMovies(Integer totalMovies) {
        this.totalMovies = totalMovies;
    }

    /**
     *
     * @return
     * The totalPages
     */
    public Integer getTotalPages() {
        return totalPages;
    }

    /**
     *
     * @param totalPages
     * The total_pages
     */
    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}