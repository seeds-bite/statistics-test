package by.test.statistics.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource("classpath:application.properties")
@EnableJpaRepositories(basePackages = "by.test.statistics.repository")
@EnableTransactionManagement
public class H2JpaConfig {

}
