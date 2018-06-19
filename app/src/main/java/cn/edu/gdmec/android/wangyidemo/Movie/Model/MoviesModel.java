package cn.edu.gdmec.android.wangyidemo.Movie.Model;

import cn.edu.gdmec.android.wangyidemo.Bean.MoviesBean;
import cn.edu.gdmec.android.wangyidemo.Http.Api;
import cn.edu.gdmec.android.wangyidemo.Http.RetrofitHelper;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by apple on 18/5/22.
 */

public class MoviesModel implements IMoviesModel
{
    @Override
    public void loadMovies(final String movie,final String type,final int start, final IOnLoadListener iOnLoadListener) {
        RetrofitHelper retrofitHelper=new RetrofitHelper(Api.MOVIES_HOST);
        retrofitHelper.getMovies(movie,type,start)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<MoviesBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                     iOnLoadListener.fail(e.getMessage());
                    }

                    @Override
                    public void onNext(MoviesBean moviesBean) {
                        if (start!=0) {
                            iOnLoadListener.loadMoreSuccess(moviesBean);
                        }else {
                            iOnLoadListener.success(moviesBean);
                        }
                    }
                });
    }

    }

