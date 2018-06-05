package cn.edu.gdmec.android.wangyidemo.Http;

import cn.edu.gdmec.android.wangyidemo.Bean.MoviesBean;
import cn.edu.gdmec.android.wangyidemo.Bean.NewsBean;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by apple on 18/5/22.
 */

public interface RetrofitService {
    @GET("nc/article/{type}/{id}/{startPage}-20.html")
    Observable<NewsBean> getNews(@Path("type") String type,
                                 @Path("id") String id,
                                 @Path("startPage") int startPage);
    @GET("v2/{movie}/{type}")
    Observable<MoviesBean> getMovies(@Path("movie") String movie,
                                     @Path("type") String type);

}

