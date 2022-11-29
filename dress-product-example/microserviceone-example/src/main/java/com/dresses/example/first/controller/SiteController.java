package com.dresses.example.first.controller;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class SiteController {
	
	@Autowired
	private static HttpClient client =
		      HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(10)).build();
	
	@GetMapping("/second/comunicate")
	public String getResponseCodeSecond() throws IOException, InterruptedException {
		String url = "http://localhost:8082/comunicate";
	    var getRequest = java.net.http.HttpRequest.newBuilder().uri(URI.create(url)).GET().build();
	    var getResponse = client.send(getRequest, BodyHandlers.ofString());
	    return getResponse.body();
	}
	
	@GetMapping("/third/comunicate")
	public String getResponseCodeThird() throws IOException, InterruptedException {
		String url = "http://localhost:8008/comunicate";
	    var getRequest = java.net.http.HttpRequest.newBuilder().uri(URI.create(url)).GET().build();
	    var getResponse = client.send(getRequest, BodyHandlers.ofString());
	    return getResponse.body();
	}
	
	@GetMapping("/second/readproducts")
	public String readAllProducts() throws IOException, InterruptedException {
		String url = "http://localhost:8082/readproducts";
	    var getRequest = java.net.http.HttpRequest
	    							  .newBuilder()
	    							  .uri(URI.create(url))
	    							  .GET()
	    							  .build();
	    var getResponse = client.send(getRequest, BodyHandlers.ofString());
	    return getResponse.body();
	}
	
	@GetMapping("/third/controldatabase")
	public String controllingDatabase() throws IOException, InterruptedException {
		String url = "http://localhost:8008/databasecontrolling";
	    var getRequest = java.net.http.HttpRequest
	    							  .newBuilder()
	    							  .uri(URI.create(url))
	    							  .GET()
	    							  .build();
	    var getResponse = client.send(getRequest, BodyHandlers.ofString());
	    return getResponse.body();
	}
	
}
