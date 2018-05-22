package cn.edu.gdmec.android.wangyidemo.Movie.Model;

import cn.edu.gdmec.android.wangyidemo.Bean.MoviesBean;
import cn.edu.gdmec.android.wangyidemo.Bean.NewsBean;

/**
 * Created by apple on 18/5/22.
 */

public interface IOnLoadListener {
    void success(MoviesBean moviesBean);
    void fail(String error);
}
