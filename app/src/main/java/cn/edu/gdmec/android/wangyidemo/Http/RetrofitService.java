package cn.edu.gdmec.android.wangyidemo.Http;

import cn.edu.gdmec.android.wangyidemo.Bean.MoviesBean;
import cn.edu.gdmec.android.wangyidemo.Bean.NewsBean;
import cn.edu.gdmec.android.wangyidemo.Bean.TodayBean;
import cn.edu.gdmec.android.wangyidemo.Bean.VideoUrlBean;
import cn.edu.gdmec.android.wangyidemo.Bean.WeatherBean;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;
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
                                     @Path("type") String type,
                                     @Query("start") int start);
    @GET("news/feed/v51/")
    Observable<TodayBean> getToday(@Query("category") String category);

    @GET
    Observable<VideoUrlBean> getVideoUrl(@Url String url);
    //http://wthrcdn.etouch.cn/weather_mini?citykey=101010100
    @GET("weather_mini")
    Observable<WeatherBean> getWeather(@Query("citykey") int cityid);
}

