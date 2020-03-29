package com.dicoding.mymoviecatalogue.Activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.dicoding.mymoviecatalogue.Data.MovieData;
import com.dicoding.mymoviecatalogue.R;
import com.google.android.material.appbar.CollapsingToolbarLayout;

public class MovieDetail extends AppCompatActivity {
    String title, year, rate, overview, topBilledCast, release, originalLanguage, runtime, budget, revenue, genre, youtube;
    int image;

    public static final String EXTRA_MOVIE = "test_extra_movie";

    WebView youtubeVideo;
    CollapsingToolbarLayout collapsingToolbar;
    TextView txtYear, txtRate, txtOverview,
            txtTopBilledCast, txtRelease, txtOriginalLanguage,
            txtRunTime, txtBudget, txtRevenue, txtGenre;

    ImageView imgPoster;
    ImageView Back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_detail);

        Typeface bikoBold = Typeface.createFromAsset(getAssets(), "font/biko_bold.otf");


        //DATA YANG AKAN DISET KE LAYOUT
        //title
        collapsingToolbar = findViewById(R.id.collapsing_toolbar);
        //video youtube
        youtubeVideo = findViewById(R.id.youtube);

        imgPoster = findViewById(R.id.image_poster);
        Back = findViewById(R.id.back);
        txtGenre = findViewById(R.id.genre);
        txtRunTime = findViewById(R.id.run_time);
        txtYear = findViewById(R.id.year);
        txtRelease = findViewById(R.id.release);
        txtRate = findViewById(R.id.rating);
        txtTopBilledCast = findViewById(R.id.topBilledCast);
        txtOriginalLanguage = findViewById(R.id.originalLanguage);
        txtBudget = findViewById(R.id.budget);
        txtRevenue = findViewById(R.id.revenue);
        txtOverview = findViewById(R.id.overview);


        MovieData movie = getIntent().getParcelableExtra(EXTRA_MOVIE);

        //title

        if (movie != null) {
            title = movie.getTitle();
        }
        // pengaturan dan inisialisasi collapsing toolbar
        collapsingToolbar.setTitle(title);
        collapsingToolbar.setCollapsedTitleTypeface(bikoBold);
        collapsingToolbar.setExpandedTitleTypeface(bikoBold);

        //youtube
        //pengaturan video youtube
        // setting
        youtubeVideo.setWebViewClient(new WebViewClient());
        youtubeVideo.setWebChromeClient(new WebChromeClient());
        youtubeVideo.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        youtubeVideo.getSettings().setJavaScriptEnabled(true);
        youtubeVideo.getSettings().setPluginState(WebSettings.PluginState.ON);
        youtubeVideo.getSettings().setDefaultFontSize(10);

        youtube = movie.getYoutube();
        muatVideo(youtube);

        image = movie.getPoster();
        imgPoster.setImageResource(image);


        genre = movie.getGenre();
        txtGenre.setText(genre);

        runtime = movie.getRuntime();
        txtRunTime.setText(runtime);

        year = movie.getYear();
        txtYear.setText(year);

        release = movie.getRelease();
        txtRelease.setText(release);

        rate = movie.getScore();
        txtRate.setText(rate);

        topBilledCast = movie.getTopBilledCast();
        txtTopBilledCast.setText(topBilledCast);

        originalLanguage = movie.getOriginalLanguage();
        txtOriginalLanguage.setText(originalLanguage);

        budget = movie.getBudget();
        txtBudget.setText(budget);

        revenue = movie.getRevenue();
        txtRevenue.setText(revenue);

        overview = movie.getOverview();
        txtOverview.setText(overview);

        Back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MovieDetail.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }

    private void muatVideo(String code_youtube) {
        String kodeHTML = "<head></head><body style=\"margin: 0; padding: 0\">" +
                "<iframe width=\"360\" height=\"240\" src=\"https://www.youtube.com/embed/" + code_youtube + "\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>"
                + "</body>";
        youtubeVideo.loadData(kodeHTML, "text/html; charset=utf-8", null);
    }
}
