package com.cognizant.apigateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class RateLimitGatewayFilterFactory extends AbstractGatewayFilterFactory<RateLimitGatewayFilterFactory.Config> {

    // Map to hold request timestamps for each IP Address
    private final Map<String, List<Long>> requestHistory = new ConcurrentHashMap<>();

    public RateLimitGatewayFilterFactory() {
        super(Config.class);
    }

    @Override
    public List<String> shortcutFieldOrder() {
        List<String> fields = new ArrayList<>();
        fields.add("limit");
        fields.add("duration");
        return fields;
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            String ip = exchange.getRequest().getRemoteAddress() != null 
                    ? exchange.getRequest().getRemoteAddress().getAddress().getHostAddress() 
                    : "unknown";
            
            long now = Instant.now().getEpochSecond();
            int limit = config.getLimit();
            int duration = config.getDuration();

            requestHistory.putIfAbsent(ip, new ArrayList<>());
            List<Long> timestamps = requestHistory.get(ip);

            synchronized (timestamps) {
                // Remove timestamps older than the duration window
                timestamps.removeIf(t -> t < now - duration);

                if (timestamps.size() >= limit) {
                    exchange.getResponse().setStatusCode(HttpStatus.TOO_MANY_REQUESTS);
                    return exchange.getResponse().setComplete();
                }

                timestamps.add(now);
            }

            return chain.filter(exchange);
        };
    }

    public static class Config {
        private int limit = 5; // Default 5 requests
        private int duration = 10; // Default per 10 seconds

        public int getLimit() {
            return limit;
        }

        public void setLimit(int limit) {
            this.limit = limit;
        }

        public int getDuration() {
            return duration;
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }
    }
}
