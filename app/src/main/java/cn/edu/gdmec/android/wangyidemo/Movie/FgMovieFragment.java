package cn.edu.gdmec.android.wangyidemo.Movie;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

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
private RecyclerView rv_movie_on;
private ItemMovieOnAdapter movieOnAdapter;
private RecyclerView rv_movie_top;
private ItemMovieTopAdapter movieTopAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fg_movie, null);
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        swipeRefreshLayout=view.findViewById(R.id.srl_movie);
        swipeRefreshLayout.setColorSchemeColors(Color.parseColor("#ffce3d3a"));
        rv_movie_on = view.findViewById(R.id.rv_movie_on);
        rv_movie_top=view.findViewById(R.id.rv_movie_top);
        movieTopAdapter=new ItemMovieTopAdapter(getActivity());
        movieOnAdapter=new ItemMovieOnAdapter(getActivity());
        presenter=new MoviesPresenter(this);
        presenter.loadMovies("movie","in_theaters");
        presenter.loadMovies("movie","top250");
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
           @Override
           public void onRefresh() {
              presenter.loadMovies("movie","in_theaters");
              presenter.loadMovies("movie","top250");
           }
        });

    }
   @Override
   public void showMovies(final MoviesBean moviesBean) {
        if (moviesBean.getTotal()==29){
     movieOnAdapter.setData(moviesBean.getSubjects());
     rv_movie_on.setLayoutManager(new LinearLayoutManager(getActivity()));
     rv_movie_on.setAdapter(movieOnAdapter);}
     else if(moviesBean.getTotal()==250){
            movieTopAdapter.setData(moviesBean.getSubjects());
            LinearLayoutManager mLayoutManager =
                    new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
            rv_movie_top.setLayoutManager(mLayoutManager);
            rv_movie_top.setAdapter(movieTopAdapter);
        }
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
        Toast.makeText(getContext(),"加载出错："+error.toString(),Toast.LENGTH_SHORT).show();
    }
}
