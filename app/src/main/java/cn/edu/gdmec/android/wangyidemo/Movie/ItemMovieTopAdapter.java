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

public class ItemMovieTopAdapter extends RecyclerView.Adapter<ItemMovieTopAdapter.ViewHolder>{
    private List<MoviesBean.SubjectsBean> objects = new ArrayList<MoviesBean.SubjectsBean>();
    private Context context;
  public ItemMovieTopAdapter(Context context){
      this.context=context;
  }
    public void setData(List<MoviesBean.SubjectsBean> objects) {
        this.objects = objects;
    }
    @Override
    public ItemMovieTopAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_top_movie, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemMovieTopAdapter.ViewHolder holder, int position) {
         final MoviesBean.SubjectsBean bean=objects.get(position);
        if (bean==null){
            return;
        }
        Glide.with(context)
                .load(bean.getImages().getSmall())
                .into(holder.ivMovieOn);
        holder.tvMovieOnTitle.setText(bean.getTitle());

        holder.ivMovieOn.setOnClickListener(new View.OnClickListener() {
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


        public ViewHolder(View view){
            super(view);
            ivMovieOn = (ImageView) view.findViewById(R.id.iv_movie);
            tvMovieOnTitle=view.findViewById(R.id.movie_name);
        }
    }
}
