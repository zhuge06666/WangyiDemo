package cn.edu.gdmec.android.wangyidemo;

import android.content.pm.ActivityInfo;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import cn.edu.gdmec.android.wangyidemo.Movie.FgMovieFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView iv_title_news,iv_title_movie,iv_title_video;
    private ViewPager vp;
    private FragmentPagerAdapter adapter;
    private List<Fragment> fragments;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        iv_title_news=findViewById(R.id.iv_title_news);
        iv_title_movie=findViewById(R.id.iv_title_movie);
        iv_title_video=findViewById(R.id.iv_title_video);
        toolbar=findViewById(R.id.toolbars);
        iv_title_news.setSelected(true);
        vp=findViewById(R.id.vp_content);

        fragments=new ArrayList<Fragment>();
        fragments.add(new FgNewsFragment());
        fragments.add(new FgMovieFragment());
        fragments.add(new FgVideoFragment());
        adapter=new MyFragmentAdapter(getSupportFragmentManager(),fragments);
        vp.setAdapter(adapter);
        vp.setOffscreenPageLimit(2);
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayShowTitleEnabled(false);
        }
        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                setSelect(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        iv_title_news.setOnClickListener(this);
        iv_title_movie.setOnClickListener(this);
        iv_title_video.setOnClickListener(this);
    }
    private void setSelect(int position){
        vp.setCurrentItem(position);
        iv_title_news.setSelected(false);
        iv_title_movie.setSelected(false);
        iv_title_video.setSelected(false);
        if (position==0){
            iv_title_news.setSelected(true);
        }else if(position==1){
            iv_title_movie.setSelected(true);
        }else if(position==2){
            iv_title_video.setSelected(true);
        }
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iv_title_news:
                setSelect(0);
                break;
            case R.id.iv_title_movie:
                setSelect(1);
                break;
            case R.id.iv_title_video:
                setSelect(2);
                break;
            default:break;
        }
    }
}
