package com.dicoding.mymoviecatalogue.Data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dicoding.mymoviecatalogue.R;

import java.util.ArrayList;

public class MovieAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<MovieData> movies = new ArrayList<>();

    public void setMovies(ArrayList<MovieData> movies) {
        this.movies = movies;
    }

    public MovieAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int position) {
        return movies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View itemView = view;
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_list_view, viewGroup, false);
        }

        ViewHolder viewHolder = new ViewHolder(itemView);
        MovieData movies = (MovieData) getItem(position);
        viewHolder.bind(movies);
        return itemView;
    }

    private class ViewHolder {
        private TextView txtTitle, txtYear, txtRate, txtOverview, txtRelease,
                txtRunTime, txtGenre;

        private ImageView imgPoster;

        ViewHolder(View view) {
            imgPoster = view.findViewById(R.id.img_poster);
            txtRate = view.findViewById(R.id.rating);
            txtTitle = view.findViewById(R.id.title);
            txtRunTime = view.findViewById(R.id.run_time);
            txtGenre = view.findViewById(R.id.genre);
            txtOverview = view.findViewById(R.id.overview);
            txtYear = view.findViewById(R.id.year);
            txtRelease = view.findViewById(R.id.release);
        }

        void bind(MovieData movies) {
            imgPoster.setImageResource(movies.getPoster());
            txtRate.setText(movies.getScore());
            txtTitle.setText(movies.getTitle());
            txtRunTime.setText(movies.getRuntime());
            txtGenre.setText(movies.getGenre());
            txtOverview.setText(movies.getOverview());
            txtYear.setText(movies.getYear());
            txtRelease.setText(movies.getRelease());
        }
    }


}
