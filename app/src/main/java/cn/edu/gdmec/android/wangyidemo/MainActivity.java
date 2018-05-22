package cn.edu.gdmec.android.wangyidemo;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import cn.edu.gdmec.android.wangyidemo.Movie.FgMovieFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
  private List<Fragment> fragments;
  private ViewPager viewPager;
  private MyFragmentAdapter adapter;
  private ImageView iv_title_news,iv_title_movie,iv_title_video;
  private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager=findViewById(R.id.vp_content);
        iv_title_news=findViewById(R.id.iv_title_news);
        iv_title_movie=findViewById(R.id.iv_title_movie);
        iv_title_video=findViewById(R.id.iv_title_video);
        toolbar=findViewById(R.id.toolbars);
        iv_title_news.setSelected(true);
        initData();
        iv_title_news.setOnClickListener(this);
        iv_title_movie.setOnClickListener(this);
        iv_title_video.setOnClickListener(this);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                 viewPager.setCurrentItem(position);
                 setSelect(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    private void initData(){
        fragments=new ArrayList<Fragment>();
        fragments.add(new FgNewsFragment());
        fragments.add(new FgMovieFragment());
        fragments.add(new FgVideoFragment());
        adapter=new MyFragmentAdapter(getSupportFragmentManager(),fragments);
        viewPager.setAdapter(adapter);
    }
    private void setSelect(int position){
        viewPager.setCurrentItem(position);
        iv_title_video.setSelected(false);
        iv_title_movie.setSelected(false);
        iv_title_news.setSelected(false);
        switch (position){
            case 0:
                iv_title_news.setSelected(true);
                break;
            case 1:
                iv_title_movie.setSelected(true);
                break;
            case 2:
                iv_title_video.setSelected(true);
                break;
        }
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iv_title_news:
                if (viewPager.getCurrentItem()!=0) {
                    setSelect(0);
                }
                break;
            case R.id.iv_title_movie:
                if (viewPager.getCurrentItem()!=1) {
                    setSelect(1);
                }
                break;
            case R.id.iv_title_video:
                if (viewPager.getCurrentItem()!=3) {
                    setSelect(3);
                }
                break;
        }
    }
}
