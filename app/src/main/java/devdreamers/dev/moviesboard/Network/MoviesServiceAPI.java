package devdreamers.dev.moviesboard.Network;

import devdreamers.dev.moviesboard.Model.ResponseAPI;
import devdreamers.dev.moviesboard.Model.ResponseVideosAPI;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

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
    @POST("/3/movie/popular")
    Call<ResponseAPI>   getPopularMovies(@Field("api_key") String api_key);


    /**
     * Method to get the top rated movies in the API
     * @param api_key
     * @return
     */
    @FormUrlEncoded
    @POST("/3/movie/top_rated")
    Call<ResponseAPI>   getTopRatedMovies(@Field("api_key") String api_key);

    /**
     * Method to get the videos related of an specific movie
     * @param id
     * @param api_key
     * @return
     */
    @GET("/3/movie/{id}/videos?")
    Call<ResponseVideosAPI> getMovieVideos(@Path("id") String id, @Query("api_key") String api_key);


    /**
     * method to get the reviews of an specific movie
     * @param id
     * @param api_key
     * @return
     */
    @GET("/movie/{id}/reviews")
    Call<ResponseAPI> getReviewMovie(@Path("id") String id, @Field("api_key") String api_key);




}
