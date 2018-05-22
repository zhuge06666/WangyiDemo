package cn.edu.gdmec.android.wangyidemo;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;
import android.widget.TableLayout;

import java.util.ArrayList;
import java.util.List;


public class FgNewsFragment extends Fragment  {

    public static final int NEWS_TYPE_TOP=0;
    public static final int NEWS_TYPE_NBA=1;
    public static final int NEWS_TYPE_JOKES=2;
    private List<Fragment> fragments=new ArrayList<>();
    private List<String> fragmentTitle=new ArrayList<>();
    private TabLayout tl_news;
    private ViewPager viewPager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fg_news, null);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
         tl_news=view.findViewById(R.id.tl_news);
         viewPager=view.findViewById(R.id.vp_news);
         setViewPager();
         viewPager.setOffscreenPageLimit(2);
         tl_news.setupWithViewPager(viewPager);
    }

    private void setViewPager() {
        fragments.add(FgNewsListFragment.newInstance(NEWS_TYPE_TOP));
        fragments.add(FgNewsListFragment.newInstance(NEWS_TYPE_NBA));
        fragments.add(FgNewsListFragment.newInstance(NEWS_TYPE_JOKES));
        fragmentTitle.add("头条");
        fragmentTitle.add("NBA");
        fragmentTitle.add("笑话");
        MyFragmentAdapter adapter=new MyFragmentAdapter(getChildFragmentManager(),fragments,fragmentTitle);
        viewPager.setAdapter(adapter);
    }

}
