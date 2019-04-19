package com.kabasiji.springboot.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * swagger的配置
 *
 * @author huang_kangjie
 * @create 2018-08-23 16:50
 **/
@Configuration
@EnableSwagger2
public class Swagger2UiConfiguration {
    @Value("${swagger.show}")
    private boolean swaggerShow = false;
    @Bean
    public Docket api() {

        //设置请求头
        List<Parameter> pars = new ArrayList<>();
        ParameterBuilder token = new ParameterBuilder();
        token.name("_tk").description("token").modelRef(new ModelRef("string")).parameterType("header").required(false);
        pars.add(token.build());

        //Register the controllers to swagger
        //Also it is configuring the Swagger Docket
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(swaggerShow)
                .groupName("SpringBoot-API")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.kabasiji.springboot.controller"))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(pars)
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("SpringBoot-API")
                .description("SpringBoot-API")
                .version("V1.0.0")
                .build();
    }

    // spring boot 2 才需要
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        if (this.swaggerShow) {
//            registry.addResourceHandler("swagger-ui.html")
//                    .addResourceLocations("classpath:/META-INF/resources/");
//
//            registry.addResourceHandler("/webjars/**")
//                    .addResourceLocations("classpath:/META-INF/resources/webjars/");
//        }
//    }
}
