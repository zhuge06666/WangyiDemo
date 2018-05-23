package cn.edu.gdmec.android.wangyidemo.Movie.Model;

import android.graphics.Movie;

import cn.edu.gdmec.android.wangyidemo.Bean.MoviesBean;
import cn.edu.gdmec.android.wangyidemo.Bean.NewsBean;
import cn.edu.gdmec.android.wangyidemo.Http.Api;
import cn.edu.gdmec.android.wangyidemo.Http.RetrofitHelper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by apple on 18/5/22.
 */

public class MoviesModel implements IMoviesModel
{
    @Override
    public void loadMovies(final String movie,final String type, final IOnLoadListener iOnLoadListener) {
        RetrofitHelper retrofitHelper=new RetrofitHelper(Api.MOVIES_HOST);
        retrofitHelper.getMovies(movie,type).enqueue(new Callback<MoviesBean>() {
            @Override
            public void onResponse(Call<MoviesBean> call, Response<MoviesBean> response) {
                if (response.isSuccessful()){
                    iOnLoadListener.success(response.body());
                }else {
                    iOnLoadListener.fail("");
                }
            }
            @Override
            public void onFailure(Call<MoviesBean> call, Throwable t) {
               iOnLoadListener.fail(t.toString());
            }
        });
    }
}
