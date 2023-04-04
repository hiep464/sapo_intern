package vn.sapo.demo;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class AppTestConfiguration {

    @Bean
    public CacheService cacheService() {
        return new InMemoryCacheService();
    }
}
