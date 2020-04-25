package com.example.aspect.configuration;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class TesteInterceptor implements ClientHttpRequestInterceptor {

    @Override public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] body, ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {
	HttpHeaders headers = httpRequest.getHeaders();
	headers.add("user", "ramon");
	headers.add("pass", "admin");
	ClientHttpResponse response = clientHttpRequestExecution.execute(httpRequest, body);
	return response;
    }
}
