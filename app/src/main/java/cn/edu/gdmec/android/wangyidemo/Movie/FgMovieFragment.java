package cn.edu.gdmec.android.wangyidemo.Movie;

import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;

import cn.edu.gdmec.android.wangyidemo.Bean.NewsBean;
import cn.edu.gdmec.android.wangyidemo.Movie.View.IMoviesView;
import cn.edu.gdmec.android.wangyidemo.News.View.INewsView;
import cn.edu.gdmec.android.wangyidemo.R;


public class FgMovieFragment extends Fragment  implements IMoviesView {
 private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fg_movie, null);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    @Override
    public void showNews(NewsBean newsBean) {

    }

    @Override
    public void hideDialog() {

    }

    @Override
    public void showDialog() {

    }

    @Override
    public void showErrorMsg(String error) {

    }
}
