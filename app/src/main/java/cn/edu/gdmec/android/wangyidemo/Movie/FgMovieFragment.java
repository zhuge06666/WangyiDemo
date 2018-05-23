package cn.edu.gdmec.android.wangyidemo.Movie;

import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;
import android.widget.TextView;

import java.util.TimerTask;

import cn.edu.gdmec.android.wangyidemo.Bean.MoviesBean;
import cn.edu.gdmec.android.wangyidemo.Bean.NewsBean;
import cn.edu.gdmec.android.wangyidemo.Movie.Presenter.MoviesPresenter;
import cn.edu.gdmec.android.wangyidemo.Movie.View.IMoviesView;
import cn.edu.gdmec.android.wangyidemo.News.View.INewsView;
import cn.edu.gdmec.android.wangyidemo.R;


public class FgMovieFragment extends Fragment  implements IMoviesView {
 private SwipeRefreshLayout swipeRefreshLayout;
 private MoviesPresenter presenter;
private TextView tv_movies;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fg_movie, null);
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        swipeRefreshLayout=view.findViewById(R.id.srl_movies);
        tv_movies=view.findViewById(R.id.tv_movies);
        presenter=new MoviesPresenter(this);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
           @Override
           public void onRefresh() {
              presenter.loadMovies("movie","in_theaters");
           }
        });

    }
   @Override
   public void showMovies(final MoviesBean moviesBean) {
  getActivity().runOnUiThread(new TimerTask() {
     @Override
     public void run() {
        tv_movies.setText("电影名:"+moviesBean.getSubjects().get(0).getTitle()+"\n"+moviesBean.getSubjects().get(0).getDirectors());
     }
  });
   }

   @Override
    public void hideDialog() {
      swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void showDialog() {
       swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void showErrorMsg(String error) {
       tv_movies.setText("加载失败"+error);
    }
}
