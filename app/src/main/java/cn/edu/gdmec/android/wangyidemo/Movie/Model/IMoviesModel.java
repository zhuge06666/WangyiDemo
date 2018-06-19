package cn.edu.gdmec.android.wangyidemo.Movie.Model;

/**
 * Created by apple on 18/5/22.
 */

public interface IMoviesModel {
    void loadMovies(String movie, String type,int start, IOnLoadListener iOnLoadListener);
}
