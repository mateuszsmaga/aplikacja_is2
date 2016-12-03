package main;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

import database.ResultDAO;
import database.ResultJDBCTemplate;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter{
	
	//Dodanie kontrolerów
	@Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/app").setViewName("app");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/logout").setViewName("app");
        registry.addViewController("/login").setViewName("login");
    }
	
	//Podpięcie do zewnetrznej bazy danych
	@Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://sql7.freemysqlhosting.net:3306/a");
        dataSource.setUsername("a");
        dataSource.setPassword("a");
        return dataSource;
    }
	
	//pobieranie dataSource
	@Bean
	public ResultDAO getResultDAO(){
		return new ResultJDBCTemplate(getDataSource());
	}
	
	//konfigurowanie sciezki dostepu do plikow jsp
    @Bean
    public ITemplateResolver templateResolver() {
        SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
        resolver.setPrefix("WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        resolver.setCacheable(false);
        return resolver;
    } 
    
}
