package devdreamers.dev.moviesboard.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jlcs on 5/9/16.
 */
public class ResponseVideosAPI {
    private String id;
    private List<Video> results = new ArrayList<Video>();
    private String status_code;
    private String status_message;


    @Override
    public String toString() {
        return "ResponseVideosAPI{" +
                "id='" + id + '\'' +
                ", results=" + results +
                ", status_code='" + status_code + '\'' +
                ", status_message='" + status_message + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Video> getResults() {
        return results;
    }

    public void setResults(List<Video> results) {
        this.results = results;
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
}
