package com.client.ws.rasplus.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springdoc.core.models.GroupedOpenApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfiguration {

  @Bean
  fun customOpenAPI(): OpenAPI {
    return OpenAPI()
      .info(Info().title("Rasplus API").version("1.0.0"))
  }

  @Bean
  fun rasplusOpenApi(): GroupedOpenApi {
    return GroupedOpenApi.builder()
      .group("rasplus")
      .pathsToMatch("/**")
      .build()
  }
}