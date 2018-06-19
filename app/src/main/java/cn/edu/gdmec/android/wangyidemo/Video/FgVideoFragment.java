package cn.edu.gdmec.android.wangyidemo.Video;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import cn.edu.gdmec.android.wangyidemo.Bean.TodayContentBean;
import cn.edu.gdmec.android.wangyidemo.R;
import cn.edu.gdmec.android.wangyidemo.Video.ItemVideoAdapter;
import cn.edu.gdmec.android.wangyidemo.Video.Model.VideoModel;
import cn.edu.gdmec.android.wangyidemo.Video.Presenter.IVideoPresenter;
import cn.edu.gdmec.android.wangyidemo.Video.Presenter.VideoPresenter;
import cn.edu.gdmec.android.wangyidemo.Video.View.IVideoView;


public class FgVideoFragment extends Fragment implements IVideoView {
    private IVideoPresenter iVideoPresenter;
    private RecyclerView rv_video;
    private ItemVideoAdapter itemVideoAdapter;
    private SwipeRefreshLayout srl_video;
    Integer[] city={101280101,101280102,101280103,101280104,101280105, 101280201,101280202,101280203,101280204,101280205,101280206, 101280207,101280208,101280501};
   private LinearLayoutManager layoutManager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fg_video, null);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
         iVideoPresenter=new VideoPresenter(this,0);
        rv_video = view.findViewById(R.id.rv_video);
        srl_video = view.findViewById(R.id.srl_video);
        srl_video.setColorSchemeColors(Color.parseColor("#ffce3d3a"));
        iVideoPresenter.loadVideo();
        rv_video.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                if (newState==RecyclerView.SCROLL_STATE_IDLE&&(layoutManager.findLastVisibleItemPosition()+1==layoutManager.getItemCount())){
                    loadMore();
                }
            }
        });
        srl_video.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                iVideoPresenter.loadVideo();
            }
        });
        itemVideoAdapter=new ItemVideoAdapter(getActivity());
    }
    private void loadMore(){
        iVideoPresenter=new VideoPresenter(this,1);
        iVideoPresenter.loadVideo();

    }
    @Override
    public void showVideo(List<TodayContentBean> todayContentBeans, List<String> videoList) {
        itemVideoAdapter.setData(todayContentBeans, videoList);
        layoutManager=new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL, false);
        rv_video.setLayoutManager(layoutManager);
        rv_video.setAdapter(itemVideoAdapter);

    }

    @Override
    public void hideDialog() {
srl_video.setRefreshing(false);
    }

    @Override
    public void showDialog() {
srl_video.setRefreshing(true);
    }

    @Override
    public void showErrorMsg(Throwable throwable) {
        Toast.makeText(getContext(),"加载出错"+throwable.getMessage(),Toast.LENGTH_SHORT).show();
    }
}
