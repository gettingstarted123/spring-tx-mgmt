package com.gettingstarted.springtxmgmt.config;



import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;

@Configuration
public class AppConfig {
	
	@Bean(name="myDataSource")
    @ConfigurationProperties("spring.datasource")
	public DataSource myDataSource() {
        return DataSourceBuilder.create().build();
    }

}
