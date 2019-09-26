package org.superbiz.moviefun.moviesapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.superbiz.moviefun.moviesapi.albums.AlbumFixtures;
import org.superbiz.moviefun.moviesapi.albums.AlbumInfo;
import org.superbiz.moviefun.moviesapi.albums.AlbumsClient;
import org.superbiz.moviefun.moviesapi.movies.MovieFixtures;
import org.superbiz.moviefun.moviesapi.movies.MovieInfo;
import org.superbiz.moviefun.moviesapi.movies.MoviesClient;

import java.util.Map;

public class HomeController {

    private final AlbumsClient albumsClient;
    private final AlbumFixtures albumFixtures;
    private final MoviesClient moviesBean;
    private final MovieFixtures movieFixtures;

    public HomeController(AlbumsClient albumsClient, AlbumFixtures albumFixtures, MoviesClient moviesBean, MovieFixtures movieFixtures) {
        this.albumsClient = albumsClient;
        this.albumFixtures = albumFixtures;
        this.moviesBean = moviesBean;
        this.movieFixtures = movieFixtures;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/setup")
    public String setup(Map<String, Object> model) {
        for (MovieInfo movie : movieFixtures.load()) {
            moviesBean.addMovie(movie);
        }

        model.put("movies", moviesBean.getMovies());

        for (AlbumInfo album : albumFixtures.load()) {
            albumsClient.addAlbum(album);
        }

        model.put("albums", albumsClient.getAlbums());

        return "setup";
    }
}
