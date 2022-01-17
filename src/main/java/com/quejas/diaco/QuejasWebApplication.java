package com.quejas.diaco;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import th.co.geniustree.springdata.jpa.repository.support.JpaSpecificationExecutorWithProjectionImpl;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication/*(scanBasePackages = {"com.quejas.diaco"})*/
/*@EnableJpaRepositories(repositoryBaseClass = JpaSpecificationExecutorWithProjectionImpl.class,
        basePackages = {"com.quejas.diaco.repository"})*/
public class QuejasWebApplication  implements Serializable {

    /**
     * Serial de la clase.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Crea una nueva instancia de <code>Application</code>.
     */
    public QuejasWebApplication() {
        // SonarFix
    }
    
    @Bean
    public static CustomScopeConfigurer viewScope() {
        CustomScopeConfigurer configurer = new CustomScopeConfigurer();
        ViewScope ambito = new ViewScope();
        Map ambitos = new HashMap<String, Object>();
        ambitos.put("view", ambito);
        configurer.setScopes(ambitos);
        return configurer;
    }

    /*protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Log4jConfig.class, Application.class);
    }*/

	public static void main(String[] args) {
		SpringApplication.run(QuejasWebApplication.class, args);
	}

}
