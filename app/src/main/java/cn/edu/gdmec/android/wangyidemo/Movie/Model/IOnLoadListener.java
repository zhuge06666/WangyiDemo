package cn.edu.gdmec.android.wangyidemo.Movie.Model;

import cn.edu.gdmec.android.wangyidemo.Bean.MoviesBean;

/**
 * Created by apple on 18/5/22.
 */

public interface IOnLoadListener {
    void success(MoviesBean moviesBean);
    void fail(String error);
    void loadMoreSuccess(MoviesBean moviesBean);
}
