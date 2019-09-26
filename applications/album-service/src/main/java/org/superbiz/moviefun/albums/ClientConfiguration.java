package org.superbiz.moviefun.albums;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ClientConfiguration {

    @Value("${albums.url}") String albumsUrl;

    @Bean
    public RestOperations restOperations() {
        return new RestTemplate();
    }

    @Bean
    public AlbumsBean albumsBean(RestOperations restOperations) {
        return new AlbumsBean(albumsUrl, restOperations);
    }
}