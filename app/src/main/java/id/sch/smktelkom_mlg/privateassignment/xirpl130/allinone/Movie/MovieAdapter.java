package id.sch.smktelkom_mlg.privateassignment.xirpl130.allinone.Movie;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import id.sch.smktelkom_mlg.privateassignment.xirpl130.allinone.R;

/**
 * Created by Nugrahanto on 12/05/2017.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    private List<MovieListItem> movieListItems;
    private Context context; //mode default, hanya bisa diakses dengan dipanggil

    public MovieAdapter(List<MovieListItem> movieListItems, Context context) {
        this.movieListItems = movieListItems;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final MovieListItem movieListItem = movieListItems.get(position);

//        holder.imageViewOtof.setImageURI(movieListItem.getImageUrl());
        holder.textViewHead.setText(movieListItem.getHead());
        holder.textViewDesc.setText(movieListItem.getDesc());

        Glide
                .with(context)
                .load(movieListItem.getImageUrl())
                .into(holder.imageViewOtof);

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(context, "JOS " + movieListItem.getHead(), Toast.LENGTH_LONG).show();

                Intent singleBlogIntent = new Intent(context, MovieDetailActivity.class);
                singleBlogIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); //addFLags membuka activity dari fragment
                singleBlogIntent.putExtra("blog_id", position); //position untuk menentukan posisi di array
                context.startActivity(singleBlogIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return movieListItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewHead;
        public TextView textViewDesc;
        public ImageView imageViewOtof;
        public LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            textViewHead = (TextView) itemView.findViewById(R.id.textViewHead);
            textViewDesc = (TextView) itemView.findViewById(R.id.textViewDesc);
            imageViewOtof = (ImageView) itemView.findViewById(R.id.imageViewOtof);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.LinearLayout);
        }
    }
}
