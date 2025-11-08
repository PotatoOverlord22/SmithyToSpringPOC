package com.uaic.smithypoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@ComponentScan(
    basePackages = "com.uaic.smithypoc",
    excludeFilters = @ComponentScan.Filter(
        type = FilterType.REGEX,
        pattern = "com\\.uaic\\.smithypoc\\.generated\\.api\\..*Controller"
    )
)
public class SmithypocApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmithypocApplication.class, args);
	}

}
