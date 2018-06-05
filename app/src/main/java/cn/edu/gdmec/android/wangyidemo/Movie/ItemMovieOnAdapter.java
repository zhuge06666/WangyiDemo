package cn.edu.gdmec.android.wangyidemo.Movie;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import cn.edu.gdmec.android.wangyidemo.ADetailActivity;
import cn.edu.gdmec.android.wangyidemo.Bean.MoviesBean;
import cn.edu.gdmec.android.wangyidemo.R;

/**
 * Created by apple on 18/6/5.
 */

public class ItemMovieOnAdapter extends RecyclerView.Adapter<ItemMovieOnAdapter.ViewHolder>{
    private List<MoviesBean.SubjectsBean> objects = new ArrayList<MoviesBean.SubjectsBean>();
    private Context context;
  public ItemMovieOnAdapter(Context context){
      this.context=context;
  }
    public void setData(List<MoviesBean.SubjectsBean> objects) {
        this.objects = objects;
    }
    @Override
    public ItemMovieOnAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_movie_on, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemMovieOnAdapter.ViewHolder holder, int position) {
         final MoviesBean.SubjectsBean bean=objects.get(position);
        if (bean==null){
            return;
        }
        Glide.with(context)
                .load(bean.getImages().getSmall())
                .into(holder.ivMovieOn);
        holder.tvMovieOnTitle.setText(bean.getTitle());
        String directors="";
        for(int i=0;i<bean.getDirectors().size();i++){
            if (i==bean.getDirectors().size()-1){
                directors+=bean.getDirectors().get(i).getName();
            }else{
                directors+=bean.getDirectors().get(i).getName()+"/";
            }
        }
        holder.tvMovieOnDirectors.setText("导演："+directors);
        String casts="";

        if (bean.getCasts().size()!=0){
            for(int i=0;i<bean.getCasts().size();i++){
                if (i==bean.getCasts().size()-1){
                    casts+=bean.getCasts().get(i).getName();
                }else{
                    casts+=bean.getCasts().get(i).getName()+"/";
                }
            }
            holder.tvMovieOnCasts.setText(casts);
        }else {
            holder.tvMovieOnCasts.setText("主演：佚名");
        }

        String gen="";
        for(int i=0;i<bean.getGenres().size();i++){
            if (i==bean.getGenres().size()-1){
                gen+=bean.getGenres().get(i);
            }else{
                gen+=bean.getGenres().get(i)+"/";
            }
        }
        holder.tvMovieOnGenres.setText("类型："+gen);
        holder.tvMovieOnRating.setText("评分："+bean.getRating().getAverage());
        holder.rvMovieOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ADetailActivity.class);
                intent.putExtra("url",bean.getAlt());
                intent.putExtra("title", bean.getTitle());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return objects.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView ivMovieOn;
        private TextView tvMovieOnTitle;
        private TextView tvMovieOnDirectors;
        private TextView tvMovieOnCasts;
        private TextView tvMovieOnGenres;
        private TextView tvMovieOnRating;
        private RelativeLayout rvMovieOn;

        public ViewHolder(View view){
            super(view);
            ivMovieOn = (ImageView) view.findViewById(R.id.iv_movie_on);
            tvMovieOnTitle = (TextView) view.findViewById(R.id.tv_movie_on_title);
            tvMovieOnDirectors = (TextView) view.findViewById(R.id.tv_movie_on_directors);
            tvMovieOnCasts = (TextView) view.findViewById(R.id.tv_movie_on_casts);
            tvMovieOnGenres = (TextView) view.findViewById(R.id.tv_movie_on_genres);
            tvMovieOnRating = (TextView) view.findViewById(R.id.tv_movie_on_rating);
            rvMovieOn = (RelativeLayout) view.findViewById(R.id.rl_movie_on);
        }
    }
}
