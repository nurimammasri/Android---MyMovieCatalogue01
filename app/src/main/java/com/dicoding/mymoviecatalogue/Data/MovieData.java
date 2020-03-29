package com.dicoding.mymoviecatalogue.Data;

import android.os.Parcel;
import android.os.Parcelable;

public class MovieData implements Parcelable {

    private int poster;
    private String title;
    private String year;
    private String score;
    private String overview;
    private String topBilledCast;
    private String release;
    private String originalLanguage;
    private String runtime;
    private String budget;
    private String revenue;
    private String genre;
    private String youtube;

    public MovieData() {

    }


    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getTopBilledCast() {
        return topBilledCast;
    }

    public void setTopBilledCast(String topBilledCast) {
        this.topBilledCast = topBilledCast;
    }

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public String getRevenue() {
        return revenue;
    }

    public void setRevenue(String revenue) {
        this.revenue = revenue;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getYoutube() {
        return youtube;
    }

    public void setYoutube(String youtube) {
        this.youtube = youtube;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(poster);
        dest.writeString(title);
        dest.writeString(year);
        dest.writeString(score);
        dest.writeString(overview);
        dest.writeString(topBilledCast);
        dest.writeString(release);
        dest.writeString(originalLanguage);
        dest.writeString(runtime);
        dest.writeString(budget);
        dest.writeString(revenue);
        dest.writeString(genre);
        dest.writeString(youtube);
    }


    private MovieData(Parcel in) {
        poster = in.readInt();
        title = in.readString();
        year = in.readString();
        score = in.readString();
        overview = in.readString();
        topBilledCast = in.readString();
        release = in.readString();
        originalLanguage = in.readString();
        runtime = in.readString();
        budget = in.readString();
        revenue = in.readString();
        genre = in.readString();
        youtube = in.readString();
    }

    public static final Creator<MovieData> CREATOR = new Creator<MovieData>() {
        @Override
        public MovieData createFromParcel(Parcel in) {
            return new MovieData(in);
        }

        @Override
        public MovieData[] newArray(int size) {
            return new MovieData[size];
        }
    };
}
