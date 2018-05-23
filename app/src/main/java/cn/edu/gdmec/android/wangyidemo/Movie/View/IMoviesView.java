package cn.edu.gdmec.android.wangyidemo.Movie.View;

import cn.edu.gdmec.android.wangyidemo.Bean.MoviesBean;
import cn.edu.gdmec.android.wangyidemo.Bean.NewsBean;

/**
 * Created by apple on 18/5/22.
 */

public interface IMoviesView {
    void showMovies(MoviesBean moviesBean);
    void hideDialog();
    void showDialog();
    void showErrorMsg(String error);
}
