package routine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import java.math.BigDecimal;
@SpringBootApplication
//添加过滤器
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
//@EnableAutoConfiguration
public class BackstageApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(BackstageApplication.class, args);
		/*SpringApplication app = new SpringApplication(BackstageApplication.class);
		 Environment environment = app.run(args).getEnvironment();*//*
		BigDecimal bd=new BigDecimal("0.22");
		System.out.println(bd.compareTo(BigDecimal.ZERO)==1);
		System.out.println(" / ".split("/").length);*/
	}
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(BackstageApplication.class);
	}

}
