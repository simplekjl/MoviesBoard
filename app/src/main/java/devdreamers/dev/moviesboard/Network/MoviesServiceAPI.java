package devdreamers.dev.moviesboard.Network;

import devdreamers.dev.moviesboard.Model.ResponseAPI;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;

/**
 *
 * API service interface, it's going to tke place once the retrofit has been created.
 * Created by jlcs on 5/7/16.
 */
public interface MoviesServiceAPI {


    /**
     * Method to get the popular movies in the API
     * @param api_key
     * @return
     */
    @FormUrlEncoded
    @GET("/3/movie/popular")
    Call<ResponseAPI>   getPopularMovies(@Field("api_key") String api_key);


    /**
     * Method to get the top rated movies in the API
     * @param api_key
     * @return
     */
    @FormUrlEncoded
    @GET("/3/movie/top_rated")
    Call<ResponseAPI>   getTopRatedMovies(@Field("api_key") String api_key);


}
