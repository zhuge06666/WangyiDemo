package cn.edu.gdmec.android.wangyidemo.Movie.Presenter;

import cn.edu.gdmec.android.wangyidemo.Bean.MoviesBean;
import cn.edu.gdmec.android.wangyidemo.Bean.NewsBean;
import cn.edu.gdmec.android.wangyidemo.Movie.Model.IMoviesModel;
import cn.edu.gdmec.android.wangyidemo.Movie.Model.IOnLoadListener;
import cn.edu.gdmec.android.wangyidemo.Movie.Model.MoviesModel;
import cn.edu.gdmec.android.wangyidemo.Movie.View.IMoviesView;

/**
 * Created by apple on 18/5/22.
 */

public class MoviesPresenter implements IMoviesPresenter,IOnLoadListener {
    private IMoviesModel iMoviesModel;
    private IMoviesView iMoviesView;
    public MoviesPresenter(IMoviesView iMoviesView){
        this.iMoviesView = iMoviesView;
        this.iMoviesModel =new MoviesModel();
    }
    @Override
    public void loadMovies(String movie, String type) {
     iMoviesView.showDialog();
      iMoviesModel.loadMovies(movie,type,this);
    }

    @Override
    public void success(MoviesBean moviesBean) {
    iMoviesView.hideDialog();
    if (moviesBean!=null){
        iMoviesView.showMovies(moviesBean);
    }
    }

    @Override
    public void fail(String error) {
   iMoviesView.hideDialog();
   iMoviesView.showErrorMsg(error);
    }
}
