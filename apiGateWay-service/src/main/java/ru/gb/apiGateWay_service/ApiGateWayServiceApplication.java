package ru.gb.apiGateWay_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class ApiGateWayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGateWayServiceApplication.class, args);
	}

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("product-service",r->r.path("/api/products/**")
						.uri("http://localhost:8081/"))
				.route("auth-service",r->r.path("/api/auth/**")
						.uri("http://localhost:8082/"))
				.route("cart_service",r->r.path("/api/cart/**")
						.uri("http://localhost:8083/"))
				.route("payment_service",r->r.path("/api/payment/**")
						.uri("http://localhost:8084/"))
				.route("shipping_service",r->r.path("/api/shipping/**")
						.uri("http://localhost:8085/")).build();

	}

}
