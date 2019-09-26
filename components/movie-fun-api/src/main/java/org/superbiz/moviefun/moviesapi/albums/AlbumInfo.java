package org.superbiz.moviefun.moviesapi.albums;

import java.util.Objects;

public class AlbumInfo {
    private  String artist;
    private  String title;
    private  int year;
    private  int rating;

    public AlbumInfo(String artist, String title, int year, int rating) {

        this.artist = artist;
        this.title = title;
        this.year = year;
        this.rating = rating;
    }

    public AlbumInfo() {
    }

    public String getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public int getRating() {
        return rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlbumInfo albumInfo = (AlbumInfo) o;
        return year == albumInfo.year &&
                rating == albumInfo.rating &&
                Objects.equals(artist, albumInfo.artist) &&
                Objects.equals(title, albumInfo.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(artist, title, year, rating);
    }

    @Override
    public String toString() {
        return "AlbumInfo{" +
                "artist='" + artist + '\'' +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", rating=" + rating +
                '}';
    }
}
