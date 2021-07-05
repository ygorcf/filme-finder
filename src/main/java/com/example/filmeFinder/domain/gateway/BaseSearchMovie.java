package com.example.filmeFinder.domain.gateway;

import java.util.List;

public interface BaseSearchMovie {
    List<APIMovie> searchMovie(String searchQuery);
}

