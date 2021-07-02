package com.example.filmeFinder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

@SpringBootApplication
@RestController
public class FilmeFinderApplication {

	@RequestMapping("/")
	public String home() {
		try {
			URL url = new URL("https://randomuser.me/api/");
			var connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			// connection.setDoInput(true);
			connection.setRequestProperty("Content-Type", "application/json");
			connection.connect();
	
			// try (OutputStream oStream = connection.getOutputStream()) {
			// 	oStream.write(0);
			// 	oStream.close();
			// }
	
			var ret = "";
			BufferedReader in = new BufferedReader(
				new InputStreamReader(connection.getInputStream()));
			String inputLine;
			StringBuffer content = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				content.append(inputLine);
			}
			in.close();
			// JSONObject obj = new JSONObject(inputStream.readAllBytes().toString());
			ret = content.toString();
			// inputStream.close();
			return ret;
		} catch (Exception e) {
			System.err.print(e);
			return e.getMessage();
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(FilmeFinderApplication.class, args);
	}

}
