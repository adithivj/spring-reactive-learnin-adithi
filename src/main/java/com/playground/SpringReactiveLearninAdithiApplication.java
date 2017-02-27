package com.playground;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;

import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;

import org.springframework.web.reactive.function.RouterFunction;
import org.springframework.web.reactive.function.RouterFunctions;


import reactor.ipc.netty.http.server.HttpServer;

import static org.springframework.web.reactive.function.RequestPredicates.GET;

import java.io.IOException;

@SpringBootApplication
public class SpringReactiveLearninAdithiApplication {

	@Bean
	RouterFunction<?> router (PersonHandler handler) {
		return RouterFunctions.route( GET ("/persons"), handler::all)
				.and(RouterFunctions.route (GET("/persons/{id}"), handler::byId));
	}

	@Bean
	public  HttpServer startReactorServer(RouterFunction<?> router) throws InterruptedException {
		HttpHandler httpHandler = RouterFunctions.toHttpHandler(router);
		ReactorHttpHandlerAdapter adapter = new ReactorHttpHandlerAdapter(httpHandler);
		HttpServer server = HttpServer.create(8090);
		server.newHandler(adapter).block();
		return server;
	}
	public static void main(String[] args) throws IOException {
		SpringApplication.run(SpringReactiveLearninAdithiApplication.class, args);
		System.out.println("Press ENTER to exit.");
        System.in.read();
		
	}
}
