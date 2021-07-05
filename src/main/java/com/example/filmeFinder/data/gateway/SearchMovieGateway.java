package com.example.filmeFinder.data.gateway;

import com.example.filmeFinder.domain.gateway.APIMovie;
import com.example.filmeFinder.domain.gateway.BaseSearchMovie;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.MalformedInputException;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

public class SearchMovieGateway implements BaseSearchMovie {
    @Override
    public List<APIMovie> searchMovie(String searchQuery) {
		try {
		    var params = new HashMap<String, String>();
            params.put("query", searchQuery);
            params.put("include_adult", "true");
            params.put("page", "1");
            params.put("language", "en-US");
            params.put("api_key", "6a0b8b07a289610a8833bd45715e5dc3");
			var movies = this.sendRequest("https://api.themoviedb.org/3/search/movie", params);

			var apiMovies = new ArrayList<APIMovie>();
            for (Object movieObj : movies.getJSONArray("results")) {
                var movie = (JSONObject) movieObj;
                apiMovies.add(new APIMovie(
                        movie.getString("title"),
                        movie.getString("original_title"),
                        movie.getJSONArray("genre_ids").toString(),
                        movie.getString("release_date"),
                        movie.getBoolean("adult"),
                        movie.getDouble("popularity"),
                        movie.getInt("vote_count")
                ));
            }
            return apiMovies;
		} catch (Exception e) {
			System.err.print(e);
            return new ArrayList<APIMovie>();
		}
    }

    private JSONObject sendRequest(String urlString, Map<String, String> params) throws MalformedInputException, IOException, ProtocolException {
        URL url = new URL(urlString + "?" + ParameterStringBuilder.getParamsString(params));
        var connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        connection.setDoOutput(true);
        connection.setRequestProperty("Accept", "application/json");
        connection.setRequestProperty("Content-Type", "application/json");

//         try (OutputStream oStream = connection.getOutputStream()) {
//             System.out.println();
//             oStream.write(ParameterStringBuilder.getParamsString(params).getBytes("utf-8"));
//         }
//        connection.connect();
        System.out.println(connection.getResponseCode());
        BufferedReader in = new BufferedReader(
            new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        return new JSONObject(content.toString());
    }

    public class ParameterStringBuilder {
        public static String getParamsString(Map<String, String> params)
                throws UnsupportedEncodingException {
            StringBuilder result = new StringBuilder();

            for (Map.Entry<String, String> entry : params.entrySet()) {
                result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
                result.append("=");
                result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
                result.append("&");
            }

            String resultString = result.toString();
            return resultString.length() > 0
                    ? resultString.substring(0, resultString.length() - 1)
                    : resultString;
        }
    }
}