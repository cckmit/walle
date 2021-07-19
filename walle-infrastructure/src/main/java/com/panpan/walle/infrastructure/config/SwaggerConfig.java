/*
 * 版权信息: © 聚均科技
 */
package com.panpan.walle.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/*****************************************************************************
 *创建时间 : 2017年8月22日
 *实现功能 : swagger配置类
 *作者 : xin-zhou
 *版本 : v0.0.1
 -----------------------------------------------------------------------------
 *修改记录:
 *日 期 版本 修改人 修改内容
 *2017年8月22日 v0.0.1 xin-zhou 创建
 *****************************************************************************/
@Configuration
@EnableSwagger2
@Profile({"dev","sit"})
public class SwaggerConfig {

	@Bean
	public Docket buildDocket() {
		List<Parameter> paramList = new ArrayList<>();
		// paramList.add(BuilderHeaderParamter());
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("聚均科技平台").apiInfo(apiInfo()).globalOperationParameters(paramList).select()
				.apis(RequestHandlerSelectors.basePackage("com.fusionfintrade")).paths(PathSelectors.any()).build();

	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("聚均科技平台")// 大标题
				.description("聚均科技平台RestFul API客户端接口文档")// 详细描述
				.termsOfServiceUrl("https://www.fusionfintrade.com").contact(new Contact("聚均科技新技术事业群", null, null))// 作者
				.version("1.0.0")// 版本
				.build();
	}
}
