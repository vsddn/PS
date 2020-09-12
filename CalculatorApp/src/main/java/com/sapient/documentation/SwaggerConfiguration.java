package com.sapient.documentation;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

public class SwaggerConfiguration {
	@EnableSwagger2
	@Configuration
	public static class SwaggerConfig {
		
		private static final Contact DEFAULT_CONTACT = new Contact("Vijay Singh","","");
		private static final ApiInfo DEFAULT_API_INFO = new ApiInfo("Date Time Calculator API",
										"Date Time Calculator Documentation", "1.0", "urn:tos",
											DEFAULT_CONTACT, "Apache 2.0",
		          "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList<VendorExtension>());

		@Bean
		public Docket api() {
			return new Docket(DocumentationType.SWAGGER_2)
					.apiInfo(DEFAULT_API_INFO);
		}
	}

}
