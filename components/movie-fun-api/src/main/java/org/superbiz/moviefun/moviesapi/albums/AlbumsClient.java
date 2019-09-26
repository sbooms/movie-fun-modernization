package org.superbiz.moviefun.moviesapi.albums;


import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestOperations;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

import static org.springframework.http.HttpMethod.GET;

public class AlbumsClient {

    private final String albumsUrl;
    private final RestOperations restOperations;
    private static ParameterizedTypeReference<List<AlbumInfo>> albumListType = new ParameterizedTypeReference<List<AlbumInfo>>() {
    };
    public AlbumsClient(String albumsUrl, RestOperations restOperations) {
        this.albumsUrl = albumsUrl;
        this.restOperations = restOperations;
    }

    public List<AlbumInfo> getAlbums() {
        return (List<AlbumInfo>) restOperations.exchange(albumsUrl, GET, null, albumListType).getBody();
    }

    public List<AlbumInfo> find(long albumId) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(albumsUrl)
                .queryParam("albumId", albumId);

        return (List<AlbumInfo>) restOperations.exchange(builder.toUriString(), GET, null, albumListType).getBody();
    }

    public void addAlbum(AlbumInfo album) {
        restOperations.postForEntity(albumsUrl, album, AlbumInfo.class);
    }
}
