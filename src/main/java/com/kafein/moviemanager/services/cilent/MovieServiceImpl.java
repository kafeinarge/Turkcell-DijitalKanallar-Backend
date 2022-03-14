package com.kafein.moviemanager.services.cilent;


import com.kafein.moviemanager.constants.TmdbApiConstants;
import com.kafein.moviemanager.model.dto.model.MovieDetail;
import com.kafein.moviemanager.model.dto.response.Response;
import com.kafein.moviemanager.model.dto.response.SearchMovieResponse;
import com.kafein.moviemanager.model.response.MovieDetailResponse;
import com.kafein.moviemanager.model.response.MovieSearchResponse;
import com.kafein.moviemanager.utils.MovieManagerUtil;
import com.kafein.moviemanager.utils.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class MovieServiceImpl {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private TmdbApiConstants apiConstants;

    public byte[] getMovieImagine(String filePath){
        return restTemplate.getForObject(apiConstants.getImagineBaseUrl() + filePath, byte[].class);
    }

    public MovieDetailResponse getMovieDetail(Integer movieId){
        MovieDetail clientResponse = null;
        Response errorResponse = null;
        try{
            clientResponse = restTemplate.getForObject(apiConstants.getMovieDetail(), MovieDetail.class, movieId, apiConstants.getApiKey());
        }catch (HttpClientErrorException e){
            log.error("Client Movie Detail response get error!", e.getMessage(), e);
            errorResponse = MovieManagerUtil.jsonStringToObjet(e.getResponseBodyAsString());
        }
        MovieDetailResponse response = new MovieDetailResponse(clientResponse);
        ResponseUtil.addResultIntoResponseObj(response, errorResponse);
        return response;
    }

    public MovieSearchResponse searchMovie(String query) {
        SearchMovieResponse clientResponse = null;
        Response errorResponse = null;
        try{
            clientResponse = restTemplate.getForObject(apiConstants.getSearchMovie(), SearchMovieResponse.class, apiConstants.getApiKey(), query);
        }catch (HttpClientErrorException e){
            log.error("Client  Movie Search response get error!", e.getMessage(), e);
            errorResponse = MovieManagerUtil.jsonStringToObjet(e.getResponseBodyAsString());
        }
        MovieSearchResponse response = new MovieSearchResponse();
        if(clientResponse != null){
            response.convertFromClientResponse(clientResponse);
        }
        ResponseUtil.addResultIntoResponseObj(response, errorResponse);
        return response;
    }
}
