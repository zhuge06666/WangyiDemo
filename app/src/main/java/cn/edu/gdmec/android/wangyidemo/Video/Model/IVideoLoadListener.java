package cn.edu.gdmec.android.wangyidemo.Video.Model;

import java.util.List;

import cn.edu.gdmec.android.wangyidemo.Bean.TodayBean;
import cn.edu.gdmec.android.wangyidemo.Bean.TodayContentBean;
import cn.edu.gdmec.android.wangyidemo.Bean.VideoUrlBean;

/**
 * Created by apple on 18/6/12.
 */

public interface IVideoLoadListener {
    void videoUrlSuccess(List<VideoUrlBean> videoUrlBeans, List<TodayContentBean> contentBeans);
    void fail(Throwable throwable);
}
