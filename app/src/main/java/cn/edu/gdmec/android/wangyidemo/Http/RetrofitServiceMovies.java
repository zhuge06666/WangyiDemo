package cn.edu.gdmec.android.wangyidemo.Http;

import cn.edu.gdmec.android.wangyidemo.Bean.MoviesBean;
import cn.edu.gdmec.android.wangyidemo.Bean.NewsBean;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by apple on 18/5/22.
 */

public interface RetrofitServiceMovies {
    @GET("v2/{movie}/{type}")
    Call<MoviesBean> getMovies(@Path("movie") String movie,
                               @Path("type") String type);
}
