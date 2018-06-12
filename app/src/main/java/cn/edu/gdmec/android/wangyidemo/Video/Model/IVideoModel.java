package cn.edu.gdmec.android.wangyidemo.Video.Model;

/**
 * Created by apple on 18/6/12.
 */

public interface IVideoModel {
    void loadVideo(String category,IVideoLoadListener iVideoLoadListener);
    void loadWeather();
}
