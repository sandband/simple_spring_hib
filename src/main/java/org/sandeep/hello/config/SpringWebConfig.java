package org.sandeep.hello.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;

@Configuration
@EnableWebMvc
@ComponentScan({ "org.sandeep.hello.web" })
public class SpringWebConfig extends WebMvcConfigurerAdapter {

	private ApplicationContext applicationContext;

	public void setApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	@Bean
	public ViewResolver viewResolver() {
		ThymeleafViewResolver vr = new ThymeleafViewResolver();
		vr.setTemplateEngine(templateEngine());
		vr.setCharacterEncoding("UTF-8");
		return vr;
	}

	@Bean
	public TemplateEngine templateEngine() {
		SpringTemplateEngine te = new SpringTemplateEngine();
		te.setTemplateResolver(templateResolver());
		te.setEnableSpringELCompiler(true);
		return te;
	}

	@Bean
	public ITemplateResolver templateResolver() {
		SpringResourceTemplateResolver tr = new SpringResourceTemplateResolver();
		tr.setApplicationContext(applicationContext);
		tr.setPrefix("/WEB-INF/templates/");
		tr.setSuffix(".html");
		tr.setTemplateMode(TemplateMode.HTML);
		return tr;
	}

}
