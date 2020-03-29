package com.dicoding.mymoviecatalogue.Activity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.dicoding.mymoviecatalogue.Data.MovieAdapter;
import com.dicoding.mymoviecatalogue.Data.MovieData;
import com.dicoding.mymoviecatalogue.R;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private String[] dataTitle, dataYear, dataRate, dataOverview,
            dataTopBilledCast, dataRelease, dataOriginalLanguage,
            dataRunTime, dataBudget, dataRevenue, dataGenre, dataCodeYoutube;

    private TypedArray dataPoster;
    private MovieAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new MovieAdapter(this);
        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent moveWithObject = new Intent(MainActivity.this, MovieDetail.class);

                MovieData movie = new MovieData();

                movie.setPoster(dataPoster.getResourceId(i, -1));
                movie.setTitle(dataTitle[i]);
                movie.setOverview(dataOverview[i]);
                movie.setGenre(dataGenre[i]);
                movie.setRelease(dataRelease[i]);
                movie.setScore(dataRate[i]);
                movie.setOriginalLanguage(dataOriginalLanguage[i]);
                movie.setRuntime(dataRunTime[i]);
                movie.setYear(dataYear[i]);
                movie.setTopBilledCast(dataTopBilledCast[i]);
                movie.setBudget(dataBudget[i]);
                movie.setRevenue(dataRevenue[i]);
                movie.setYoutube(dataCodeYoutube[i]);


                //mengirim data dengan parcelable
                moveWithObject.putExtra(MovieDetail.EXTRA_MOVIE, movie);
                startActivity(moveWithObject);
            }
        });
    }


    private void addItem() {

        ArrayList<MovieData> movies = new ArrayList<>();

        for (int i = 0; i < dataTitle.length; i++) {

            MovieData movie = new MovieData();

            movie.setPoster(dataPoster.getResourceId(i, -1));
            movie.setTitle(dataTitle[i]);
            movie.setOverview(dataOverview[i]);
            movie.setGenre(dataGenre[i]);
            movie.setRelease(dataRelease[i]);
            movie.setScore(dataRate[i]);
            movie.setOriginalLanguage(dataOriginalLanguage[i]);
            movie.setRuntime(dataRunTime[i]);
            movie.setYear(dataYear[i]);
            movie.setTopBilledCast(dataTopBilledCast[i]);
            movie.setBudget(dataBudget[i]);
            movie.setRevenue(dataRevenue[i]);
            movie.setYoutube(dataCodeYoutube[i]);


            movies.add(movie);
        }
        adapter.setMovies(movies);
    }

    private void prepare() {
        dataPoster = getResources().obtainTypedArray(R.array.movie_poster);

        dataTitle = getResources().getStringArray(R.array.movie_title);
        dataOverview = getResources().getStringArray(R.array.movie_overview);
        dataGenre = getResources().getStringArray(R.array.genre);
        dataRelease = getResources().getStringArray(R.array.movie_status);
        dataRate = getResources().getStringArray(R.array.movie_score);
        dataOriginalLanguage = getResources().getStringArray(R.array.movie_originalLg);
        dataRunTime = getResources().getStringArray(R.array.movie_runtime);
        dataYear = getResources().getStringArray(R.array.movie_year);
        dataTopBilledCast = getResources().getStringArray(R.array.movie_topBilledCast);
        dataBudget = getResources().getStringArray(R.array.movie_budget);
        dataRevenue = getResources().getStringArray(R.array.movie_revenue);
        dataCodeYoutube = getResources().getStringArray(R.array.youtube);
    }
}
