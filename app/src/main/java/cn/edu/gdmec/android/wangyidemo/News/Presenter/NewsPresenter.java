package cn.edu.gdmec.android.wangyidemo.News.Presenter;

import cn.edu.gdmec.android.wangyidemo.Bean.NewsBean;
import cn.edu.gdmec.android.wangyidemo.FgNewsFragment;
import cn.edu.gdmec.android.wangyidemo.Http.Api;
import cn.edu.gdmec.android.wangyidemo.News.Model.INewsModel;
import cn.edu.gdmec.android.wangyidemo.News.Model.IOnLoadListener;
import cn.edu.gdmec.android.wangyidemo.News.Model.NewsModel;
import cn.edu.gdmec.android.wangyidemo.News.View.INewsView;

/**
 * Created by apple on 18/5/22.
 */

public class NewsPresenter implements INewsPresenter,IOnLoadListener{
    private INewsModel iNewsModel;
    private INewsView iNewsView;
    public NewsPresenter(INewsView iNewsView){
        this.iNewsView=iNewsView;
        this.iNewsModel=new NewsModel();
    }
    @Override
    public void loadNews(int type, int startPage) {
     iNewsView.showDialog();
    switch (type){
        case FgNewsFragment.NEWS_TYPE_TOP:
            iNewsModel.loadNews("headline",startPage, Api.HANDLINE_ID,this);
            break;
        case FgNewsFragment.NEWS_TYPE_NBA:
            iNewsModel.loadNews("list",startPage, Api.NBA_ID,this);
            break;
        case FgNewsFragment.NEWS_TYPE_JOKES:
            iNewsModel.loadNews("list",startPage, Api.JOKE_ID,this);
            break;
    }
    }

    @Override
    public void success(NewsBean newsBean) {
    iNewsView.hideDialog();
    if (newsBean!=null){
        iNewsView.showNews(newsBean);
    }
    }

    @Override
    public void fail(String error) {
   iNewsView.hideDialog();
   iNewsView.showErrorMsg(error);
    }
}
