package cn.edu.gdmec.android.wangyidemo.News.View;

import cn.edu.gdmec.android.wangyidemo.Bean.NewsBean;

/**
 * Created by apple on 18/5/22.
 */

public interface INewsView {
    void showNews(NewsBean newsBean);
    void showMoreNews(NewsBean newsBean);
    void hideDialog();
    void showDialog();
    void showErrorMsg(String error);
}
