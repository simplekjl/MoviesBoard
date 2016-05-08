package devdreamers.dev.moviesboard.Network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Retrofit Singleton instance
 * Created by jlcs on 5/7/16.
 */
public class MoviesService {

    //Variables
    public static final String URL_BASE = "http://api.themoviedb.org";
    public static final String URL_IMAGE_BASE = "http://image.tmdb.org/t/p/";

    //retrofit variables
    private Retrofit retrofit;
    private MoviesServiceAPI service;

    public MoviesService() {
        //creating the retrofit instance
        retrofit = new Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //instance of my interface
        service = retrofit.create(MoviesServiceAPI.class);
    }

    public MoviesServiceAPI getRetrofit() {

        return service;
    }


}
