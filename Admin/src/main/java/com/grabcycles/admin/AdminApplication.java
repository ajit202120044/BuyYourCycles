package com.grabcycles.admin;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
//@EnableSwagger2
@Configuration
//@EnableWebMvc
@SpringBootApplication(scanBasePackages = {"com.grabcycles.library.*", "com.grabcycles.admin.*"})
@EnableJpaRepositories(value = "com.grabcycles.library.repository")
@EntityScan(value = "com.grabcycles.library.model")

public class AdminApplication {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any()).build();}

    public static void main(String[] args) {


        SpringApplication.run(AdminApplication.class, args);
    }
//    public class SwaggerConfig {
////        @Bean
//        public Docket api(){
//            return new Docket(DocumentationType.SWAGGER_2)
//                    .apiInfo(apiInfo())
//                    .select()
//                    .apis(RequestHandlerSelectors.any())
//                    .paths(PathSelectors.any())
//                    .build();
//        }

//        private ApiInfo apiInfo(){
//            return new ApiInfoBuilder().title("API")
//                    .build();
//        }
//    }

}
