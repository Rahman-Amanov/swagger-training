package com.swaggerexample.swagger_training.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.examples.Example;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.media.Content;
import io.swagger.v3.oas.models.media.MediaType;
import io.swagger.v3.oas.models.responses.ApiResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition
public class OpenApiConfig {

    ApiResponse badRequest = new ApiResponse().content(
            new Content().addMediaType("application/json",
                    new MediaType().addExamples("default",
                            new Example().value(
                                    "{\"code\" : 400, " +
                                            "\"status\" : \"Bad Request\", " +
                                            "\"Message\" : \"Bad Request\"}"))));

    ApiResponse internalServerError = new ApiResponse().content(
            new Content().addMediaType("application/json",
                    new MediaType().addExamples("default",
                            new Example().value(
                                    "{\"code\" : 500, " +
                                            "\"status\" : \"internalServerError\", " +
                                            "\"Message\" : \"internalServerError\"}"))));

    ApiResponse successfulResponse = new ApiResponse().content(
            new Content().addMediaType("application/json",
                    new MediaType().addExamples("default",
                            new Example().value(
                                    "{\"name\":\"string\"," +
                                            "\"lastname\":\"string\", " +
                                            "\"age\":0}"))));

    @Bean
    public OpenAPI baseOpenAPI() {

        Components components=new Components();
        components.addResponses("badRequest",badRequest);
        components.addResponses("internalServerError",internalServerError);
        components.addResponses("successfulResponse",successfulResponse);

        return new OpenAPI()
                .info(new Info().title("SpringBootSwagger")
                        .version("1.0.0")
                        .description("Swagger Description"));
    }
}
