package com.gettingstarted.springtxmgmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SpringTxMgmtApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringTxMgmtApplication.class, args);
	}

}
