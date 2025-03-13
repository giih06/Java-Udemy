package com.github.giih06.arquiteturaspring;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
@EnableConfigurationProperties // Libera a criação de uma classe para representar o application properties
public class Application {

	public static void main(String[] args) {
		// SpringApplication.run(Application.class, args);
		SpringApplicationBuilder builder = new SpringApplicationBuilder(Application.class);

		builder.bannerMode(Banner.Mode.OFF);
		builder.profiles("producao", "homologacao");
		// builder.lazyInitialization(true); // todos os beans serão lazy por padrão, ou seja, só serão instanciados quando utilizados

		builder.run(args);

		// contexto da aplicação já iniciada
		ConfigurableApplicationContext applicationContext = builder.context();

		ConfigurableEnvironment envoirment = applicationContext.getEnvironment();
		String applicationName = envoirment.getProperty("spring.application.name");
		System.out.println("Nome da aplicação: " + applicationName);

		ExemploValue value = applicationContext.getBean(ExemploValue.class);
		value.imprimirVariavel();

		AppProperties properties = applicationContext.getBean(AppProperties.class);
		System.out.println(properties.getValor1());
	}

}
