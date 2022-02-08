/*
 * 版权信息: © 聚均科技
 */
package com.zaqbest.walle.infrastructure.config;


import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.List;

/*****************************************************************************
 *创建时间 : 2017年8月22日
 *实现功能 : swagger配置类
 *作者 : xin-zhou
 *版本 : v0.0.1
 * /swagger-ui/index.html
 -----------------------------------------------------------------------------
 *修改记录:
 *日 期 版本 修改人 修改内容
 *2017年8月22日 v0.0.1 xin-zhou 创建
 *****************************************************************************/
@SuppressWarnings("ALL")
@Configuration
@EnableKnife4j
@Profile({"dev","test","preprod"})
public class SwaggerConfig {

	@Bean
	public Docket buildDocket() {
		Docket docket=new Docket(DocumentationType.OAS_30)
				.apiInfo(apiInfo())
				//分组名称
				.groupName("演示系统")
				.select()
				//这里指定Controller扫描包路径(项目路径也行)
				.apis(RequestHandlerSelectors.basePackage("com.zaqbest.walle.controller"))
				.paths(PathSelectors.any())
				.build()
				.securitySchemes(securitySchemes())
				.securityContexts(securityContexts())
				;
		return docket;
	}

	private List<SecurityScheme> securitySchemes() {
		//设置请求头信息
		List<SecurityScheme> result = new ArrayList<>();
		ApiKey apiKey = new ApiKey("authorization", "authorization", "header");
		result.add(apiKey);
		return result;
	}
	private List<SecurityContext> securityContexts() {
		//设置需要登录认证的路径
		List<SecurityContext> result = new ArrayList<>();
		result.add(getContextByPath("/*/.*"));
		return result;
	}

	private SecurityContext getContextByPath(String pathRegex){
		return SecurityContext.builder()
				.securityReferences(defaultAuth())
				.forPaths(PathSelectors.regex(pathRegex))
				.build();
	}

	private List<SecurityReference> defaultAuth() {
		List<SecurityReference> result = new ArrayList<>();
		AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
		AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
		authorizationScopes[0] = authorizationScope;
		result.add(new SecurityReference("authorization", authorizationScopes));
		return result;
	}


	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				// 大标题
				.title("演示平台")
				// 详细描述
				.description("演示平台RestFul API客户端接口文档")
				.termsOfServiceUrl("https://www.baidu.com")
				.contact(new Contact("演示平台", null, null))
				.version("1.0.0")
				.build();
	}


}
